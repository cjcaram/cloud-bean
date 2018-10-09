package com.enano.cloudbean.dtos;

public class CompanyDto {
  private Integer id;
  private String name;
  private String cuit;
  private Integer locationId;
  private Integer responsibleType;
  private String phone;
  private String mail;
  private String obs;

  public CompanyDto(){
  }

  public CompanyDto(Integer id, String name, String cuit, Integer locationId, String phone, 
      Integer responsibleType, String mail, String obs) {
    this.id = id;
    this.name = name;
    this.cuit = cuit;
    this.locationId = locationId;
    this.responsibleType = responsibleType;
    this.phone = phone;
    this.mail = mail;
    this.obs = obs;
  }
  
  public CompanyDto(Integer id) {
    this.id = id;
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

  public Integer getLocationId() {
      return locationId;
  }

  public void setLocationId(Integer locationId) {
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

  public Integer getResponsibleType() {
    return responsibleType;
  }

  public void setResponsibleType(Integer responsibleType) {
    this.responsibleType = responsibleType;
  }
}