package com.enano.cloudbean.repositories;

import java.util.List;

import com.enano.cloudbean.dtos.IncomeFiltersDto;
import com.enano.cloudbean.entities.Income;

public interface IncomeRepositoryCustom {
  
  List<Income> findIncomesUsingFilters(IncomeFiltersDto filters);
}
