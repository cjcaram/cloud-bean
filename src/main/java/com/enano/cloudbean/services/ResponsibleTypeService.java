package com.enano.cloudbean.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enano.cloudbean.entities.ResponsibleType;
import com.enano.cloudbean.repositories.ResponsibleTypeRepository;

@Service
public class ResponsibleTypeService {
  @Autowired
  private ResponsibleTypeRepository roleRepo;
  
  public List<ResponsibleType> listAll() {
    return roleRepo.findAll();
  }
    
}

