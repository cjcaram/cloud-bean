package com.enano.cloudbean.repositories;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.jpa.TypedParameterValue;
import org.hibernate.type.ArrayType;
import org.hibernate.type.CustomType;
import org.hibernate.type.Type;

import com.enano.cloudbean.dtos.CommodityFilterDto;
import com.enano.cloudbean.entities.Income;

public class IncomeRepositoryImpl {

  List<Object> paramValues;
  
  @PersistenceContext
  EntityManager entityManager;
  
  @SuppressWarnings("unchecked")
  public List<Income> findIncomesUsingFilters(CommodityFilterDto filters) {
    Query query = entityManager.createNativeQuery(buildQuery(filters), Income.class);
    for (int i = 0; i < paramValues.size(); i++) {
      query.setParameter(i+1, paramValues.get(i));
    }
    return query.getResultList();
  }
  
  private String buildQuery(CommodityFilterDto filters) {
    paramValues = new ArrayList<>();
    String query = "SELECT e.* FROM entrada as e JOIN analisis a on e.analisis_id = a.id WHERE 1=1";
    if (filters.getGmgMin() != null) {
      query += " AND a.gramaje > ?";
      paramValues.add(filters.getGmgMin());
    }
    if (filters.getGmgMax() != null) {
      query += " AND a.gramaje < ?";
      paramValues.add(filters.getGmgMax());
    }
    if (filters.getOwnerId() != null) {
      query += " AND e.titular_CP = ?";
      paramValues.add(filters.getOwnerId());
    }
    if ((filters.getNumCP() != null) && (filters.getNumCP().length() > 0)) {
      query += " AND e.carta_de_porte LIKE CONCAT('%', ?, '%')";
      paramValues.add(filters.getNumCP());
    }
    if (filters.getGrainTypeId() != null) {
      query += " AND e.grano_especie_id = ?";
      paramValues.add(filters.getGrainTypeId());
    }
    if (filters.getOriginId() != null) {
      query += " AND e.procedencia = ?";
      paramValues.add(filters.getOriginId());
    }
    if (filters.getIncomeId().length > 0) {
      query += " AND e.id in (?)";
      paramValues.add(filters.getIncomeIdAsString());
    }
    query += " ORDER BY fecha_descarga desc";
    return query;
    
  }
}
