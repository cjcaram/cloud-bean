package com.enano.cloudbean.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enano.cloudbean.services.AgrochemicalAppTypeService;

@RestController
@RequestMapping("/agrochemical-application-type")
public class AgrochemicalAppTypeController  extends BaseController {
  
  @Autowired
  private AgrochemicalAppTypeService agrochemicalAppTypeService;
  
  private static final Logger LOGGER = LogManager.getLogger(AgrochemicalAppTypeController.class);

  @GetMapping(value = "/list")
  public ResponseEntity<?> listAllAgrochemicalAppTypes() {
    ResponseEntity<?> response = null;
    try {
      LOGGER.info(ZUtils.FETCHING_ENTITIES_MSG);
      response = ResponseEntity.ok(agrochemicalAppTypeService.listAll());
    } catch (Exception e) {
      response = getErrorResponseAndLog(e, ZUtils.ERROR_FETCHING_ENTITIES_MSG);
    }
    return response;
  }
}
