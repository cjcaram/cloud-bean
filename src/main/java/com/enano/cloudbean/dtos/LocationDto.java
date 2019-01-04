package com.enano.cloudbean.dtos;


public class LocationDto extends BaseLocationDto{
  private String city;
  private String province;
  private String address;
  private String country;
  private String postalCode;
  private String obs;
  
  public LocationDto() {
  }
  
  public LocationDto(Integer id, String name, String city, String province, 
      String address, String country, String postalCode, String obs) {
    super(id, name);
    this.city = city;
    this.province = province;
    this.address = address;
    this.country = country;
    this.postalCode = postalCode;
    this.obs = obs;
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
