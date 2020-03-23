package com.enano.cloudbean.controllers;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enano.cloudbean.dtos.CommodityDto;
import com.enano.cloudbean.dtos.ProcessDto;
import com.enano.cloudbean.services.ProcessService;
import com.enano.cloudbean.validations.ProcessValidation;

@RestController
@RequestMapping("/process")
public class ProcessController extends BaseController {
  
  @Autowired 
  private ProcessService processService;
  
  @Autowired 
  private ProcessValidation validationProcessSrv;
  
  private static final Logger LOGGER = LogManager.getLogger(ProcessController.class);
  
  @PostMapping(value = "/save")
  public ResponseEntity<?> AddProcess(@RequestBody ProcessDto processDto) {
    final String METHOD_NAME = "[Method]: AddProcess - ";
    ResponseEntity<?> response = null;
    LOGGER.info(METHOD_NAME + ZUtils.ADDING_ENTITY_MSG);
    try {
      response = ResponseEntity.ok(processService.addProcess(processDto));
    } catch (Exception e) {
      response = getErrorResponseAndLog(e, METHOD_NAME + ZUtils.ADDING_ENTITY_MSG);
    }
    return response;
  }
  
  @PutMapping(value = "/edit")
  public ResponseEntity<?> editProcess(@RequestBody ProcessDto processDto){
    final String METHOD_NAME = "[Method]: editProcess - ";
    ResponseEntity<?> response = null;
    LOGGER.info(METHOD_NAME + ZUtils.EDITING_ENTITY_MSG);
    try {
      List<CommodityDto> notEditableCommodities = validationProcessSrv.getListOfNoEditableCommodities(processDto);
      if (!validationProcessSrv.isUpdatingNoEditableCommodity(processDto, notEditableCommodities)) {
        response = ResponseEntity.ok(processService.editProcess(processDto));
      } else {
        LOGGER.warn(METHOD_NAME + "Trying to modify NO editable Commodities");
        response = new ResponseEntity<>(notEditableCommodities, HttpStatus.BAD_REQUEST);
      }
    } catch (Exception e) {
      response = getErrorResponseAndLog(e, METHOD_NAME + ZUtils.EDITING_ENTITY_MSG);
    }
    return response;
  }
  
  @GetMapping(value = "/list")
  public ResponseEntity<?> getBasicProcessList() {
    final String METHOD_NAME = "[Method]: getProcess - ";
    ResponseEntity<?> response = null;
    LOGGER.info(METHOD_NAME + ZUtils.FETCHING_ENTITIES_MSG);
    try {
      response = ResponseEntity.ok(processService.getBasicProcessList());
    }catch(Exception e) {
      response = getErrorResponseAndLog(e, METHOD_NAME + ZUtils.ERROR_FETCHING_ENTITIES_MSG);
    }
    return response;
  }
  
  @GetMapping(value = "/{id}")
  public ResponseEntity<?> getProcessById(@PathVariable Long id) {
    final String METHOD_NAME = "[Method]: getProcessById - ";
    ResponseEntity<?> response = null;
    LOGGER.info(METHOD_NAME + ZUtils.FETCHING_ENTITY_MSG);
    try {
      response = ResponseEntity.ok(processService.getProcessById(id));
    }catch(Exception e) {
      response = getErrorResponseAndLog(e, METHOD_NAME + ZUtils.ERROR_FETCHING_ENTITY_MSG);
    }
    return response;
  }

}
