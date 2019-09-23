package com.enano.cloudbean.validations;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enano.cloudbean.dtos.CommodityDto;
import com.enano.cloudbean.dtos.ProcessDto;
import com.enano.cloudbean.entities.CommodityStock;
import com.enano.cloudbean.repositories.CommodityStockRepository;

@Service
public class ProcessValidation {
  
  @Autowired
  private CommodityStockRepository commodityStockRepo;
  
  public List<CommodityDto> checkIfCommodityIsEditable (ProcessDto processDto) {
    List<CommodityDto> commodityList = processDto.getProcessedCommodities();
    List<CommodityDto> noEditableCommodities = new ArrayList<>(); 
    if (commodityList != null && !commodityList.isEmpty()) {
      List<CommodityStock> stockItems = commodityStockRepo.findByProcessIdAndOutcomeIdIsNotNull(processDto.getId());
      stockItems.forEach(item -> System.out.println(item));
      System.out.println();
      for(CommodityDto commodity : processDto.getProcessedCommodities()) {
        for (CommodityStock stockItem : stockItems) {
          if (stockItem.getCommodityId() == commodity.getId()) {
            commodity.setEditable(false);
            noEditableCommodities.add(commodity);
          }
        }
      }
      
    }
    return noEditableCommodities;
  }

}
