package com.enano.cloudbean.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enano.cloudbean.entities.CommodityStock;

@Repository
public interface CommodityStockRepository extends JpaRepository<CommodityStock, Long>{
  
  public CommodityStock findByIncomeId(Long incomeId);
  
  public List<CommodityStock> findByProcessId(Long processId);
  
  public CommodityStock findByCommodityId(Long commodityId);
  
  public List<CommodityStock> findByProcessIdAndOutcomeIdIsNotNull(Long processId);
  
}
