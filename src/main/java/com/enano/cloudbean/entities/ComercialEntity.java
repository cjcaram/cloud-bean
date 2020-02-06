package com.enano.cloudbean.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="entidad_comercial")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ComercialEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name="nombre")
  private String name;
  @Column(name="cuit")
  private String cuit;
  @ManyToOne
  @JoinColumn(name = "ubicacion")
  private Location location;
  @Column(name="telefono")
  private String phone;
  @Column(name="mail")
  private String mail;
  @Column(name="observaciones")
  private String obs;
  @OneToOne
  @JoinColumn(name = "responsible_type_id")
  private ResponsibleType responsibleType;
  
  public ComercialEntity() {
    
  }
  
  public ComercialEntity(Long id, String name, String cuit, Location location,
      String phone, String mail, String obs, ResponsibleType responsibleType) {
    this.id = id;
    this.name = name;
    this.cuit = cuit;
    this.location = location;
    this.phone = phone;
    this.mail = mail;
    this.obs = obs;
    this.responsibleType = responsibleType;
  }

  public Long getId() {
    return (id != null && id > 0) ? id : null;
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

  public String getCuit() {
    return cuit;
  }

  public void setCuit(String cuit) {
    this.cuit = cuit;
  }

  public Location getLocation() {
    return location;
  }

  public void setLocation(Location location) {
    this.location = location;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getMail() {
    return mail;
  }

  public void setMail(String mail) {
    this.mail = mail;
  }

  public String getObs() {
    return obs;
  }

  public void setObs(String obs) {
    this.obs = obs;
  }

  public ResponsibleType getResponsibleType() {
    return responsibleType;
  }

  public void setResponsibleType(ResponsibleType responsibleType) {
    this.responsibleType = responsibleType;
  }

  @Override
  public String toString() {
    return "ComercialEntity [id=" + id + ", name=" + name + ", cuit=" + cuit + ", location="
        + location + ", phone=" + phone + ", mail=" + mail + ", obs=" + obs + ", responsibleType="
        + responsibleType + "]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((cuit == null) ? 0 : cuit.hashCode());
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result = prime * result + ((location == null) ? 0 : location.hashCode());
    result = prime * result + ((mail == null) ? 0 : mail.hashCode());
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    result = prime * result + ((obs == null) ? 0 : obs.hashCode());
    result = prime * result + ((phone == null) ? 0 : phone.hashCode());
    result = prime * result + ((responsibleType == null) ? 0 : responsibleType.hashCode());
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
    ComercialEntity other = (ComercialEntity) obj;
    if (cuit == null) {
      if (other.cuit != null)
        return false;
    } else if (!cuit.equals(other.cuit))
      return false;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    if (location == null) {
      if (other.location != null)
        return false;
    } else if (!location.equals(other.location))
      return false;
    if (mail == null) {
      if (other.mail != null)
        return false;
    } else if (!mail.equals(other.mail))
      return false;
    if (name == null) {
      if (other.name != null)
        return false;
    } else if (!name.equals(other.name))
      return false;
    if (obs == null) {
      if (other.obs != null)
        return false;
    } else if (!obs.equals(other.obs))
      return false;
    if (phone == null) {
      if (other.phone != null)
        return false;
    } else if (!phone.equals(other.phone))
      return false;
    if (responsibleType == null) {
      if (other.responsibleType != null)
        return false;
    } else if (!responsibleType.equals(other.responsibleType))
      return false;
    return true;
  }
  
}
