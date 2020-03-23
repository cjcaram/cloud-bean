package com.enano.cloudbean.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.enano.cloudbean.entities.Income;

@Repository
public interface IncomeRepository extends JpaRepository<Income, Long>, IncomeRepositoryCustom {

  @Query(value = "SELECT e.* FROM entrada e " + 
                 " JOIN mercaderia_entrada me on e.id = me.entrada_id " + 
                 " WHERE me.mercaderia_id IN :commodityIds", 
      nativeQuery = true)
  List<Income> findByCommodityIds(@Param(value = "commodityIds") List<Long> commodityIdList);
  
  
  /*  
  @Query("FROM Income i WHERE i.analysis IS NOT NULL AND i.id NOT IN (SELECT incomeId FROM IncomeProcess)")
  List<IncomeDto> listNotProcessedIncomes();
  
  
  @Query("SELECT i FROM Income i JOIN IncomeProcess ip ON i.id = ip.incomeId WHERE ip.processId = :proccesId")
  List<Income> getIncomesByProcessId(@Param("proccesId") Long processId);
  */
}