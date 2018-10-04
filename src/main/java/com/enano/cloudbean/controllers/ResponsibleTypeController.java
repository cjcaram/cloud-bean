package com.enano.cloudbean.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enano.cloudbean.dtos.HttpErrorBody;
import com.enano.cloudbean.services.ResponsibleTypeService;

@RestController
@RequestMapping("/resposibleType")
public class ResponsibleTypeController {

  @Autowired
  ResponsibleTypeService responsibleTypeService;

  private HttpErrorBody httpErrorBody;
  
  private static final Logger LOGGER = LogManager.getLogger(ResponsibleTypeController.class);
  
  @GetMapping(value ="/list")
  public ResponseEntity<?> getResponsibleTypes() {
    ResponseEntity<?> response = null;
    try {
      LOGGER.info("Listing all responsible Types.");
      response = ResponseEntity.ok(responsibleTypeService.listAll());
    }catch (Exception e) {
      httpErrorBody = new HttpErrorBody(HttpStatus.INTERNAL_SERVER_ERROR, e, "Error Listing All Responsible Types");
      response = ZUtils.getErrorResponse(httpErrorBody);
      LOGGER.error(httpErrorBody);
    }
    return response;
  }
}
