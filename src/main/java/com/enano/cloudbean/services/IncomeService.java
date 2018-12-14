package com.enano.cloudbean.services;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enano.cloudbean.dtos.IncomeDto;
import com.enano.cloudbean.dtos.IncomeFiltersDto;
import com.enano.cloudbean.entities.Income;
import com.enano.cloudbean.repositories.IncomeRepository;

@Service
public class IncomeService {
  
  @Autowired
  private IncomeRepository repo;
  
  private ModelMapper modelMapper = new ModelMapper();

  public Income edit(Income income) {
    income.setModificationDate(new Date());
    return repo.saveAndFlush(income); 
  }

  public Income save(Income income) {
    income.setId(null);
    return repo.saveAndFlush(income); 
  }

  public List<Income> listAll() {
    return repo.findAll();
  }
  
  public void updateAnalysis(Integer id, Integer analysisID) {
    Income income = repo.getOne(id.longValue());
    income.setAnalysisId(analysisID);
    repo.saveAndFlush(income).getId();
  }

  public List<IncomeDto> listAllIncomeDto() {
    List<Income> incomeList = repo.findAll();
    return incomeListToIncomeDtoList(incomeList);
  }

  public List<IncomeDto> listIncomesByFilter( IncomeFiltersDto filters) {
    List<Income> incomeList = repo.findIncomesUsingFilters(filters);
    return incomeListToIncomeDtoList(incomeList);
  }

  private List<IncomeDto> incomeListToIncomeDtoList(List<Income> incomeList) {
    List<IncomeDto> incomeDtoList = incomeList.stream()
        .map(item -> getIncomeDtoFromIncomeEntity(item))
        .collect(Collectors.toList());
    return incomeDtoList;
  }
  
  private IncomeDto getIncomeDtoFromIncomeEntity(Income item) {
   IncomeDto incomeDto = modelMapper.map(item, IncomeDto.class);
   return incomeDto;
  }

  
}
