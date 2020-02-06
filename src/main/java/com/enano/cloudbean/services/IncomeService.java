package com.enano.cloudbean.services;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
import com.enano.cloudbean.entities.Commodity;
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
  @Transactional
  public Income edit(Income incomeToEdit) throws Exception {
    try {
      incomeToEdit.setModificationDate(new Date());
      Income editedIncome = repo.save(incomeToEdit);
      stockSrv.editCommodityAccordingNewAnalysis(editedIncome);
      return editedIncome;
    } catch (Exception ex) {
      LOGGER.error("Errror Saving Income: ", ex);
      throw ex;
    }
  }

  /** Save new Income
   * 
   * @param incomeToAdd
   * @return Income saved
   * @throws Exception 
   */
  @Transactional
  public Income save(Income incomeToAdd) throws Exception {
    try {
      incomeToAdd.setId(null);
      Income addedIncome = repo.save(incomeToAdd);
      stockSrv.addNewIncome(addedIncome);
      return addedIncome; 
    } catch (Exception ex) {
      LOGGER.error("Errror Saving Income: ", ex);
      throw ex;
    }
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
  public void updateAnalysis(Long incomeId, Analysis analysis) throws Exception {
    try {
      Income income = repo.getOne(incomeId);
      Commodity commodity = income.getCommodities().iterator().next();
      commodity.setGramaje(analysis.getGramaje());
      Set<Commodity> newCommodity = new HashSet<Commodity>();
      newCommodity.add(commodity);
      income.setCommodities(newCommodity);
      income.setAnalysis(analysis);
      edit(income);
    } catch (Exception ex) {
      LOGGER.error("Errror Updating Analysis: ", ex);
      throw ex;
    }
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
  /*
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
  }*/
  
  /** List of incomes associated to specific process
   * 
   * @param processId
   * @return List of incomes
   */
  /*
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
  }*/

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
    return noProcessedIncomeDto;
  }
  
  private IncomeDto getIncomeDtoFromIncomeEntity(Income item) {
   IncomeDto incomeDto = modelMapper.map(item, IncomeDto.class);
   if (AnalysisValidation.isValidAnalysis(item.getAnalysis())) {
     incomeDto.setAnalysis(modelMapper.map(item.getAnalysis(), Analysis.class));
   } else {
     incomeDto.setAnalysis(new Analysis());
   }
   incomeDto.setCommodity(modelMapper.map(item.getCommodities().iterator().next(), Commodity.class));
   return incomeDto;
  }

  
}
