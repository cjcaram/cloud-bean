package com.enano.cloudbean.dtos;

public class CompanyDto {
  private Integer id;
  private String name;
  private String cuit;
  private long locationId;
  private String phone;
  private String mail;
  private String obs;

  public CompanyDto(){
  }

  public CompanyDto(Integer id, String name, String cuit, long locationId, String phone, String mail,
      String obs) {
    this.id = id;
    this.name = name;
    this.cuit = cuit;
    this.locationId = locationId;
    this.phone = phone;
    this.mail = mail;
    this.obs = obs;
  }

  public Integer getId() {
      return id;
  }

  public void setId(Integer id) {
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

  public long getLocationId() {
      return locationId;
  }

  public void setLocationId(long locationId) {
      this.locationId = locationId;
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
}