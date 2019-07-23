package com.enano.cloudbean.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "tipo_calidad")
public class QualityType {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name="tipo_calidad")
  private String qualityType;
  @Column(name="detalle")
  private String detail;
  
  public QualityType(String qualityType) {
    this.qualityType = qualityType;
  }
  
  public QualityType() {
  }
  
  public QualityType(Long id, String qualityType, String detail) {
    this.id = id;
    this.qualityType = qualityType;
    this.detail = detail;
  }

  public Long getId() {
    return (id != null && id > 0) ? id : null;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getQualityType() {
    return qualityType;
  }

  public void setQualityType(String qualityType) {
    this.qualityType = qualityType;
  }

  public String getDetail() {
    return detail;
  }

  public void setDetail(String detail) {
    this.detail = detail;
  }

}
