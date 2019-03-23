package com.enano.cloudbean.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enano.cloudbean.entities.CommodityStock;
import com.enano.cloudbean.entities.Income;
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
    stock.setGramaje(Math.round(income.getAnalysis().getGramaje()));
    commodityStockRepo.save(stock);
  }

}
