package com.enano.cloudbean.controllers;


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
      response = new ResponseEntity<>(httpErrorBody.getKnownErros(), httpErrorBody.getHttpStatus());
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
      response = new ResponseEntity<>(httpErrorBody, HttpStatus.INTERNAL_SERVER_ERROR);
      LOGGER.error(httpErrorBody);
    }
    return response;
  }
  
  @DeleteMapping(value = "/remove/{id}")
  public ResponseEntity<?> deleteCompany(@PathVariable long id) {
    ResponseEntity<?> response = null;
    try {
      LOGGER.info("Editing Location.");
      locationService.deleteOne(id);
      response = ResponseEntity.ok("Compnay with id ${id} has been deleted");
    }catch(Exception e) {
      httpErrorBody = new HttpErrorBody(HttpStatus.INTERNAL_SERVER_ERROR, e, "Error Delete Location " + id);
      response = new ResponseEntity<>(httpErrorBody, HttpStatus.INTERNAL_SERVER_ERROR);
      LOGGER.error(httpErrorBody);
    }
    return response;
  }
}
