package com.enano.cloudbean.services;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.enano.cloudbean.dtos.CommodityDto;
import com.enano.cloudbean.entities.Commodity;
import com.enano.cloudbean.entities.CommodityStock;
import com.enano.cloudbean.entities.Income;
import com.enano.cloudbean.entities.Process;
import com.enano.cloudbean.repositories.CommodityStockRepository;

@Service
public class CommodityStockService {
  
  private Logger LOGGER = LogManager.getLogger(CommodityStockService.class);

  @Autowired
  private CommodityStockRepository commodityStockRepo;

  /** Adding stock when new incomes are saved
   * 
   * @param income
   */
  public void addNewIncome(Income income) throws Exception {
    try {
      LOGGER.info("[Method: addNewIncome] - adding stock from new income");
      CommodityStock stock = CommodityDto.From(income.getCommodities().iterator().next());
      stock.setId(null);
      stock.setIncomeId(income.getId());
      commodityStockRepo.save(stock);
    } catch (Exception ex) {
      LOGGER.error("Error adding stock from new income.", ex);
      throw ex;
    }
  }

  /** Edit Stock when income is modified
   * 
   * @param income
   */
  public void editCommodityAccordingNewAnalysis(Income income) throws Exception {
    try {
      LOGGER.info("[Method: editCommodityAccordingNewAnalysis] - editing stock according new analysis");
      CommodityStock oldStock = commodityStockRepo.findByIncomeId(income.getId());
      CommodityStock newStock = CommodityDto.From(income.getCommodities().iterator().next());
      newStock.setId(oldStock.getId());
      newStock.setIncomeId(oldStock.getIncomeId());
      if (income.getAnalysis() != null) {
        newStock.setGramaje(income.getAnalysis().getGramaje());
      }
      commodityStockRepo.save(newStock);
    } catch (Exception ex) {
      LOGGER.error("Error editing Stock when income is modified.", ex);
      throw ex;
    }
  }

  /** Calculate and save Stock when new Process is added to db
   * 
   * @param processId
   * @param process
   */
  public void addNewProcess(Process process) {
    LOGGER.info("[Method: addNewProcess] - modifying stock from new process");
    try {
      removeProcessedStock(process);
      addProcessedStock(process);
    } catch (Exception e) {
      LOGGER.error("[addNewProcess] - Error updating stock.");
      throw e;
    }
  }
  
  /** Removing stock when an outcome is produced  
   * 
   * @param outcome
   * @throws Exception if commodity is not present in stock
   */
  public void withdrawCommodityStock(Long outcomeId, Set<CommodityStock> commodityStockToWithdraw) throws Exception {
    LOGGER.info("[Method: withdrawCommodityStock] - Removing stock when an outcome is produced");
    Set<Long> stocksIds = commodityStockToWithdraw.stream()
        .map(CommodityStock::getId)
        .collect(Collectors.toSet());
    List<CommodityStock> actualCommodityStock =
        commodityStockRepo.findAllById(stocksIds);
    
    CommodityStock stock = null;
    try {
      for (int i = 0; i < actualCommodityStock.size(); i++) {
        stock = actualCommodityStock.get(i);
        actualCommodityStock.get(i).setOutcomeId(outcomeId);
        actualCommodityStock.set(i, withdrawBagQtyAndAmt(actualCommodityStock.get(i), commodityStockToWithdraw));
      }
    } catch (Exception e) {
      LOGGER.debug(e.getMessage() + "stock id: " + stock.getId());
      throw e;
    }
    removeCommodityStockIfAmountIsZero(actualCommodityStock);
    actualCommodityStock.removeIf(x -> (x.getAmount() == null || x.getAmount() == 0));
    commodityStockRepo.saveAll(actualCommodityStock);
  }

  private CommodityStock withdrawBagQtyAndAmt(CommodityStock stock, Set<CommodityStock> withdrawedCommodities) throws Exception {
    Optional<CommodityStock> withdrawedCommodity = 
        withdrawedCommodities.stream()
          .filter(x -> x.getId() == stock.getId())
          .findFirst();
    
    if (withdrawedCommodity.isPresent()) {
      stock.setAmount(stock.getAmount() - withdrawedCommodity.get().getAmount());
      stock.setBagQuantity(stock.getBagQuantity() - withdrawedCommodity.get().getBagQuantity());
    } else {
      throw new Exception("Una de las mercaderías que esta intentando retirar no esta presente en el stock."); 
    }
    return stock;
  }

  private void removeCommodityStockIfAmountIsZero(List<CommodityStock> actualCommodityStock) {
    Set<CommodityStock> stocksToRemove = actualCommodityStock.stream()
        .filter(x -> (x.getAmount() == null || x.getAmount() == 0))
        .collect(Collectors.toSet());
    if (stocksToRemove != null && stocksToRemove.size() > 0) {
      commodityStockRepo.deleteInBatch(stocksToRemove);
    }
  }

  public Page<CommodityStock> listAll(Integer pageNumber, Integer processId) {
    Pageable page = null;
    Page<CommodityStock> result;
    if (pageNumber == null) {
      page = PageRequest.of(0, 10);
    }
    page = PageRequest.of(pageNumber, 10);

    if (processId == null || processId < 0) {
      result = commodityStockRepo.findAll(page);
    } else {
      result = commodityStockRepo.findByProcessId(page, processId.longValue());
    }
    return result;
  }

  public CommodityStock getOne(Long id) {
    return commodityStockRepo.getOne(id);
  }

  public void saveAll(List<CommodityStock> entities) {
    commodityStockRepo.saveAll(entities);
  }

  /** Change stock according process edition
   * 
   * @param process
   */
  @Transactional
  public void editProcess(Process process) {
    removeProcessedStock(process);
    removeOldStockNotModifiedByOutcome(process.getId());
    
    addProcessedStock(process);
  }
  
  private void removeOldStockNotModifiedByOutcome(Long processId) {
    List<CommodityStock> oldStock = commodityStockRepo.
        findByProcessIdAndOutcomeIdIsNull(processId);
    commodityStockRepo.deleteAll(oldStock);
  }

  private void addProcessedStock(Process process) {
    LOGGER.info("[Method: addProcessedStock] - adding stock from process");
    Set<CommodityStock> newStocks = new HashSet<>();
    Iterator<Commodity> commoditiesToAdd = process.getCommoditiesProcessed().iterator();
    while (commoditiesToAdd.hasNext()) {
      Commodity commodity = commoditiesToAdd.next();
      CommodityStock stockItem = CommodityDto.From(commodity);
      stockItem.setProcessId(process.getId());;
      newStocks.add(stockItem);
    }
    commodityStockRepo.saveAll(newStocks);
  }
  
  private void removeProcessedStock(Process process) {
    LOGGER.info("[Method: removeProcessedStock] - remove stock (from income) taken by process");
    Iterator<Commodity> commoditiesToRemove = process.getCommoditiesToProcess().iterator();
    Set<CommodityStock> stocksToRemove = new HashSet<>();
    while (commoditiesToRemove.hasNext()) {
      Commodity commodity = commoditiesToRemove.next();
      CommodityStock currentStock = commodityStockRepo.findByCommodityId(commodity.getId());
      if (currentStock != null && currentStock.getId() > 0) {
        stocksToRemove.add(currentStock);
      }
    }
    commodityStockRepo.deleteAll(stocksToRemove);
  }
  
}
