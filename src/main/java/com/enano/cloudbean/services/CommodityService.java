package com.enano.cloudbean.services;

import java.util.Date;

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
    Commodity commodity = new Commodity();
    commodity.setAmount(income.getGrossWeight() - income.getTruckWeight());
    commodity.setBagQuantity(Double.valueOf(income.getBagQuantity()));
    commodity.setLocationInPlant(income.getLocationInPlant());
    commodity.setModificationDate(new Date());
    commodity.setObs(income.getObs());
    commodity.setOwner(income.getWaybillOwner().getId());
    commodity.setPackagingType(income.getPackagingType());
    commodity.setQualityType(qualityTypeSrv.
        getQualityTypeByName(CommodityQuality.NATURAL.getType()));
    return commodityRepo.saveAndFlush(commodity);
  }
}
