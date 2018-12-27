package com.enano.cloudbean.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enano.cloudbean.dtos.WithdrawAgrochemicalDto;
import com.enano.cloudbean.entities.Agrochemical;
import com.enano.cloudbean.services.AgrochemicalService;

@RestController
@RequestMapping("/agrochemical")
public class AgrochemicalController extends BaseController {
  
  @Autowired
  private AgrochemicalService agroService;
  
  private static final Logger LOGGER = LogManager.getLogger(AgrochemicalController.class);
  
  @PostMapping(value = "/save")
  public ResponseEntity<?> AddOrModifyAgrochemical(@RequestBody Agrochemical agrochemical) {
    ResponseEntity<?> response = null;
    Agrochemical result = new Agrochemical();
    try {
      if (ZUtils.isEdition(agrochemical.getId())) {
        LOGGER.info(ZUtils.EDITING_ENTITY_MSG);
        result = agroService.edit(agrochemical);
      } else {
        LOGGER.info(ZUtils.ADDING_ENTITY_MSG);
        result = agroService.save(agrochemical);
      }
      response = ResponseEntity.ok(result);
    } catch (Exception e) {
      response = getErrorResponseAndLog(e, ZUtils.ERROR_ADD_EDIT_ENTITY_MSG);
    }
    return response;
  }
  
  @PostMapping(value = "/withdraw")
  public ResponseEntity<?> withdrawAgrochemical(@RequestBody WithdrawAgrochemicalDto withdrawOrder) {
    ResponseEntity<?> response = null;
    try {
      LOGGER.info(ZUtils.EDITING_ENTITY_MSG);
      LOGGER.info(ZUtils.ADDING_ENTITY_MSG);
      response = ResponseEntity.ok(agroService.withdrawAgrochemicals(withdrawOrder));
    } catch (Exception e) {
      response = getErrorResponseAndLog(e, ZUtils.ERROR_ADD_EDIT_ENTITY_MSG);
    }
    return response;
  }
  
  @GetMapping(value = "/withdraw")
  public ResponseEntity<?> getAllWithdrawedAgrochemicals() {
    ResponseEntity<?> response = null;
    try {
      LOGGER.info(ZUtils.FETCHING_ENTITIES_MSG);
      response = ResponseEntity.ok(agroService.listAllWithdrawedAgrochemicals());
    }catch(Exception e) {
      response = getErrorResponseAndLog(e, ZUtils.ERROR_FETCHING_ENTITIES_MSG);
    }
    return response;
  }

  @GetMapping(value = "/list")
  public ResponseEntity<?> getAllAgrochemicals() {
    ResponseEntity<?> response = null;
    try {
      LOGGER.info(ZUtils.FETCHING_ENTITIES_MSG);
      response = ResponseEntity.ok(agroService.listAll());
    }catch(Exception e) {
      response = getErrorResponseAndLog(e, ZUtils.ERROR_FETCHING_ENTITIES_MSG);
    }
    return response;
  }
  
  @GetMapping(value = "/{id}")
  public ResponseEntity<?> getAgrochemicalById(@PathVariable Long id) {
    ResponseEntity<?> response = null;
    try {
      LOGGER.info(ZUtils.FETCHING_ENTITY_MSG);
      response = ResponseEntity.ok(agroService.getOne(id));
    }catch(Exception e) {
      response = getErrorResponseAndLog(e, ZUtils.ERROR_FETCHING_ENTITY_MSG);
    }
    return response;
  }
  
  @GetMapping(value = "/names")
  public ResponseEntity<?> getAllDistincAgrochemicalNames() {
    ResponseEntity<?> response = null;
    try {
      LOGGER.info(ZUtils.FETCHING_ENTITIES_MSG);
      response = ResponseEntity.ok(agroService.listAllDistincAgrochemicalNames());
    }catch(Exception e) {
      response = getErrorResponseAndLog(e, ZUtils.ERROR_FETCHING_ENTITIES_MSG);
    }
    return response;
  }
  
  @GetMapping(value = "/sum/{id}/{amount}")
  public ResponseEntity<?> getAgrochemicalById(@PathVariable Long id, @PathVariable Integer amount) {
    ResponseEntity<?> response = null;
    try {
      LOGGER.info(ZUtils.EDITING_ENTITY_MSG);
      response = ResponseEntity.ok(agroService.addAmountToStock(id, amount));
    }catch(Exception e) {
      response = getErrorResponseAndLog(e, ZUtils.ERROR_ADD_EDIT_ENTITY_MSG);
    }
    return response;
  }
  
  @DeleteMapping(value = "/remove/{id}")
  public ResponseEntity<?> deleteLocation(@PathVariable Long id) {
    ResponseEntity<?> response = null;
    try {
      agroService.deleteOne(id);
      response = ResponseEntity.ok(HttpStatus.ACCEPTED.getReasonPhrase());
    }catch(Exception e) {
      response = getErrorResponseAndLog(e, ZUtils.ERROR_REMOVING_ENTITY_MSG);
    }
    return response;
  }

}
