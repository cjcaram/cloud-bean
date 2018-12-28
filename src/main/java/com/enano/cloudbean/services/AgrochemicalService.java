package com.enano.cloudbean.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enano.cloudbean.dtos.WithdrawAgrochemicalDto;
import com.enano.cloudbean.dtos.WithdrawItemDto;
import com.enano.cloudbean.entities.Agrochemical;
import com.enano.cloudbean.entities.RemoveAgrochemical;
import com.enano.cloudbean.repositories.AgrochemicalRepository;
import com.enano.cloudbean.repositories.RemoveAgrochemicalRepository;

@Service
public class AgrochemicalService {
  
  @Autowired
  private AgrochemicalRepository repo;
  
  @Autowired
  private RemoveAgrochemicalRepository repoWithdraw;
  
  public List<Agrochemical> listAll() {
    return repo.findAll();
  }
  
  public Agrochemical getOne(Long id) {
    return repo.getOne(id);
  }
  
  public void deleteOne(Long id) {
    repo.deleteById(id);
  }
  
  public Agrochemical save(Agrochemical agrochemical) {
    agrochemical.setId(null);
    return repo.saveAndFlush(agrochemical);
  }
  
  public Agrochemical edit(Agrochemical agrochemical) {
    agrochemical.setModificationDate(new Date());
    return repo.saveAndFlush(agrochemical);
  }
  
  public List<String> listAllDistincAgrochemicalNames() {
    return repo.listAllDistincAgrochemicalNames();
  }
  
  public Agrochemical addAmountToStock(Long id, Integer amount) {
    Agrochemical agrochemical = null;
    if (amount != null && amount > 0) {
      agrochemical = repo.getOne(id);
      agrochemical.setModificationDate(new Date());
      agrochemical.setAmount(agrochemical.getAmount() + amount);
      agrochemical = repo.saveAndFlush(agrochemical);
    }
    return agrochemical;
  }

  public List<RemoveAgrochemical> withdrawAgrochemicals(WithdrawAgrochemicalDto withdrawOrder) throws Exception{
    List<RemoveAgrochemical> removeAgrochemicalList = new ArrayList<>();
    Agrochemical agrochemical;
    String workOrder = withdrawOrder.getWorkOrder();
    int withdrawAmt = 0;
    for (WithdrawItemDto item : withdrawOrder.getItems()) {
      withdrawAmt = item.getWithdrawAmt();
      agrochemical = repo.getOne(item.getId());
      if (checkIfStockExist(agrochemical, withdrawAmt)) {
        agrochemical = getWithdrawedAgrochemical(agrochemical, withdrawAmt);
        removeAgrochemicalList.add(new RemoveAgrochemical(workOrder, agrochemical, withdrawAmt));
      } else {
        throw new Exception("One or many agrochemical were not found.");
      }
    }
    return repoWithdraw.saveAll(removeAgrochemicalList); 
  }
  
  public List<RemoveAgrochemical> listAllWithdrawedAgrochemicals() {
    return repoWithdraw.findAll(); 
  }

  private boolean checkIfStockExist(Agrochemical agrochemical, int withdrawAmt) {
    return agrochemical != null && agrochemical.getAmount() >= withdrawAmt;
  }
  
  private Agrochemical getWithdrawedAgrochemical (Agrochemical agrochemical, int withdrawAmt) {
    agrochemical.setModificationDate(new Date());
    agrochemical.setAmount(agrochemical.getAmount() - withdrawAmt);
    return agrochemical;
  }
}
