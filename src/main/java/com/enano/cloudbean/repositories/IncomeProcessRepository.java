package com.enano.cloudbean.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enano.cloudbean.entities.IncomeProcess;

@Repository
public interface IncomeProcessRepository extends JpaRepository<IncomeProcess, Long>{
  public List<IncomeProcess> findByProcessId(Long processId);
}
