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

import com.enano.cloudbean.dtos.HttpErrorBody;
import com.enano.cloudbean.entities.ComercialEntity;
import com.enano.cloudbean.services.CompanyService;

@RestController
@RequestMapping("/company")
public class CompanyController {
  
  @Autowired
  private CompanyService companyService;
  
  private HttpErrorBody httpErrorBody;
  private static final Logger LOGGER = LogManager.getLogger(CompanyController.class);
  
  @PostMapping(value = "/save")
  public ResponseEntity<?> AddOrModifyCompany(@RequestBody ComercialEntity company) {
    ResponseEntity<?> response = null;
    try {
      if (ZUtils.isEdition(company.getId())) {
        LOGGER.info(ZUtils.EDITING_ENTITY_MSG);
        response = ResponseEntity.ok(companyService.edit(company));
      } else {
        LOGGER.info(ZUtils.ADDING_ENTITY_MSG);
        response = ResponseEntity.ok(companyService.save(company));
      }
    } catch (Exception e) {
      response = getErrorResponseAndLog(e, ZUtils.ERROR_ADD_EDIT_ENTITY_MSG);
    }
    return response;
  }

  
  @GetMapping(value = "/list")
  public ResponseEntity<?> getCompanies() {
    ResponseEntity<?> response = null;
    try {
      LOGGER.info(ZUtils.FETCHING_ENTITIES_MSG);
      response = ResponseEntity.ok(companyService.listAll());
    }catch(Exception e) {
      response = getErrorResponseAndLog(e, ZUtils.ERROR_FETCHING_ENTITIES_MSG);
    }
    return response;
  }
  
  @GetMapping(value = "/basic-list")
  public ResponseEntity<?> getCompaniesDto() {
    ResponseEntity<?> response = null;
    try {
      LOGGER.info(ZUtils.FETCHING_ENTITIES_MSG + "(basic-list)");
      response = ResponseEntity.ok(companyService.listAllCompanyDto());
    }catch(Exception e) {
      response = getErrorResponseAndLog(e, ZUtils.ERROR_FETCHING_ENTITIES_MSG + " (basic-list)");
    }
    return response;
  }
  
  @GetMapping(value = "/base-list")
  public ResponseEntity<?> getBaseCompaniesDto() {
    ResponseEntity<?> response = null;
    try {
      LOGGER.info(ZUtils.FETCHING_ENTITIES_MSG + "(base-list)");
      response = ResponseEntity.ok(companyService.listAllBaseCompanyDto());
    }catch(Exception e) {
      response = getErrorResponseAndLog(e, ZUtils.ERROR_FETCHING_ENTITIES_MSG + " (base-list)");
    }
    return response;
  }
  
  @DeleteMapping(value = "/remove/{id}")
  public ResponseEntity<?> deleteCompany(@PathVariable Integer id) {
    ResponseEntity<?> response = null;
    try {
      response = deleteIfNoDependeciesExist(id);
    }catch(Exception e) {
      response = getErrorResponseAndLog(e, ZUtils.ERROR_REMOVING_ENTITY_MSG);
    }
    return response;
  }

  private ResponseEntity<?> deleteIfNoDependeciesExist(Integer id) {
    ResponseEntity<?> response;
    LOGGER.info(ZUtils.CHECKING_DEPENDENCIES_MSG);
    List<String> userList = companyService.getUsersAssociatedWithCompanyId(id);
    if (userList.size() > 0) {
      LOGGER.info(ZUtils.DEPENDENCIES_FOUNDS_MSG);
      response = new ResponseEntity<>(userList, HttpStatus.FAILED_DEPENDENCY);
    } else {
      LOGGER.info(ZUtils.REMOVING_ENTITY_MSG);
      companyService.deleteOne(id);
      response = ResponseEntity.ok(ZUtils.ENTITY_REMOVED_MSG);
    }
    return response;
  }
  
  private ResponseEntity<?> getErrorResponseAndLog(Exception e, String errorMsg) {
    ResponseEntity<?> response;
    httpErrorBody = new HttpErrorBody(HttpStatus.INTERNAL_SERVER_ERROR, e, errorMsg);
    response = ZUtils.getErrorResponse(httpErrorBody);
    LOGGER.error(httpErrorBody);
    return response;
  }

}
