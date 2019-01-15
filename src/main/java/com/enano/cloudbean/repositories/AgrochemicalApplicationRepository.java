package com.enano.cloudbean.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.enano.cloudbean.entities.AgrochemicalApplication;

@Repository
public interface AgrochemicalApplicationRepository extends JpaRepository<AgrochemicalApplication, Long>{
  
  @Modifying
  @Query(value = "delete from AGROQUIMICO_APLICACION where APLICACION_ID = ?1", 
      nativeQuery = true)
  void deleteByApplicationId(Long ApplicationId);
  
  
  @Query(value = "select * from AGROQUIMICO_APLICACION where APLICACION_ID = ?1", 
      nativeQuery = true)
  List<AgrochemicalApplication> findByApplicationId(Long ApplicationId);

}
