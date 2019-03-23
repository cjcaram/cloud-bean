package com.enano.cloudbean.services;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enano.cloudbean.dtos.IncomeDto;
import com.enano.cloudbean.dtos.IncomeFiltersDto;
import com.enano.cloudbean.entities.Analysis;
import com.enano.cloudbean.entities.Income;
import com.enano.cloudbean.repositories.IncomeRepository;
import com.enano.cloudbean.validations.AnalysisValidation;

@Service
public class IncomeService {
  
  @Autowired
  private IncomeRepository repo;
  
  @Autowired
  private CommodityStockService stockSrv;
  
  @Autowired
  private AnalysisService analisysSrv;
  
  private ModelMapper modelMapper = new ModelMapper();

  public Income edit(Income income) {
    income.setModificationDate(new Date());
    return repo.saveAndFlush(income); 
  }

  public Income save(Income incomeToAdd) {
    incomeToAdd.setId(null);
    if (AnalysisValidation.isValidAnalysis(incomeToAdd.getAnalysis())) {
      incomeToAdd.setAnalysis(analisysSrv.save(incomeToAdd.getAnalysis()));
    } else {
      incomeToAdd.setAnalysis(null);
    }
    Income addedIncome = repo.saveAndFlush(incomeToAdd);
    stockSrv.addNewIncome(addedIncome);
    return addedIncome; 
  }

  public List<Income> listAll() {
    return repo.findAll();
  }
  
  public void updateAnalysis(Long id, Analysis analysis) {
    Income income = repo.getOne(id);
    income.setAnalysis(analysis);
    stockSrv.editCommodityAccordingNewAnalysis(income);
    repo.saveAndFlush(income);
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
   if (AnalysisValidation.isValidAnalysis(item.getAnalysis())) {
     incomeDto.setAnalysisId(modelMapper.map(item.getAnalysis(), Analysis.class));
   } else {
     incomeDto.setAnalysisId(new Analysis());
   }
   return incomeDto;
  }

  
}
