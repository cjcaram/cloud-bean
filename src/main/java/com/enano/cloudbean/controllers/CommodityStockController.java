package com.enano.cloudbean.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enano.cloudbean.dtos.CommodityFilterDto;
import com.enano.cloudbean.services.CommodityStockService;

@RestController
@RequestMapping("/commodity-stock")
public class CommodityStockController extends BaseController {
  @Autowired
  private CommodityStockService stockService;
  
  private static final Logger LOGGER = LogManager.getLogger(CommodityStockController.class);
  
  @GetMapping(value = "/list/{page}/{processId}")
  public ResponseEntity<?> getTenCommoditiesPerPage(@PathVariable Integer page, @PathVariable Integer processId) {
    ResponseEntity<?> response = null;
    try {
      LOGGER.info(ZUtils.FETCHING_ENTITIES_MSG);
      response = ResponseEntity.ok(stockService.listAll(page, processId));
    } catch(Exception e) {
      response = getErrorResponseAndLog(e, ZUtils.ERROR_FETCHING_ENTITIES_MSG);
    }
    return response;
  }
  
  @PostMapping(value = "/filter")
  public ResponseEntity<?> getFilteredStocks(@RequestBody CommodityFilterDto filters) {
    ResponseEntity<?> response = null;
    try {
      LOGGER.info("[Method]: getFilteredStocks - " + ZUtils.FETCHING_ENTITIES_MSG);
      response = ResponseEntity.ok(stockService.findStockUsingFilters(filters));
    }catch(Exception e) {
      response = getErrorResponseAndLog(e, ZUtils.ERROR_FETCHING_ENTITIES_MSG);
    }
    return response;
  }
}
