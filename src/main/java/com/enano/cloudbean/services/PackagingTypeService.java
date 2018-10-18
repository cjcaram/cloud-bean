package com.enano.cloudbean.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enano.cloudbean.entities.PackagingType;
import com.enano.cloudbean.repositories.PackagingTypeRepository;

@Service
public class PackagingTypeService {

  @Autowired
  private PackagingTypeRepository repo;
  
  public List<PackagingType> listAll(){
    return repo.findAll();
  }
  
}
