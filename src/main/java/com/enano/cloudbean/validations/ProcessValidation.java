package com.enano.cloudbean.validations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enano.cloudbean.dtos.CommodityDto;
import com.enano.cloudbean.dtos.ProcessDto;
import com.enano.cloudbean.entities.CommodityStock;
import com.enano.cloudbean.repositories.CommodityStockRepository;

@Service
public class ProcessValidation {
  
  private static final Logger LOGGER = LogManager.getLogger(ProcessValidation.class);
  
  @Autowired
  private CommodityStockRepository commodityStockRepo;
  
  public List<CommodityDto> getListOfNoEditableCommodities (ProcessDto processDto) {
    Set<CommodityDto> commodityList = processDto.getProcessedCommodities();
    List<CommodityDto> noEditableCommodities = new ArrayList<>(); 
    if (commodityList != null && !commodityList.isEmpty()) {
      List<CommodityStock> stockItems = commodityStockRepo.findByProcessIdAndOutcomeIdIsNotNull(processDto.getId());
      for(CommodityDto commodity : commodityList) {
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
  
  public boolean isUpdatingNoEditableCommodity (ProcessDto processDto, List<CommodityDto> noEditableCommodities) {
    boolean isUpdatingNoEditableCommodity = false;
    try {
      Set<CommodityDto> commodityList = processDto.getProcessedCommodities();
      
      for (CommodityDto commodity : commodityList) {
        Optional<CommodityDto> noEditableCommodity = noEditableCommodities.stream()
            .filter(x -> x.getId() == commodity.getId())
            .findFirst();
        if (noEditableCommodity.isPresent()) {
          isUpdatingNoEditableCommodity = !noEditableCommodity.get().equals(commodity);
          break;
        }
      };
    } catch (Exception ex) {
      LOGGER.error("[Method]: isUpdatingNoEditableCommodity - " + ex.getMessage());
      isUpdatingNoEditableCommodity = true;
    }
    return isUpdatingNoEditableCommodity;
  }

}
