package com.enano.cloudbean.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enano.cloudbean.entities.AgrochemicalAppType;
import com.enano.cloudbean.repositories.AgrochemicalAppTypeRepository;

@Service
public class AgrochemicalAppTypeService {
  
  @Autowired
  private AgrochemicalAppTypeRepository repo;
  
  public List<AgrochemicalAppType> listAll(){
    return repo.findAll();
  }
  

}
