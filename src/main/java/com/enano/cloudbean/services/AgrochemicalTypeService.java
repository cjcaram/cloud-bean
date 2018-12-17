package com.enano.cloudbean.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enano.cloudbean.entities.AgrochemicalType;
import com.enano.cloudbean.repositories.AgrochemicalTypeRepository;

@Service
public class AgrochemicalTypeService {
  
  @Autowired
  private AgrochemicalTypeRepository repo;
  
  public List<AgrochemicalType> listAll() {
    return repo.findAll();
  }
  

}
