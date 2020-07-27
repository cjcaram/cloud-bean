package com.enano.cloudbean.services;

import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enano.cloudbean.dtos.OutcomeRequestDto;
import com.enano.cloudbean.entities.CommodityStock;
import com.enano.cloudbean.entities.Outcome;
import com.enano.cloudbean.repositories.OutcomeRepository;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class OutcomeService {
  
  @Autowired
  private OutcomeRepository outcomeRepo;
  
  @Autowired
  private CommodityStockService commodityStockService;
  
  private ObjectMapper objectMapper = new ObjectMapper();
  
  public List<Outcome> listAll() {
    List<Outcome> outcomes = outcomeRepo.findAll();
    return outcomes;
  }
  
  public Outcome edit(OutcomeRequestDto outcomeDto) {
    return outcomeRepo.saveAndFlush(OutcomeRequestDto.From(outcomeDto));
  }
  
  @Transactional
  public Outcome save(OutcomeRequestDto outcomeDto) throws Exception {
    Set<CommodityStock> commodityStockToWithdraw = deepCopyCommodityStockList(outcomeDto.getCommodityStock());
//    Collections.copy(commodityStockToWithdraw, outcomeDto.getCommodityStock()
//        .stream().collect(Collectors.toCollection(ArrayList::new)));
    Outcome outcomeToSave = OutcomeRequestDto.From(outcomeDto);
    outcomeToSave.setId(null);
    Outcome savedOutcome = null;
    if (isValidWithdrawCommodityStock(outcomeToSave)) {
      savedOutcome = outcomeRepo.save(outcomeToSave);
      commodityStockService.withdrawCommodityStock(savedOutcome.getId(), commodityStockToWithdraw);
    } else {
      throw new Exception("La cantidad de mercadería que lleva el camión no coincide con la cantidad especifada para retirar en cada lote de mercadería.");
    }
    return savedOutcome;
  }
  
  public Set<CommodityStock> deepCopyCommodityStockList(Set<CommodityStock> commodityStock) {
    Set<CommodityStock> deepCopyList = new HashSet<>();
    Iterator<CommodityStock> iterableCommodityStock = commodityStock.iterator();
    while (iterableCommodityStock.hasNext()) {
      try {
        deepCopyList.add(objectMapper
          .readValue(objectMapper.writeValueAsString(iterableCommodityStock.next()), CommodityStock.class));
      } catch (JsonParseException e) {
        System.out.println("error JsonParseException");
        e.printStackTrace();
      } catch (JsonMappingException e) {
        System.out.println("error JsonMappingException");
        e.printStackTrace();
      } catch (JsonProcessingException e) {
        System.out.println("error JsonProcessingException");
        e.printStackTrace();
      } catch (IOException e) {
        System.out.println("error IOException");
        e.printStackTrace();
      }
    }
    return deepCopyList;
  }

  private boolean isValidWithdrawCommodityStock(Outcome outcome) {
    boolean result = false;
    int withdrawAmtTruck = outcome.getGrossWeight() - outcome.getTruckWeight();
    if (outcome.getCommodities() != null) {
      int withdrawAmtCommodities = outcome.getCommodities().stream().mapToInt(x -> x.getAmount()).sum();
      if (withdrawAmtCommodities == withdrawAmtTruck) {
        result = true;
      }
    }
    return result;
  }
}
