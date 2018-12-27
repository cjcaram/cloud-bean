package com.enano.cloudbean.controllers;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.enano.cloudbean.dtos.HttpErrorBody;

public abstract class BaseController {
  
  private HttpErrorBody httpErrorBody;
  
  private Logger LOGGER = LogManager.getLogger(BaseController.class);
  
  private ResponseEntity<?> getResponseAndLog(Exception e){
    ResponseEntity<?> response;
    response = new ResponseEntity<>(httpErrorBody.getKnownErros(), httpErrorBody.getHttpStatus());
    LOGGER.error(httpErrorBody, e);
    return response;
  }
  
  public ResponseEntity<?> getErrorResponseAndLog(Exception e, String errorMsg) {
    httpErrorBody = new HttpErrorBody(HttpStatus.INTERNAL_SERVER_ERROR, e, errorMsg);
    return getResponseAndLog(e);
  }
  
  public ResponseEntity<?> getErrorResponseAndLog(Exception e, List<String> knownError) {
    httpErrorBody = new HttpErrorBody(HttpStatus.INTERNAL_SERVER_ERROR, e, knownError);
    return getResponseAndLog(e);
  }
  
}
