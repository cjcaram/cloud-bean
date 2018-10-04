package com.enano.cloudbean.dtos;


public class LocationDto {
  private Integer id;
  private boolean isOrigin;
  private boolean isDestiny;
  private String name;
  private String city;
  private String province;
  private String address;
  private String country;
  private String postalCode;
  private String obs;
  
  public LocationDto() {
  }
  
  public LocationDto(Integer id, boolean isOrigin, boolean isDestiny, String name, String city,
      String province, String address, String country, String postalCode, String obs) {
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

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
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
