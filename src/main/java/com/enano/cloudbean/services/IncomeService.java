package com.enano.cloudbean.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enano.cloudbean.entities.Income;
import com.enano.cloudbean.repositories.IncomeRepository;

@Service
public class IncomeService {
  
  @Autowired
  private IncomeRepository repo;

  public Income edit(Income income) {
    return repo.saveAndFlush(income); 
  }

  public Income save(Income income) {
    income.setId(null);
    return repo.saveAndFlush(income); 
  }

  public List<Income> listAll() {
    return repo.findAll();
  }

  
}
