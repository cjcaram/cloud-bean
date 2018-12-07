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
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Long id;
  @Column (name = "NOMBRE")
  private String nombre;
  @Column (name = "DESCRIPCION")
  private String descripcion;
  
  public AgrochemicalType(){}
  
  public AgrochemicalType(Long id, String nombre, String descripcion) {
    super();
    this.id = id;
    this.nombre = nombre;
    this.descripcion = descripcion;
  }
  
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

}
