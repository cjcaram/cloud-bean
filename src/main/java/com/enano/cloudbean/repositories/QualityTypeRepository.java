package com.enano.cloudbean.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enano.cloudbean.entities.QualityType;

@Repository
public interface QualityTypeRepository extends JpaRepository<QualityType, Long>{
  
  public QualityType findByQualityType(String qualityType);

}
