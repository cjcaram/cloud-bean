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
        LOGGER.info("Edditing Location.");
        response = ResponseEntity.ok(locationService.edit(location));
      } else {
        LOGGER.info("Adding Location.");
        response = ResponseEntity.ok(locationService.save(location));
      }
    } catch (Exception e) {
      httpErrorBody = new HttpErrorBody(HttpStatus.INTERNAL_SERVER_ERROR, e, "Error adding or updating Location");
      response = ZUtils.getErrorResponse(httpErrorBody);
      LOGGER.error(httpErrorBody);
    }
    return response;
  }

  @GetMapping(value = "/list")
  public ResponseEntity<?> getCompanies() {
    ResponseEntity<?> response = null;
    try {
      LOGGER.info("Listing All Location.");
      response = ResponseEntity.ok(locationService.listAll());
    }catch(Exception e) {
      httpErrorBody = new HttpErrorBody(HttpStatus.INTERNAL_SERVER_ERROR, e, "Error Trying to Locations");
      response = ZUtils.getErrorResponse(httpErrorBody);
      LOGGER.error(httpErrorBody);
    }
    return response;
  }
  
  @DeleteMapping(value = "/remove/{id}")
  public ResponseEntity<?> deleteCompany(@PathVariable Integer id) {
    ResponseEntity<?> response = null;
    try {
      response = deleteIfNoDependeciesExist(id);
    }catch(Exception e) {
      httpErrorBody = new HttpErrorBody(HttpStatus.INTERNAL_SERVER_ERROR, e, "Error Deleting Location " + id);
      response = ZUtils.getErrorResponse(httpErrorBody);
      LOGGER.error(httpErrorBody);
    }
    return response;
  }

  private ResponseEntity<?> deleteIfNoDependeciesExist(Integer id) {
    ResponseEntity<?> response;
    LOGGER.info("Checking Location dependencies.");
    List<CompanyDto> companyList = locationService.getCompaniesAssociatedWithLocationId(id);
    if (companyList.size() > 0) {
      LOGGER.info("Dependencies Founds.");
      response = new ResponseEntity<>(companyList, HttpStatus.FAILED_DEPENDENCY);
    } else {
      LOGGER.info("Deleting Location.");
      locationService.deleteOne(id);
      response = ResponseEntity.ok("Company with id ${id} has been deleted");
    }
    return response;
  }
}
