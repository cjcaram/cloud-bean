package com.enano.cloudbean.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="origen_destino")
public class Location{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
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
  @OneToMany(mappedBy = "land", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
  //@JsonBackReference
  private List<LandBatch> batches = new ArrayList<>();
  
  public Location(){
  }

  public Location(Long id, String name, String city, String province, 
      String address, String country, String postalCode, String obs,
      List<LandBatch> batches) {
    this.id = id;
    this.name = name;
    this.city = city;
    this.province = province;
    this.address = address;
    this.country = country;
    this.postalCode = postalCode;
    this.obs = obs;
    this.batches = batches;
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

  public List<LandBatch> getBatches() {
    return batches;
  }

  public void setBatches(List<LandBatch> batches) {
    this.batches = batches;
  }

  @Override
  public String toString() {
    return "Location [id=" + id + ", name=" + name + ", city=" + city + ", province=" + province
        + ", address=" + address + ", country=" + country + ", postalCode=" + postalCode + ", obs="
        + obs + ", batches=" + batches + "]";
  }
  
}
