package com.enano.cloudbean.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="origen_destino")
public class Location {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name="origen")
  private boolean isOrigin;
  @Column(name="destino")
  private boolean isDestiny;
  @Column(name="establecimiento")
  private String name;
  @Column(name="localidad")
  private String city;
  @Column(name="provincia")
  private String province;
  @Column(name="direccion")
  private String address;
  @Column(name="pais")
  private String country;
  @Column(name="codigo_postal")
  private String postalCode;
  @Column(name="observaciones")
  private String obs;
  
  public Location(){
  }

  public Location(Long id, boolean isOrigin, boolean isDestiny, String name,
      String city, String province, String address, String country, String postalCode,
      String obs) {
    this.id = id;
    this.isOrigin = isOrigin;
    this.isDestiny = isDestiny;
    this.name = name;
    this.city = city;
    this.province = province;
    this.address = address;
    this.country = country;
    this.postalCode = postalCode;
    this.obs = obs;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public boolean isOrigin() {
    return isOrigin;
  }

  public void setOrigin(boolean isOrigin) {
    this.isOrigin = isOrigin;
  }

  public boolean isDestiny() {
    return isDestiny;
  }

  public void setDestiny(boolean isDestiny) {
    this.isDestiny = isDestiny;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getProvince() {
    return province;
  }

  public void setProvince(String province) {
    this.province = province;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getPostalCode() {
    return postalCode;
  }

  public void setPostalCode(String postalCode) {
    this.postalCode = postalCode;
  }

  public String getObs() {
    return obs;
  }

  public void setObs(String obs) {
    this.obs = obs;
  }
  
}
