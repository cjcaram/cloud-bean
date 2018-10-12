package com.enano.cloudbean.controllers;


import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enano.cloudbean.dtos.CompanyDto;
import com.enano.cloudbean.dtos.HttpErrorBody;
import com.enano.cloudbean.dtos.LocationDto;
import com.enano.cloudbean.services.LocationService;

@RestController
@RequestMapping("/location")
public class LocationController {
  
  @Autowired
  private LocationService locationService;
  
  private HttpErrorBody httpErrorBody;
  private static final Logger LOGGER = LogManager.getLogger(LocationController.class);
  
  @PostMapping(value = "/save")
  public ResponseEntity<?> AddOrModifyLocation(@RequestBody LocationDto location) {
    ResponseEntity<?> response = null;
    try {
      if (ZUtils.isEdition(location.getId())) {
        LOGGER.info(ZUtils.EDITING_ENTITY_MSG);
        response = ResponseEntity.ok(locationService.edit(location));
      } else {
        LOGGER.info(ZUtils.ADDING_ENTITY_MSG);
        response = ResponseEntity.ok(locationService.save(location));
      }
    } catch (Exception e) {
      httpErrorBody = new HttpErrorBody(HttpStatus.INTERNAL_SERVER_ERROR, e, ZUtils.ERROR_ADD_EDIT_ENTITY_MSG);
      response = ZUtils.getErrorResponse(httpErrorBody);
      LOGGER.error(httpErrorBody);
    }
    return response;
  }

  @GetMapping(value = "/list")
  public ResponseEntity<?> getLocations() {
    ResponseEntity<?> response = null;
    try {
      LOGGER.info(ZUtils.FETCHING_ENTITIES_MSG);
      response = ResponseEntity.ok(locationService.listAll());
    }catch(Exception e) {
      httpErrorBody = new HttpErrorBody(HttpStatus.INTERNAL_SERVER_ERROR, e, ZUtils.ERROR_FETCHING_ENTITIES_MSG);
      response = ZUtils.getErrorResponse(httpErrorBody);
      LOGGER.error(httpErrorBody);
    }
    return response;
  }
  
  @DeleteMapping(value = "/remove/{id}")
  public ResponseEntity<?> deleteLocation(@PathVariable Integer id) {
    ResponseEntity<?> response = null;
    try {
      response = deleteIfNoDependeciesExist(id);
    }catch(Exception e) {
      httpErrorBody = new HttpErrorBody(HttpStatus.INTERNAL_SERVER_ERROR, e, ZUtils.ERROR_REMOVING_ENTITY_MSG);
      response = ZUtils.getErrorResponse(httpErrorBody);
      LOGGER.error(httpErrorBody);
    }
    return response;
  }

  private ResponseEntity<?> deleteIfNoDependeciesExist(Integer id) {
    ResponseEntity<?> response;
    LOGGER.info(ZUtils.CHECKING_DEPENDENCIES_MSG);
    List<CompanyDto> companyList = locationService.getCompaniesAssociatedWithLocationId(id);
    if (companyList.size() > 0) {
      LOGGER.info(ZUtils.DEPENDENCIES_FOUNDS_MSG);
      response = new ResponseEntity<>(companyList, HttpStatus.FAILED_DEPENDENCY);
    } else {
      LOGGER.info(ZUtils.REMOVING_ENTITY_MSG);
      locationService.deleteOne(id);
      response = ResponseEntity.ok(ZUtils.ENTITY_REMOVED_MSG);
    }
    return response;
  }
}
