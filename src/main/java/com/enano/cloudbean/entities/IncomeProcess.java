package com.enano.cloudbean.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "entrada_proceso")
public class IncomeProcess {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  @Column(name="entrada_id")
  private Long incomeId;
  
  @Column(name="proceso_id")
  private Long processId;
  
  public IncomeProcess() {}

  public IncomeProcess(Long id, Long incomeId, Long processId) {
    this.id = id;
    this.incomeId = incomeId;
    this.processId = processId;
  }

  public Long getId() {
    return (id != null && id > 0) ? id : null;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getIncomeId() {
    return incomeId;
  }

  public void setIncomeId(Long incomeId) {
    this.incomeId = incomeId;
  }

  public Long getProcessId() {
    return processId;
  }

  public void setProcessId(Long processId) {
    this.processId = processId;
  }
}
