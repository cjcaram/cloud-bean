package com.enano.cloudbean.controllers;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enano.cloudbean.dtos.CommodityFilterDto;
import com.enano.cloudbean.entities.Income;
import com.enano.cloudbean.services.IncomeService;
import com.enano.cloudbean.validations.IncomeValidation;

@RestController
@RequestMapping("/income")
public class IncomeController extends BaseController {
  
  @Autowired 
  private IncomeService incomeService;
  
  private static final Logger LOGGER = LogManager.getLogger(IncomeController.class);
  
  @PostMapping(value = "/save")
  public ResponseEntity<?> AddOrModifyIncome(@RequestBody Income income) {
    ResponseEntity<?> response = null;
    String methodName = "[Method]: AddOrModifyIncome - ";
    try {
      checkIncome(income);
      if (ZUtils.isEdition(income.getId())) {
        LOGGER.info(methodName + ZUtils.EDITING_ENTITY_MSG);
        response = ResponseEntity.ok(incomeService.edit(income));
      } else {
        LOGGER.info(methodName + ZUtils.ADDING_ENTITY_MSG);
        response = ResponseEntity.ok(incomeService.save(income));
      }
    } catch (Exception e) {
      response = getErrorResponseAndLog(e, methodName + ZUtils.ERROR_ADD_EDIT_ENTITY_MSG);
    }
    return response;
  }
  
  @GetMapping(value = "/list")
  public ResponseEntity<?> getIncomes() {
    ResponseEntity<?> response = null;
    try {
      LOGGER.info("[Method]: getIncomes - " + ZUtils.FETCHING_ENTITIES_MSG);
      response = ResponseEntity.ok(incomeService.listAllIncomeDto());
    }catch(Exception e) {
      response = getErrorResponseAndLog(e, ZUtils.ERROR_FETCHING_ENTITIES_MSG);
    }
    return response;
  }
  
  @PostMapping(value = "/filter")
  public ResponseEntity<?> getFilteredIncomes(@RequestBody CommodityFilterDto filters) {
    ResponseEntity<?> response = null;
    try {
      LOGGER.info("[Method]: getFilteredIncomes - " + ZUtils.FETCHING_ENTITIES_MSG);
      response = ResponseEntity.ok(incomeService.listIncomesByFilter(filters));
    }catch(Exception e) {
      response = getErrorResponseAndLog(e, ZUtils.ERROR_FETCHING_ENTITIES_MSG);
    }
    return response;
  }
  
  @PostMapping(value = "/find-by-commodity")
  public ResponseEntity<?> getIncomesByCommoditiesAttached(@RequestBody List<Long> commodityIdList) {
    ResponseEntity<?> response = null;
    try {
      LOGGER.info("[Method]: getIncomesByCommoditiesAttached - " + ZUtils.FETCHING_ENTITIES_MSG);
      response = ResponseEntity.ok(incomeService.getIncomesByCommoditiesAttached(commodityIdList));
    }catch(Exception e) {
      response = getErrorResponseAndLog(e, ZUtils.ERROR_FETCHING_ENTITIES_MSG);
    }
    return response;
  }
  
  @GetMapping(value = "/income-number-list")
  public ResponseEntity<?> getIncomeNumberList() {
    ResponseEntity<?> response = null;
    try {
      LOGGER.info("[Method]: getIncomeNumberList - " + ZUtils.FETCHING_ENTITIES_MSG);
      response = ResponseEntity.ok(incomeService.listAllBasicIncomeDto());
    }catch(Exception e) {
      response = getErrorResponseAndLog(e, ZUtils.ERROR_FETCHING_ENTITIES_MSG);
    }
    return response;
  }
  
  private void checkIncome(Income income) throws Exception {
    if (!IncomeValidation.isValidIncome(income)) {
      LOGGER.debug(IncomeValidation.NO_MIN_REQUIRED_FIELD);
      throw new Exception(IncomeValidation.NO_MIN_REQUIRED_FIELD);
    }
  }

}
