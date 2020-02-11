package com.enano.cloudbean.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.enano.cloudbean.entities.CommodityStock;

@Repository
public interface CommodityStockRepository extends JpaRepository<CommodityStock, Long>, CommodityStockRepositoryCustom{
  
  public CommodityStock findByIncomeId(Long incomeId);
  
  public List<CommodityStock> findByProcessId(Long processId);
  
  public Page<CommodityStock> findByProcessId(Pageable page, Long processId);
  
  public CommodityStock findByCommodityId(Long commodityId);
  
  public List<CommodityStock> findByProcessIdAndOutcomeIdIsNotNull(Long processId);
  
}
