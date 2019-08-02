package com.enano.cloudbean.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enano.cloudbean.entities.Commodity;
import com.enano.cloudbean.repositories.CommodityRepository;

@Service
public class CommodityService {
  
  private Logger LOGGER = LogManager.getLogger(CommodityService.class);
  
  @Autowired 
  private CommodityRepository commodityRepo;
  
  public List<Commodity> getCommoditiesByProcessId (Long processId) {
    return commodityRepo.findByProcessId(processId);
  }
  
  public List<Commodity> addNewCommodities(List<Commodity> commodityList) {
    List<Commodity> savedCommodities = null;
    try {
      if (commodityList != null && !commodityList.isEmpty()) {
        savedCommodities = commodityRepo.saveAll(commodityList);
      }
    } catch (Exception e) {
      LOGGER.error("[addNewCommodities] - Error adding commodities.");
      throw e;
    }
    
    return savedCommodities;
  }

}
