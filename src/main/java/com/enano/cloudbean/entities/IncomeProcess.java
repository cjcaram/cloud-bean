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

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result = prime * result + ((incomeId == null) ? 0 : incomeId.hashCode());
    result = prime * result + ((processId == null) ? 0 : processId.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    IncomeProcess other = (IncomeProcess) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    if (incomeId == null) {
      if (other.incomeId != null)
        return false;
    } else if (!incomeId.equals(other.incomeId))
      return false;
    if (processId == null) {
      if (other.processId != null)
        return false;
    } else if (!processId.equals(other.processId))
      return false;
    return true;
  }
}
