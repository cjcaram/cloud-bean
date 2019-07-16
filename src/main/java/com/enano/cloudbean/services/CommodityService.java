package com.enano.cloudbean.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enano.cloudbean.entities.Commodity;
import com.enano.cloudbean.entities.Income;
import com.enano.cloudbean.repositories.CommodityRepository;
import com.enano.cloudbean.utils.CommodityQuality;

@Service
public class CommodityService {
  
  @Autowired 
  private CommodityRepository commodityRepo;
  
  @Autowired
  private QualityTypeService qualityTypeSrv;
  
  public Commodity addNewIncome(Income income) {
    Commodity commodity = setBasicInfo(income);
    commodity.setQualityType(qualityTypeSrv.
        getQualityTypeByName(CommodityQuality.NATURAL.getType()));
    return commodityRepo.saveAndFlush(commodity);
  }
  
  public static Commodity setBasicInfo(Income income) {
    Commodity commodity = new Commodity();
    
    commodity.setAmount(income.getGrossWeight() - income.getTruckWeight());
    commodity.setBagQuantity(Double.valueOf(income.getBagQuantity()));
    commodity.setLocationInPlant(income.getLocationInPlant());
    commodity.setObs(income.getObs());
    commodity.setPackagingType(income.getPackagingType());
    
    return commodity;
  }
}
