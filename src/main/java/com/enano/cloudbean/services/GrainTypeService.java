package com.enano.cloudbean.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enano.cloudbean.entities.GrainType;
import com.enano.cloudbean.repositories.GrainTypeRepository;

@Service
public class GrainTypeService {

  @Autowired
  private GrainTypeRepository repo;
  
  public List<GrainType> listAll() {
    return repo.findAll();
  }
}
