package com.enano.cloudbean.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.enano.cloudbean.entities.Application;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long>{
  
  @Query(value = "select * from APLICACION aa where aa.LOTE_ID = ?1", 
      nativeQuery = true)
  List<Application> findByLandBatchId(Long landBatchId);

}
