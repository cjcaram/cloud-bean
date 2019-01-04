package com.enano.cloudbean.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enano.cloudbean.dtos.LandBatchDto;
import com.enano.cloudbean.services.LandBatchService;

@RestController
@RequestMapping("/land-batch")
public class LandBatchController extends BaseController{
  
  @Autowired
  private LandBatchService landBatchService;
  
  private static final Logger LOGGER = LogManager.getLogger(LandBatchController.class);
  
  @PostMapping(value = "/save")
  public ResponseEntity<?> AddOrModifyLandBatch(@RequestBody LandBatchDto landBatch) {
    ResponseEntity<?> response = null;
    try {
      if (ZUtils.isEdition(landBatch.getId())) {
        LOGGER.info(ZUtils.EDITING_ENTITY_MSG);
        response = ResponseEntity.ok(landBatchService.edit(landBatch));
      } else {
        LOGGER.info(ZUtils.ADDING_ENTITY_MSG);
        response = ResponseEntity.ok(landBatchService.save(landBatch));
      }
    } catch (Exception e) {
      response = getErrorResponseAndLog(e, ZUtils.ERROR_ADD_EDIT_ENTITY_MSG);
    }
    return response;
  }
  
  
  @GetMapping(value = "/list")
  public ResponseEntity<?> getLandBatchList() {
    ResponseEntity<?> response = null;
    try {
      LOGGER.info(ZUtils.FETCHING_ENTITIES_MSG);
      response = ResponseEntity.ok(landBatchService.listAllLandBatch());
    }catch(Exception e) {
      response = getErrorResponseAndLog(e, ZUtils.ERROR_FETCHING_ENTITIES_MSG);
    }
    return response;
  }
  
  @DeleteMapping(value = "/remove/{id}")
  public ResponseEntity<?> deleteLocation(@PathVariable Long id) {
    ResponseEntity<?> response = null;
    try {
      // response = deleteIfNoDependeciesExist(id);
      landBatchService.deleteOne(id);
      response = ResponseEntity.ok(ZUtils.ENTITY_REMOVED_MSG); 
    }catch(Exception e) {
      response = getErrorResponseAndLog(e, ZUtils.ERROR_REMOVING_ENTITY_MSG);
    }
    return response;
  }

}
