package com.enano.cloudbean.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.enano.cloudbean.entities.RemoveAgrochemical;

@Repository
public interface RemoveAgrochemicalRepository extends JpaRepository<RemoveAgrochemical, Long>{
  
  @Query(value = "SELECT distinct(AR.ORDEN_TRABAJO) FROM AGROQUIMICO_RETIRO AR where AR.AGROQUIMICO_ID = ?1",
      nativeQuery = true)
  List<String> getWorkOrderByAgrochemicalId (Integer agrochemicalId);
}
