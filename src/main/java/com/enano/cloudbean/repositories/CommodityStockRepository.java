package com.enano.cloudbean.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enano.cloudbean.entities.CommodityStock;

@Repository
public interface CommodityStockRepository extends JpaRepository<CommodityStock, Long>{
  
  public CommodityStock findByIncomeId(Long incomeId);

}
