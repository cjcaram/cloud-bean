package com.enano.cloudbean.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "AGROQUIMICO_TIPO", uniqueConstraints = {
@UniqueConstraint(columnNames = "NOMBRE")})
public class AgrochemicalType {

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id;
  @Column (name = "NOMBRE")
  private String name;
  @Column (name = "DESCRIPCION")
  private String descripcion;
  
  public AgrochemicalType(){}
  
  public AgrochemicalType(Long id, String name, String descripcion) {
    super();
    this.id = id;
    this.name = name;
    this.descripcion = descripcion;
  }
  
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

}
