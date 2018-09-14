package com.enano.cloudbean.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="entidad_comercial")
public class EnitdadComercial {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name="nombre")
  private String nombre;
  @Column(name="cuit")
  private String cuit;
  @OneToOne
  @JoinColumn(name = "ubicacion")
  private OrigenDestino ubicacion;
  @Column(name="telefono")
  private String telefono;
  @Column(name="mail")
  private String mail;
  @Column(name="observaciones")
  private String obs;
  
  public EnitdadComercial() {
    
  }
  
  public EnitdadComercial(Long id, String nombre, String cuit, OrigenDestino ubicacion,
      String telefono, String mail, String obs) {
    this.id = id;
    this.nombre = nombre;
    this.cuit = cuit;
    this.ubicacion = ubicacion;
    this.telefono = telefono;
    this.mail = mail;
    this.obs = obs;
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

  public String getCuit() {
    return cuit;
  }

  public void setCuit(String cuit) {
    this.cuit = cuit;
  }

  public OrigenDestino getUbicacion() {
    return ubicacion;
  }

  public void setUbicacion(OrigenDestino ubicacion) {
    this.ubicacion = ubicacion;
  }

  public String getTelefono() {
    return telefono;
  }

  public void setTelefono(String telefono) {
    this.telefono = telefono;
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
  
}
