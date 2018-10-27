package com.enano.cloudbean.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enano.cloudbean.dtos.HttpErrorBody;
import com.enano.cloudbean.entities.Analysis;
import com.enano.cloudbean.services.AnalysisService;

@RestController
@RequestMapping("/analysis")
public class AnalysisController {
  
  @Autowired
  private AnalysisService analysisService;
  
  private HttpErrorBody httpErrorBody;
  private static final Logger LOGGER = LogManager.getLogger(AnalysisController.class);
  
  @PostMapping(value = "/save")
  public ResponseEntity<?> AddOrModifyAnalysis(@RequestBody Analysis analysis) {
    ResponseEntity<?> response = null;
    try {
      if (ZUtils.isEdition(analysis.getId().intValue())) {
        LOGGER.info(ZUtils.EDITING_ENTITY_MSG);
        response = ResponseEntity.ok(analysisService.edit(analysis));
      } else {
        LOGGER.info(ZUtils.ADDING_ENTITY_MSG);
        response = ResponseEntity.ok(analysisService.save(analysis));
      }
    } catch (Exception e) {
      response = getErrorResponseAndLog(e, ZUtils.ERROR_ADD_EDIT_ENTITY_MSG);
    }
    return response;
  }

  @GetMapping(value = "/list")
  public ResponseEntity<?> getAllAnalisis() {
    ResponseEntity<?> response = null;
    try {
      LOGGER.info(ZUtils.FETCHING_ENTITIES_MSG);
      response = ResponseEntity.ok(analysisService.listAll());
    }catch(Exception e) {
      response = getErrorResponseAndLog(e, ZUtils.ERROR_FETCHING_ENTITIES_MSG);
    }
    return response;
  }
  
  @GetMapping(value = "/{id}")
  public ResponseEntity<?> getAnalysisById(@PathVariable Integer id) {
    ResponseEntity<?> response = null;
    try {
      LOGGER.info(ZUtils.FETCHING_ENTITY_MSG);
      response = ResponseEntity.ok(analysisService.getOne(id));
    }catch(Exception e) {
      response = getErrorResponseAndLog(e, ZUtils.ERROR_FETCHING_ENTITY_MSG);
    }
    return response;
  }
  
  private ResponseEntity<?> getErrorResponseAndLog(Exception e, String errorMsg) {
    ResponseEntity<?> response;
    httpErrorBody = new HttpErrorBody(HttpStatus.INTERNAL_SERVER_ERROR, e, errorMsg);
    response = ZUtils.getErrorResponse(httpErrorBody);
    LOGGER.error(httpErrorBody, e);
    return response;
  }

}
