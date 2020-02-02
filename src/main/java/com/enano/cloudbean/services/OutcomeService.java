package com.enano.cloudbean.services;

import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enano.cloudbean.dtos.OutcomeRequestDto;
import com.enano.cloudbean.entities.CommodityStock;
import com.enano.cloudbean.entities.Outcome;
import com.enano.cloudbean.repositories.OutcomeRepository;

@Service
public class OutcomeService {
  
  @Autowired
  private OutcomeRepository outcomeRepo;
  
  @Autowired
  private CommodityStockService commodityStockService;
  
  public List<Outcome> listAll() {
    List<Outcome> outcomes = outcomeRepo.findAll();
    return outcomes;
  }
  
  public Outcome edit(Outcome outcome) {
    return outcomeRepo.saveAndFlush(outcome);
  }
  
  @Transactional
  public Outcome save(Outcome outcome) throws Exception {
    outcome.setId(null);
    Outcome savedOutcome = null;
    if (true) {// (isValidWithdrawCommodityStock(outcome)) {
      savedOutcome = outcomeRepo.save(outcome);
      //commodityStockService.withdrawCommodityStock(savedOutcome);
    } else {
      throw new Exception("Error al intentar utilizar la mercadería existente.");
    }
    return savedOutcome;
  }
  
  private boolean isValidWithdrawCommodityStock(Outcome outcome) {
    boolean result = false;
    int withdrawAmt = outcome.getGrossWeight() - outcome.getTruckWeight();
    CommodityStock actualCommodityStock = null; 
//    if (outcome.getCommodityStock() != null) {
//      actualCommodityStock = commodityStockService.getOne(outcome.getCommodityStock().getId());
//      if ((actualCommodityStock != null) && (withdrawAmt <= actualCommodityStock.getAmount())) {
//        result = true;
//      }
//    }
    return result;
  }


}
