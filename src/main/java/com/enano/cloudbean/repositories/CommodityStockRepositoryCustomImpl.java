package com.enano.cloudbean.repositories;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.enano.cloudbean.dtos.CommodityFilterDto;
import com.enano.cloudbean.entities.CommodityStock;

public class CommodityStockRepositoryCustomImpl implements CommodityStockRepositoryCustom{
  
  List<Object> paramValues;
  
  @PersistenceContext
  EntityManager entityManager;
  
  @SuppressWarnings("unchecked")
  public List<CommodityStock> findStockUsingFilters(CommodityFilterDto filters) {
    Query query = entityManager.createNativeQuery(buildQuery(filters), CommodityStock.class);
    for (int i = 0; i < paramValues.size(); i++) {
      query.setParameter(i+1, paramValues.get(i));
    }
    return query.getResultList();
  }
  
  private String buildQuery(CommodityFilterDto filters) {
    paramValues = new ArrayList<>();
    String query = "SELECT cs.* FROM mercaderia_stock as cs WHERE 1=1";
    if (filters.getGmgMin() != null) {
      query += " AND cs.gramaje > ?";
      paramValues.add(filters.getGmgMin());
    }
    if (filters.getGmgMax() != null) {
      query += " AND cs.gramaje < ?";
      paramValues.add(filters.getGmgMax());
    }
    if (filters.getOwnerId() != null) {
      query += " AND cs.propietario = ?";
      paramValues.add(filters.getOwnerId());
    }
    if (filters.getGrainTypeId() != null) {
      query += " AND cs.grano_especie_id = ?";
      paramValues.add(filters.getGrainTypeId());
    }
    if (filters.getQualityTypeId() != null) {
      query += " AND cs.tipo_calidad_id = ?";
      paramValues.add(filters.getQualityTypeId());
    }
    if (filters.getLocationInPlant() != null) {
      query += " AND cs.ubicacion = ?";
      paramValues.add(filters.getLocationInPlant());
    }
    if (filters.getHarvesting() != null) {
      query += " AND cs.cosecha = ?";
      paramValues.add(filters.getHarvesting());
    }
    if (filters.getIncomeId() != null) {
      query += " AND cs.entrada_id = ?";
      paramValues.add(filters.getIncomeId());
    }
    if (filters.getProcessId() != null) {
      query += " AND cs.proceso_id = ?";
      paramValues.add(filters.getProcessId());
    }
    if (filters.getOutcomeId() != null) {
      query += " AND cs.salida_id = ?";
      paramValues.add(filters.getOutcomeId());
    }
    
    query += " ORDER BY id desc";
    return query;
    
  }
}
