package com.enano.cloudbean.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enano.cloudbean.entities.Outcome;
import com.enano.cloudbean.repositories.OutcomeRepository;

@Service
public class OutcomeService {
  
  @Autowired
  private OutcomeRepository outcomeRepo;
  
  public List<Outcome> listAll() {
    return outcomeRepo.findAll();
  }
  
  public Outcome save(Outcome outcome) {
    outcome.setId(null);
    return outcomeRepo.saveAndFlush(outcome);
  }
  
  public Outcome edit(Outcome outcome) {
    return outcomeRepo.saveAndFlush(outcome);
  }

}
