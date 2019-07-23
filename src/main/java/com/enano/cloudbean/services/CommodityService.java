package com.enano.cloudbean.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enano.cloudbean.entities.Commodity;
import com.enano.cloudbean.repositories.CommodityRepository;

@Service
public class CommodityService {
  
  @Autowired 
  private CommodityRepository commodityRepo;
  
  @Autowired
  private QualityTypeService qualityTypeSrv;
  
  public List<Commodity> getCommoditiesByProcessId (Long processId) {
    return commodityRepo.findByProcessId(processId);
  }
  
  public List<Commodity> addNewCommodities(List<Commodity> commodityList) {
    return commodityRepo.saveAll(commodityList);
  }
  
}
