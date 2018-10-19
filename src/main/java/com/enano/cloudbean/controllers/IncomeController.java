package com.enano.cloudbean.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enano.cloudbean.dtos.HttpErrorBody;
import com.enano.cloudbean.entities.Income;
import com.enano.cloudbean.services.IncomeService;

@RestController
@RequestMapping("/income")
public class IncomeController {
  
  @Autowired 
  private IncomeService incomeService;
  
  private HttpErrorBody httpErrorBody;
  private static final Logger LOGGER = LogManager.getLogger(IncomeController.class);
  
  @PostMapping(value = "/save")
  public ResponseEntity<?> AddOrModifyIncome(@RequestBody Income income) {
    ResponseEntity<?> response = null;
    try {
      if (ZUtils.isEdition(income.getId().intValue())) {
        LOGGER.info(ZUtils.EDITING_ENTITY_MSG);
        response = ResponseEntity.ok(incomeService.edit(income));
      } else {
        LOGGER.info(ZUtils.ADDING_ENTITY_MSG);
        response = ResponseEntity.ok(incomeService.save(income));
      }
    } catch (Exception e) {
      httpErrorBody = new HttpErrorBody(HttpStatus.INTERNAL_SERVER_ERROR, e, 
          ZUtils.ERROR_ADD_EDIT_ENTITY_MSG);
      response = ZUtils.getErrorResponse(httpErrorBody);
      LOGGER.error(httpErrorBody, e);
    }
    return response;
  }
  
  @GetMapping(value = "/list")
  public ResponseEntity<?> getIncomes() {
    ResponseEntity<?> response = null;
    try {
      LOGGER.info(ZUtils.FETCHING_ENTITIES_MSG);
      response = ResponseEntity.ok(incomeService.listAll());
    }catch(Exception e) {
      httpErrorBody = new HttpErrorBody(HttpStatus.INTERNAL_SERVER_ERROR, e, 
          ZUtils.ERROR_FETCHING_ENTITIES_MSG);
      response = ZUtils.getErrorResponse(httpErrorBody);
      LOGGER.error(httpErrorBody, e);
    }
    return response;
  }

}
