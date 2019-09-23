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
    return (id != null && id > 0) ? id : null;
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

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result = prime * result + ((packagingType == null) ? 0 : packagingType.hashCode());
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
    PackagingType other = (PackagingType) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    if (packagingType == null) {
      if (other.packagingType != null)
        return false;
    } else if (!packagingType.equals(other.packagingType))
      return false;
    return true;
  }
}
