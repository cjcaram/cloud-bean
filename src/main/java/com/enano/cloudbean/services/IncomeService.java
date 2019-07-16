package com.enano.cloudbean.services;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.enano.cloudbean.dtos.BasicIncomeInfoDto;
import com.enano.cloudbean.dtos.IncomeDto;
import com.enano.cloudbean.dtos.IncomeFiltersDto;
import com.enano.cloudbean.entities.Analysis;
import com.enano.cloudbean.entities.Income;
import com.enano.cloudbean.repositories.IncomeRepository;
import com.enano.cloudbean.validations.AnalysisValidation;

@Service
public class IncomeService {
  
  private static final Logger LOGGER = LogManager.getLogger(IncomeService.class);
  
  @Autowired
  private IncomeRepository repo;
  
  @Autowired
  private CommodityStockService stockSrv;
  
  @Autowired
  private AnalysisService analisysSrv;
  
  private ModelMapper modelMapper = new ModelMapper();

  public Income edit(Income income) {
    income.setModificationDate(new Date());
    if (AnalysisValidation.isValidAnalysis(income.getAnalysis())) {
      income.setAnalysis(analisysSrv.save(income.getAnalysis()));
    } else {
      income.setAnalysis(null);
    }
    Income editedIncome = repo.save(income); 
    stockSrv.editCommodityAccordingNewAnalysis(editedIncome);
    return editedIncome; 
  }

  @Transactional
  public Income save(Income incomeToAdd) {
    incomeToAdd.setId(null);
    if (AnalysisValidation.isValidAnalysis(incomeToAdd.getAnalysis())) {
      incomeToAdd.setAnalysis(analisysSrv.save(incomeToAdd.getAnalysis()));
    } else {
      incomeToAdd.setAnalysis(null);
    }
    Income addedIncome = repo.save(incomeToAdd);
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
  
  public List<BasicIncomeInfoDto> listNotProcessedIncomes() {
    List<BasicIncomeInfoDto> incomeDtoList = null;
    List<Income> incomeList = null;
    try {
      incomeList = repo.listNotProcessedIncomes();
      incomeDtoList = incomeList.stream()
          .map(item -> getNoProcessedIncomeDtoFromIncomeEntity(item))
          .collect(Collectors.toList());
    } catch (Exception error) {
      LOGGER.error("[Method: listNotProcessedIncomes] - "+ error);
      throw error;
    }
    return incomeDtoList;
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
  
  private BasicIncomeInfoDto getNoProcessedIncomeDtoFromIncomeEntity (Income item) {
    BasicIncomeInfoDto noProcessedIncomeDto = new BasicIncomeInfoDto();
    noProcessedIncomeDto.setId(item.getId());
    noProcessedIncomeDto.setDestinatario(item.getCommercialSender().getName());
    if (AnalysisValidation.isValidAnalysis(item.getAnalysis())) {
      noProcessedIncomeDto.setGramaje(item.getAnalysis().getGramaje().toString());
    } else {
      noProcessedIncomeDto.setGramaje("Analisis Pendiente");
    }
    noProcessedIncomeDto.setFecha(item.getDownloadDate());
    noProcessedIncomeDto.setIngresoNro(item.getIncomeNo());
    noProcessedIncomeDto.setProcedencia(item.getOrigin().getName());
    noProcessedIncomeDto.setKilogramos(item.getGrossWeight() - item.getTruckWeight());
    noProcessedIncomeDto.setGrano(item.getGrainType().getName());
    return noProcessedIncomeDto;
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
