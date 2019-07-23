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
  
}
