package com.enano.cloudbean.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "empaque_tipo")
public class PackagingType {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name = "tipo_empaque")
  private String packagingType;
  
  PackagingType(){
  }

  public PackagingType(Long id, String packagingType) {
    this.id = id;
    this.packagingType = packagingType;
  }
  
  public PackagingType(String packagingType) {
    this.packagingType = packagingType;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getPackagingType() {
    return packagingType;
  }

  public void setPackagingType(String packagingType) {
    this.packagingType = packagingType;
  }

  @Override
  public String toString() {
    return "PackagingType [id=" + id + ", packagingType=" + packagingType + "]";
  }
}
