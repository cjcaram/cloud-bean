package com.enano.cloudbean.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "APLICACION_TIPO")
public class AgrochemicalAppType {
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id;
  @Column (name = "NOMBRE")
  private String name;
  @Column (name = "PRECIO_HA")
  private double pricePerHa;
  
  public AgrochemicalAppType() {
  }
  
  public AgrochemicalAppType(Long id, String name, double pricePerHa) {
    this.id = id;
    this.name = name;
    this.pricePerHa = pricePerHa;
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

  public double getPricePerHa() {
    return pricePerHa;
  }

  public void setPricePerHa(double pricePerHa) {
    this.pricePerHa = pricePerHa;
  }
  
  
}
