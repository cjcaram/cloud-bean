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

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((address == null) ? 0 : address.hashCode());
    result = prime * result + ((batches == null) ? 0 : batches.hashCode());
    result = prime * result + ((city == null) ? 0 : city.hashCode());
    result = prime * result + ((country == null) ? 0 : country.hashCode());
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    result = prime * result + ((obs == null) ? 0 : obs.hashCode());
    result = prime * result + ((postalCode == null) ? 0 : postalCode.hashCode());
    result = prime * result + ((province == null) ? 0 : province.hashCode());
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
    Location other = (Location) obj;
    if (address == null) {
      if (other.address != null)
        return false;
    } else if (!address.equals(other.address))
      return false;
    if (batches == null) {
      if (other.batches != null)
        return false;
    } else if (!batches.equals(other.batches))
      return false;
    if (city == null) {
      if (other.city != null)
        return false;
    } else if (!city.equals(other.city))
      return false;
    if (country == null) {
      if (other.country != null)
        return false;
    } else if (!country.equals(other.country))
      return false;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
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
    if (postalCode == null) {
      if (other.postalCode != null)
        return false;
    } else if (!postalCode.equals(other.postalCode))
      return false;
    if (province == null) {
      if (other.province != null)
        return false;
    } else if (!province.equals(other.province))
      return false;
    return true;
  }
  
}
