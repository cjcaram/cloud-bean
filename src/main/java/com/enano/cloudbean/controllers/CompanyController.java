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
import com.enano.cloudbean.dtos.CompanyDto;
import com.enano.cloudbean.services.CompanyService;

@RestController
@RequestMapping("/company")
public class CompanyController {
  
  @Autowired
  private CompanyService companyService;
  
  private HttpErrorBody httpErrorBody;
  private static final Logger LOGGER = LogManager.getLogger(CompanyController.class);
  
  @PostMapping(value = "/save")
  public ResponseEntity<?> AddOrModifyCompany(@RequestBody CompanyDto company) {
    ResponseEntity<?> response = null;
    try {
      if (ZUtils.isEdition(company.getId())) {
        LOGGER.info("Editing Company.");
        response = ResponseEntity.ok(companyService.edit(company));
      } else {
        LOGGER.info("Adding Company.");
        response = ResponseEntity.ok(companyService.save(company));
      }
    } catch (Exception e) {
      httpErrorBody = new HttpErrorBody(HttpStatus.INTERNAL_SERVER_ERROR, e, "Error adding or updating Company");
      response = ZUtils.getErrorResponse(httpErrorBody);
      LOGGER.error(httpErrorBody);
    }
    return response;
  }

  @GetMapping(value = "/list")
  public ResponseEntity<?> getCompanies() {
    ResponseEntity<?> response = null;
    try {
      LOGGER.info("Listing All Companies from list..");
      response = ResponseEntity.ok(companyService.listAll());
    }catch(Exception e) {
      httpErrorBody = new HttpErrorBody(HttpStatus.INTERNAL_SERVER_ERROR, e, "Error Trying to fetch all companies from list.");
      response = ZUtils.getErrorResponse(httpErrorBody);
      LOGGER.error(httpErrorBody);
    }
    return response;
  }
  
  @GetMapping(value = "/basic-list")
  public ResponseEntity<?> getCompaniesDto() {
    ResponseEntity<?> response = null;
    try {
      LOGGER.info("Listing All Companies Dtos from basic-list.");
      response = ResponseEntity.ok(companyService.listAllCompanyDto());
    }catch(Exception e) {
      httpErrorBody = new HttpErrorBody(HttpStatus.INTERNAL_SERVER_ERROR, e, "Error Trying to fetch all companies dtos from basic-list.");
      response = ZUtils.getErrorResponse(httpErrorBody);
      LOGGER.error(httpErrorBody);
    }
    return response;
  }
  
  @DeleteMapping(value = "/remove/{id}")
  public ResponseEntity<?> deleteCompany(@PathVariable long id) {
    ResponseEntity<?> response = null;
    try {
      LOGGER.info("Deleting Company.");
      companyService.deleteOne(id);
      response = ResponseEntity.ok("Company with id ${id} has been deleted");
    }catch(Exception e) {
      httpErrorBody = new HttpErrorBody(HttpStatus.INTERNAL_SERVER_ERROR, e, "Error Trying to Delete Company id " + id);
      response = ZUtils.getErrorResponse(httpErrorBody);
      LOGGER.error(httpErrorBody);
    }
    return response;
  }
}
