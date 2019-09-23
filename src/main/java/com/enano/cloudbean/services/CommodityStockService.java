package com.enano.cloudbean.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enano.cloudbean.dtos.BasicIncomeInfoDto;
import com.enano.cloudbean.dtos.CommodityDto;
import com.enano.cloudbean.dtos.ProcessDto;
import com.enano.cloudbean.entities.Commodity;
import com.enano.cloudbean.entities.CommodityStock;
import com.enano.cloudbean.entities.GrainType;
import com.enano.cloudbean.entities.Income;
import com.enano.cloudbean.entities.IncomeProcess;
import com.enano.cloudbean.entities.Outcome;
import com.enano.cloudbean.repositories.CommodityStockRepository;
import com.enano.cloudbean.utils.CommodityQuality;
import com.enano.cloudbean.validations.AnalysisValidation;

@Service
public class CommodityStockService {
  
  private Logger LOGGER = LogManager.getLogger(CommodityStockService.class);

  private ModelMapper modelMapper = new ModelMapper();

  @Autowired
  private CommodityStockRepository commodityStockRepo;

  @Autowired
  private IncomeService incomeService;

  @Autowired
  private QualityTypeService qualityTypeSrv;

  /** Adding stock when new incomes are saved
   * 
   * @param income
   */
  public void addNewIncome(Income income) {
    CommodityStock stock = new CommodityStock();
    stock.setAmount(income.getGrossWeight() - income.getTruckWeight());
    stock.setBagQuantity(Integer.valueOf(income.getBagQuantity()));
    stock.setLocationInPlant(income.getLocationInPlant());
    stock.setObs(income.getObs());
    stock.setOwner(income.getWaybillOwner().getId());
    stock.setPackagingType(income.getPackagingType());
    stock.setGrainType(income.getGrainType());
    stock.setQualityType(qualityTypeSrv.getQualityTypeByName(CommodityQuality.NATURAL.getType()));
    stock.setIncomeId(income.getId());
    stock.setHarvesting(income.getHarvesting());
    if (AnalysisValidation.isValidAnalysis(income.getAnalysis())) {
      stock.setGramaje(Math.round(income.getAnalysis().getGramaje()));
    }
    commodityStockRepo.save(stock);
  }

  /** Edit gramaje in stock when user load analysis later
   * 
   * @param income
   */
  public void editCommodityAccordingNewAnalysis(Income income) {
    CommodityStock stock = commodityStockRepo.findByIncomeId(income.getId());
    if (income.getAnalysis() != null) {
      stock.setGramaje(Math.round(income.getAnalysis().getGramaje()));
    }
    commodityStockRepo.save(stock);
  }

  /** Calculate and save Stock when new Process is added to db
   * 
   * @param processId
   * @param processDto
   */
  public void addNewProcess(ProcessDto processDto) {
    try {
      removingNaturalStocks(processDto);
      addingNewStocks(processDto);
    } catch (Exception e) {
      LOGGER.error("[addNewProcess] - Error updating stock.");
    }
  }
  
  /** Removing stock when an outcome is produced  
   * 
   * @param outcome
   * @return the commodityStock modified
   */
  public CommodityStock withdrawCommodityStock(Outcome outcome) {
    CommodityStock actualCommodityStock =
        commodityStockRepo.getOne(outcome.getCommodityStock().getId());
    actualCommodityStock.setOutcomeId(outcome.getId());
    return withdrawCommodityStock(actualCommodityStock,
        outcome.getGrossWeight() - outcome.getTruckWeight());
  }

  private CommodityStock withdrawCommodityStock(CommodityStock actualCommodityStock,
      int withdrawAmt) {
    actualCommodityStock.setAmount(actualCommodityStock.getAmount() - withdrawAmt);
    return commodityStockRepo.save(actualCommodityStock);
  }

  public List<CommodityStock> listAll() {
    return commodityStockRepo.findAll();
  }

  public CommodityStock getOne(Long id) {
    return commodityStockRepo.getOne(id);
  }

  public void saveAll(List<CommodityStock> entities) {
    commodityStockRepo.saveAll(entities);
  }

  /** Change stock according process edition
   * 
   * @param processDto
   * @param removedIncomeProcess
   */
  public void editProcess(ProcessDto processDto, List<IncomeProcess> removedIncomeProcess, List<Commodity> removedCommodities) {
    removingNaturalStocks(processDto);
    if (removedIncomeProcess != null && !removedIncomeProcess.isEmpty()) {
      removedIncomeProcess.forEach(item -> {
        Income income = incomeService.getIncomeById(item.getIncomeId());
        addNewIncome(income);
      });
    }
    removeStocksByCommodities(removedCommodities);
    addingNewStocks(processDto);
  }
  
  private void removeStocksByCommodities(List<Commodity> removedCommodities) {
    if (removedCommodities != null && !removedCommodities.isEmpty()) {
      List<CommodityStock> commodityStockToRemove = new ArrayList<>();
      for (int i = 0; i < removedCommodities.size(); i++) {
        CommodityStock stockItem = commodityStockRepo.findByCommodityId(removedCommodities.get(i).getId());
        commodityStockToRemove.add(stockItem);
      }
      if (!commodityStockToRemove.isEmpty()) {
        commodityStockRepo.deleteAll(commodityStockToRemove);
      }
    }
  }

  private Long getOwnerId(Income income) {
    Long ownerId = null;
    if (income.getCommercialSender() != null) {
      ownerId = income.getCommercialSender().getId();
    } else if (income.getWaybillOwner() != null) {
      ownerId = income.getWaybillOwner().getId();
    }
    return ownerId;
  }
  
  private void addingNewStocks(ProcessDto processDto) {
    Long ownerId = null;
    String harvesting = null;
    GrainType grainType = null;
    for (int i = 0; i < processDto.getNaturalCommodities().size(); i++) {
      Income income =
          incomeService.getIncomeById(processDto.getNaturalCommodities().get(i).getId());
      if (income != null) {
        ownerId = (ownerId == null) ? getOwnerId(income) : ownerId;
        harvesting = (harvesting == null) ? income.getHarvesting() : harvesting;
        grainType = (grainType == null) ? income.getGrainType() : grainType;
      }
      if (ownerId != null && grainType != null) {
        break;
      }
    }

    List<CommodityStock> commodityStockList = new ArrayList<>();
    for (int i = 0; i < processDto.getProcessedCommodities().size(); i++) {
      CommodityDto item = processDto.getProcessedCommodities().get(i);
      CommodityStock stockItem = new CommodityStock();
      stockItem = modelMapper.map(item, CommodityStock.class);
      stockItem.setOwner(ownerId);
      stockItem.setGrainType(grainType);
      stockItem.setHarvesting(harvesting);
      stockItem.setProcessId(processDto.getId());
      stockItem.setCommodityId(item.getId());
      commodityStockList.add(stockItem);
    }
    commodityStockRepo.saveAll(commodityStockList);
  }
  
  private void removingNaturalStocks(ProcessDto processDto) {
    for (int i = 0; i < processDto.getNaturalCommodities().size(); i++) {
      BasicIncomeInfoDto income = processDto.getNaturalCommodities().get(i);
      CommodityStock currentStock = commodityStockRepo.findByIncomeId(income.getId());
      if (currentStock != null && currentStock.getId() > 0) {
        commodityStockRepo.delete(currentStock);
      }
    }
  }
  
}
