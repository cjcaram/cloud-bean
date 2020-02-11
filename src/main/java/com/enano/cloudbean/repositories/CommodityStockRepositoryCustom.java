package com.enano.cloudbean.repositories;

import java.util.List;

import com.enano.cloudbean.dtos.CommodityFilterDto;
import com.enano.cloudbean.entities.CommodityStock;

public interface CommodityStockRepositoryCustom {
  
  List<CommodityStock> findStockUsingFilters(CommodityFilterDto filters);

}
