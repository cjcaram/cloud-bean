package com.enano.cloudbean.repositories;

import java.util.ArrayList;
import java.util.Arrays;
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
      List<Long> ids = Arrays.asList(filters.getIncomeId());
      query += " AND cs.entrada_id IN " + getWhereClauseForList(ids.size());
      setPramValueForList(ids);
    }
    if (filters.getProcessId() != null) {
      List<Long> ids = Arrays.asList(filters.getProcessId());
      query += " AND cs.proceso_id IN " + getWhereClauseForList(ids.size());
      setPramValueForList(ids);
    }
    if (filters.getOutcomeId() != null) {
      List<Long> ids = Arrays.asList(filters.getOutcomeId());
      query += " AND cs.salida_id IN " + getWhereClauseForList(ids.size());
      setPramValueForList(ids);
    }
    
    query += " ORDER BY id desc";
    return query;
    
  }

  private void setPramValueForList(List<Long> ids) {
    for(int i = 0; i < ids.size(); i++) {
      paramValues.add(ids.get(i));
    }
  }

  private String getWhereClauseForList(int size) {
    String whereList = "(";
    for(int i = 0; i < size - 1; i++) {
      whereList += "?, ";
    }
    return whereList + "?) ";
  }
}
