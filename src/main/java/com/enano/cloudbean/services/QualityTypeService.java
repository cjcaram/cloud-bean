package com.enano.cloudbean.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enano.cloudbean.entities.QualityType;
import com.enano.cloudbean.repositories.QualityTypeRepository;

@Service
public class QualityTypeService {
  
  @Autowired
  private QualityTypeRepository qualityTypeRepo;
  
  public QualityType getQualityTypeByName(String name) {
    return qualityTypeRepo.findByQualityType(name);
  }
}
