package com.enano.cloudbean.repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.enano.cloudbean.dtos.CommodityFilterDto;
import com.enano.cloudbean.entities.Income;

public class IncomeRepositoryImpl {

  Map<String, Object> paramValues;
  
  @PersistenceContext
  EntityManager entityManager;
  
  @SuppressWarnings("unchecked")
  public List<Income> findIncomesUsingFilters(CommodityFilterDto filters) {
    Query query = entityManager.createNativeQuery(buildQuery(filters), Income.class);
    for (Map.Entry<String, Object> entry : paramValues.entrySet()) {
      String key = entry.getKey();
      Object value = entry.getValue();
      query.setParameter(key, value);
    }
    return query.getResultList();
  }
  
  private String buildQuery(CommodityFilterDto filters) {
    paramValues = new HashMap<>();
    String query = "SELECT e.* FROM entrada as e "
        + "JOIN analisis a on e.analisis_id = a.id "
        + "JOIN mercaderia_entrada me on e.id = me.entrada_id  "
        + "JOIN mercaderia m on m.id = me.mercaderia_id "
        + "WHERE 1=1 ";
    if (filters.getGmgMin() != null) {
      query += " AND a.gramaje > :gramajeMin";
      paramValues.put("gramajeMin", filters.getGmgMin());
    }
    if (filters.getGmgMax() != null) {
      query += " AND a.gramaje < :gramajeMax";
      paramValues.put("gramajeMax", filters.getGmgMax());
    }
    if (filters.getOwnerId() != null) {
      query += " AND e.titular_CP = :titularCP";
      paramValues.put("titularCP", filters.getOwnerId());
    }
    if ((filters.getNumCP() != null) && (filters.getNumCP().length() > 0)) {
      query += " AND e.carta_de_porte LIKE concat(concat('%', :cpNum), '%')";
      paramValues.put("cpNum", filters.getNumCP());
    }
    if (filters.getGrainTypeId() != null) {
      query += " AND m.grano_especie_id = :grainType";
      paramValues.put("grainType", filters.getGrainTypeId());
    }
    if (filters.getOriginId() != null) {
      query += " AND e.procedencia = :originId";
      paramValues.put("originId", filters.getOriginId());
    }
    if (filters.getHarvesting() != null) {
      query += " AND m.cosecha = :cosecha";
      paramValues.put("cosecha", filters.getHarvesting());
    }
    query += " ORDER BY e.id desc";
    return query;
    
  }
}
