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

  /** Edit Income 
   * 
   * @param income
   * @return edited income
   */
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

  /** Save new Income
   * 
   * @param incomeToAdd
   * @return Income saved
   */
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

  /** List all incomes without filters
   * 
   * @return list of incomes
   */
  public List<Income> listAll() {
    return repo.findAll();
  }
  
  /** Update analysis associated to income
   * 
   * @param id
   * @param analysis
   */
  public void updateAnalysis(Long id, Analysis analysis) {
    Income income = repo.getOne(id);
    income.setAnalysis(analysis);
    stockSrv.editCommodityAccordingNewAnalysis(income);
    repo.saveAndFlush(income);
  }

  /** List of incomesDto
   * 
   * @return List of incomesDto
   */
  public List<IncomeDto> listAllIncomeDto() {
    List<Income> incomeList = repo.findAll();
    return incomeListToIncomeDtoList(incomeList);
  }
  
  /** List of incomes without process associated
   * 
   * @return List of incomes
   */
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
  
  /** List of incomes associated to specific process
   * 
   * @param processId
   * @return List of incomes
   */
  public List<BasicIncomeInfoDto> getIncomesByProcessId(Long processId) {
    List<BasicIncomeInfoDto> incomeDtoList = null;
    List<Income> incomeList = null;
    try {
      incomeList = repo.getIncomesByProcessId(processId);
      incomeDtoList = incomeList.stream()
          .map(item -> getNoProcessedIncomeDtoFromIncomeEntity(item))
          .collect(Collectors.toList());
    } catch (Exception error) {
      LOGGER.error("[Method: getIncomesByProcessId] - "+ error);
      throw error;
    }
    return incomeDtoList;
  }

  /** List Incomes using filters
   * 
   * @param filters
   * @return Filtered incomes
   */
  public List<IncomeDto> listIncomesByFilter( IncomeFiltersDto filters) {
    List<Income> incomeList = repo.findIncomesUsingFilters(filters);
    return incomeListToIncomeDtoList(incomeList);
  }
  
  /** Get income by id
   * 
   * @param id
   * @return income
   */
  public Income getIncomeById (Long id) {
    return repo.getOne(id);
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
    noProcessedIncomeDto.setCp(item.getWaybill());
    if (AnalysisValidation.isValidAnalysis(item.getAnalysis())) {
      noProcessedIncomeDto.setGramaje(item.getAnalysis().getGramaje().toString());
      noProcessedIncomeDto.setCaida(item.getAnalysis().getCaida());
    } else {
      noProcessedIncomeDto.setGramaje("Analisis Pendiente");
      noProcessedIncomeDto.setCaida(null);
    }
    noProcessedIncomeDto.setDownloadDate(item.getDownloadDate());
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
