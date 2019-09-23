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

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((detail == null) ? 0 : detail.hashCode());
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result = prime * result + ((qualityType == null) ? 0 : qualityType.hashCode());
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
    QualityType other = (QualityType) obj;
    if (detail == null) {
      if (other.detail != null)
        return false;
    } else if (!detail.equals(other.detail))
      return false;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    if (qualityType == null) {
      if (other.qualityType != null)
        return false;
    } else if (!qualityType.equals(other.qualityType))
      return false;
    return true;
  }
  
  @Override
  public String toString() {
    return "QualityType [id=" + id + ", qualityType=" + qualityType + ", detail=" + detail + "]";
  }
}
