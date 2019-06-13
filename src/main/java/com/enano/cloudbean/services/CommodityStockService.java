package com.enano.cloudbean.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enano.cloudbean.entities.CommodityStock;
import com.enano.cloudbean.entities.Income;
import com.enano.cloudbean.entities.Outcome;
import com.enano.cloudbean.repositories.CommodityStockRepository;
import com.enano.cloudbean.utils.CommodityQuality;
import com.enano.cloudbean.validations.AnalysisValidation;

@Service
public class CommodityStockService {
  
  @Autowired
  private CommodityStockRepository commodityStockRepo;
  
  @Autowired
  private QualityTypeService qualityTypeSrv;
  
  public void addNewIncome(Income income) {
    CommodityStock stock = new CommodityStock();
    stock.setAmount(income.getGrossWeight() - income.getTruckWeight());
    stock.setBagQuantity(Double.valueOf(income.getBagQuantity()));
    stock.setLocationInPlant(income.getLocationInPlant());
    stock.setObs(income.getObs());
    stock.setOwner(income.getWaybillOwner().getId());
    stock.setPackagingType(income.getPackagingType());
    stock.setGrainType(income.getGrainType());
    stock.setQualityType(qualityTypeSrv.
        getQualityTypeByName(CommodityQuality.NATURAL.getType()));
    stock.setIncomeId(income.getId());
    stock.setHarvesting(income.getHarvesting());
    if (AnalysisValidation.isValidAnalysis(income.getAnalysis())) {
      stock.setGramaje(Math.round(income.getAnalysis().getGramaje()));
    }
    commodityStockRepo.save(stock);
  }

  public void editCommodityAccordingNewAnalysis(Income income) {
    CommodityStock stock = commodityStockRepo.findByIncomeId(income.getId());
    if (income.getAnalysis() != null) {
      stock.setGramaje(Math.round(income.getAnalysis().getGramaje()));
    }
    commodityStockRepo.save(stock);
  }
  
  public CommodityStock withdrawCommodityStock(Outcome outcome) {
    CommodityStock actualCommodityStock = commodityStockRepo.getOne(outcome.getCommodityStock().getId());
    actualCommodityStock.setOutcomeId(outcome.getId());
    return withdrawCommodityStock(actualCommodityStock, outcome.getGrossWeight() - outcome.getTruckWeight());
  }
  
  private CommodityStock withdrawCommodityStock(CommodityStock actualCommodityStock, int withdrawAmt) {
    actualCommodityStock.setAmount(actualCommodityStock.getAmount() - withdrawAmt);
    return commodityStockRepo.save(actualCommodityStock);
  }

  public List<CommodityStock> listAll() {
    return commodityStockRepo.findAll();
  }
  
  public CommodityStock getOne(Long id) {
    return commodityStockRepo.getOne(id);
  }

}
