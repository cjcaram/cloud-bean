package com.enano.cloudbean.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "post")
public class EmpaqueTipo {

  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name = "tipo_empaque")
  private String tipoEmpaque;
  
  EmpaqueTipo(){
    
  }

  public EmpaqueTipo(String tipoEmpaque) {
    this.tipoEmpaque = tipoEmpaque;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTipoEmpaque() {
    return tipoEmpaque;
  }

  public void setTipoEmpaque(String tipoEmpaque) {
    this.tipoEmpaque = tipoEmpaque;
  }
  
  
}
