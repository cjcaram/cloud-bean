package com.enano.cloudbean.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="origen_destino")
public class OrigenDestino {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name="origen")
  private boolean isOrigen;
  @Column(name="destino")
  private boolean isDestino;
  @Column(name="establecimiento")
  private String establecimiento;
  @Column(name="localidad")
  private String localidad;
  @Column(name="provincia")
  private String provincia;
  @Column(name="direccion")
  private String direccion;
  @Column(name="pais")
  private String pais;
  @Column(name="codigo_postal")
  private String codigoPostal;
  @Column(name="observaciones")
  private String obs;
  
  OrigenDestino(){
  }

  public OrigenDestino(Long id, boolean isOrigen, boolean isDestino, String establecimiento,
      String localidad, String provincia, String direccion, String pais, String codigoPostal,
      String obs) {
    this.id = id;
    this.isOrigen = isOrigen;
    this.isDestino = isDestino;
    this.establecimiento = establecimiento;
    this.localidad = localidad;
    this.provincia = provincia;
    this.direccion = direccion;
    this.pais = pais;
    this.codigoPostal = codigoPostal;
    this.obs = obs;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public boolean isOrigen() {
    return isOrigen;
  }

  public void setOrigen(boolean isOrigen) {
    this.isOrigen = isOrigen;
  }

  public boolean isDestino() {
    return isDestino;
  }

  public void setDestino(boolean isDestino) {
    this.isDestino = isDestino;
  }

  public String getEstablecimiento() {
    return establecimiento;
  }

  public void setEstablecimiento(String establecimiento) {
    this.establecimiento = establecimiento;
  }

  public String getLocalidad() {
    return localidad;
  }

  public void setLocalidad(String localidad) {
    this.localidad = localidad;
  }

  public String getProvincia() {
    return provincia;
  }

  public void setProvincia(String provincia) {
    this.provincia = provincia;
  }

  public String getDireccion() {
    return direccion;
  }

  public void setDireccion(String direccion) {
    this.direccion = direccion;
  }

  public String getPais() {
    return pais;
  }

  public void setPais(String pais) {
    this.pais = pais;
  }

  public String getCodigoPostal() {
    return codigoPostal;
  }

  public void setCodigoPostal(String codigoPostal) {
    this.codigoPostal = codigoPostal;
  }

  public String getObs() {
    return obs;
  }

  public void setObs(String obs) {
    this.obs = obs;
  }
  
}
