package com.enano.cloudbean.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enano.cloudbean.dtos.OutcomeRequestDto;
import com.enano.cloudbean.entities.Outcome;
import com.enano.cloudbean.services.OutcomeService;

@RestController
@RequestMapping("/outcome")
public class OutcomeController extends BaseController{
  
  @Autowired 
  private OutcomeService outcomeService;
  
  private static final Logger LOGGER = LogManager.getLogger(OutcomeController.class);
  
  @PostMapping(value = "/save")
  public ResponseEntity<?> AddOrModifyOutcome(@RequestBody OutcomeRequestDto outcomeDto) {
    ResponseEntity<?> response = null;
    Outcome outcomeResult = null;
    try {
      if (ZUtils.isEdition(outcomeDto.getId())) {
        LOGGER.info(ZUtils.EDITING_ENTITY_MSG);
        outcomeResult = outcomeService.edit(outcomeDto);
      } else {
        LOGGER.info(ZUtils.ADDING_ENTITY_MSG);
        outcomeResult = outcomeService.save(outcomeDto);
      }
      response = ResponseEntity.ok(outcomeResult);
    } catch (Exception e) {
      response = getErrorResponseAndLog(e, ZUtils.ERROR_ADD_EDIT_ENTITY_MSG);
    }
    return response;
  }
  
  @GetMapping(value = "/list")
  public ResponseEntity<?> getOutcomes() {
    ResponseEntity<?> response = null;
    try {
      LOGGER.info(ZUtils.FETCHING_ENTITIES_MSG);
      response = ResponseEntity.ok(outcomeService.listAll());
    }catch(Exception e) {
      response = getErrorResponseAndLog(e, ZUtils.ERROR_FETCHING_ENTITIES_MSG);
    }
    return response;
  }

}
