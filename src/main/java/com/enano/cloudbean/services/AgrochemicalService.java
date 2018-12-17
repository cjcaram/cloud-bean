package com.enano.cloudbean.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enano.cloudbean.entities.Agrochemical;
import com.enano.cloudbean.repositories.AgrochemicalRepository;

@Service
public class AgrochemicalService {
  
  @Autowired
  private AgrochemicalRepository repo;
  
  public List<Agrochemical> listAll() {
    return repo.findAll();
  }
  
  public Agrochemical getOne(Integer id) {
    return repo.getOne(id.longValue());
  }
  
  public Agrochemical save(Agrochemical agrochemical) {
    agrochemical.setId(null);
    return repo.saveAndFlush(agrochemical);
  }
  
  public Agrochemical edit(Agrochemical agrochemical) {
    agrochemical.setModificationDate(new Date());
    return repo.saveAndFlush(agrochemical);
  }
}
