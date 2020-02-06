package com.enano.cloudbean.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.enano.cloudbean.dtos.BasicIncomeInfoDto;
import com.enano.cloudbean.dtos.CommodityDto;
import com.enano.cloudbean.dtos.ProcessDto;
import com.enano.cloudbean.entities.Commodity;
import com.enano.cloudbean.entities.CommodityStock;
import com.enano.cloudbean.entities.GrainType;
import com.enano.cloudbean.entities.Income;
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

  /** Adding stock when new incomes are saved
   * 
   * @param income
   */
  public void addNewIncome(Income income) throws Exception {
    try {
      CommodityStock stock = CommodityDto.From(income.getCommodities().iterator().next());
      stock.setId(null);
      stock.setIncomeId(income.getId());
      commodityStockRepo.save(stock);
    } catch (Exception ex) {
      LOGGER.error("Error adding stock from new income.", ex);
      throw ex;
    }
  }

  /** Edit Stock when income is modified
   * 
   * @param income
   */
  public void editCommodityAccordingNewAnalysis(Income income) throws Exception {
    try {
      CommodityStock oldStock = commodityStockRepo.findByIncomeId(income.getId());
      CommodityStock newStock = CommodityDto.From(income.getCommodities().iterator().next());
      newStock.setId(oldStock.getId());
      newStock.setIncomeId(oldStock.getIncomeId());
      if (income.getAnalysis() != null) {
        newStock.setGramaje(income.getAnalysis().getGramaje());
      }
      commodityStockRepo.save(newStock);
    } catch (Exception ex) {
      LOGGER.error("Error editing Stock when income is modified.", ex);
      throw ex;
    }
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
//  public CommodityStock withdrawCommodityStock(Outcome outcome) {
//    CommodityStock actualCommodityStock =
//        commodityStockRepo.getOne(outcome.getCommodityStock().getId());
//    actualCommodityStock.setOutcomeId(outcome.getId());
//    return withdrawCommodityStock(actualCommodityStock,
//        outcome.getGrossWeight() - outcome.getTruckWeight());
//  }

  private CommodityStock withdrawCommodityStock(CommodityStock actualCommodityStock,
      int withdrawAmt) {
    actualCommodityStock.setAmount(actualCommodityStock.getAmount() - withdrawAmt);
    return commodityStockRepo.save(actualCommodityStock);
  }

  public Page<CommodityStock> listAll(Integer pageNumber, Integer processId) {
    Pageable page = null;
    Page<CommodityStock> result;
    if (pageNumber == null) {
      page = PageRequest.of(0, 10);
    }
    page = PageRequest.of(pageNumber, 10);

    if (processId == null || processId < 0) {
      result = commodityStockRepo.findAll(page);
    } else {
      result = commodityStockRepo.findByProcessId(page, processId.longValue());
    }
    return result;
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
  public void editProcess(ProcessDto processDto, List<Commodity> removedCommodities) {
    removingNaturalStocks(processDto);
    /*if (removedIncomeProcess != null && !removedIncomeProcess.isEmpty()) {
      removedIncomeProcess.forEach(item -> {
        Income income = incomeService.getIncomeById(item.getIncomeId());
        addNewIncome(income);
      });
    }*/
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
