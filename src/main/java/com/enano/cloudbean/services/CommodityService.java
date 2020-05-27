package com.enano.cloudbean.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enano.cloudbean.entities.Commodity;
import com.enano.cloudbean.repositories.CommodityRepository;
import com.enano.cloudbean.repositories.CommodityStockRepository;

@Service
public class CommodityService {
  
  private Logger LOGGER = LogManager.getLogger(CommodityService.class);
  
  @Autowired 
  private CommodityRepository commodityRepo;
  
  @Autowired 
  private CommodityStockRepository commodityStockRepo;
  
  private ModelMapper modelMapper = new ModelMapper();
  
  /*
  public List<CommodityDto> getCommoditiesByProcessId (Long processId) {
    List<Commodity> commodities = commodityRepo.findByProcessId(processId);
    List<CommodityDto> commoditiesDto = new ArrayList<>();
    List<CommodityStock> stocks = commodityStockRepo.findByProcessIdAndOutcomeIdIsNotNull(processId);
    for (Commodity item : commodities) {
      CommodityDto itemDto = modelMapper.map(item, CommodityDto.class);
      for (CommodityStock itemStock : stocks) {
        if (itemStock.getCommodityId() == item.getId()) {
          itemDto.setEditable(false);
        }
      }
      commoditiesDto.add(itemDto);
    }
    return commoditiesDto;
  }
  */
  
  public List<Commodity> saveAllCommodities(List<Commodity> commodityList) {
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
  
  /*
  public List<Commodity> removeCommoditiesIfNoLongerExist(List<Commodity> commodityList, Long processId) {
    List<Commodity> previousCommodities = new ArrayList<>();
    try {
      if (commodityList != null && !commodityList.isEmpty()) {
        previousCommodities = commodityRepo.findByProcessId(processId);
        previousCommodities.removeIf(item -> (commodityList.contains(item)));
        commodityRepo.deleteAll(previousCommodities);
      }
    } catch (Exception e) {
      LOGGER.error("[removeCommoditiesIfNoLongerExist] - Error removing commodities during edition of Process.");
      throw e;
    }
    
    return previousCommodities;
  }
  */

}
