package com.enano.cloudbean.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enano.cloudbean.entities.Analysis;
import com.enano.cloudbean.repositories.AnalysisRepository;

@Service
public class AnalysisService {

  @Autowired
  private AnalysisRepository repo;
  
  public List<Analysis> listAll() {
    return repo.findAll();
  }
  
  public Analysis getOne(Integer id) {
    return repo.getOne(id.longValue());
  }
  
  public Analysis save(Analysis analysis) {
    analysis.setId(null);
    return repo.saveAndFlush(analysis);
  }
  
  public Analysis edit(Analysis analysis) {
    analysis.setModificationDate(new Date());
    return repo.saveAndFlush(analysis);
  }
}
