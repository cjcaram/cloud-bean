package com.enano.cloudbean.repositories;

import java.util.List;

import com.enano.cloudbean.dtos.CommodityFilterDto;
import com.enano.cloudbean.entities.Income;

public interface IncomeRepositoryCustom {
  
  List<Income> findIncomesUsingFilters(CommodityFilterDto filters);
}
