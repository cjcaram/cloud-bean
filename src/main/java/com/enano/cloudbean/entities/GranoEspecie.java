package com.enano.cloudbean.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="grano_especie")
public class GranoEspecie {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name="nombre")
  private String nombre;
  @Column(name="variedad")
  private String variedad;
  @Column(name="descripcion")
  private String descripcion;
  
  GranoEspecie(){
    
  }

  public GranoEspecie(Long id, String nombre, String variedad, String descripcion) {
    this.id = id;
    this.nombre = nombre;
    this.variedad = variedad;
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

  public String getVariedad() {
    return variedad;
  }

  public void setVariedad(String variedad) {
    this.variedad = variedad;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }
  
  
  
  

}
