package com.enano.cloudbean.repositories;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.enano.cloudbean.dtos.IncomeFiltersDto;
import com.enano.cloudbean.entities.Income;

public class IncomeRepositoryImpl implements IncomeRepositoryCustom {

  List<Object> paramValues;
  
  @PersistenceContext
  EntityManager entityManager;
  
  @SuppressWarnings("unchecked")
  @Override
  public List<Income> findIncomesUsingFilters(IncomeFiltersDto filters) {
    Query query = entityManager.createNativeQuery(buildQuery(filters), Income.class);
    for (int i = 0; i < paramValues.size(); i++) {
      query.setParameter(i+1, paramValues.get(i));
    }
    return query.getResultList();
  }
  
  private String buildQuery(IncomeFiltersDto filters) {
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
    if (filters.getCpOwner() != null) {
      query += " AND e.titular_CP = ?";
      paramValues.add(filters.getCpOwner());
    }
    if ((filters.getNumCP() != null) && (filters.getNumCP().length() > 0)) {
      query += " AND e.carta_de_porte LIKE CONCAT('%', ?, '%')";
      paramValues.add(filters.getNumCP());
    }
    if (filters.getGrainType() != null) {
      query += " AND e.grano_especie_id = ?";
      paramValues.add(filters.getGrainType());
    }
    if (filters.getOrigin() != null) {
      query += " AND e.procedencia = ?";
      paramValues.add(filters.getOrigin());
    }
    if (filters.getReceiver() != null) {
      query += " AND e.destinatario = ?";
      paramValues.add(filters.getReceiver());
    }
    query += " ORDER BY fecha_descarga desc";
    return query;
    
  }
}
