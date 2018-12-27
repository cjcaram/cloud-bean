package com.enano.cloudbean.dtos;

import com.enano.cloudbean.entities.ResponsibleType;

public class CompanyDto extends BaseCompanyDto{
  private String cuit;
  private Integer locationId;
  private ResponsibleType responsibleType;
  private String phone;
  private String mail;
  private String obs;

  public CompanyDto(){
  }

  public CompanyDto(Long id, String name, String cuit, Integer locationId, String phone, 
      ResponsibleType responsibleType, String mail, String obs) {
    super(id, name);
    this.cuit = cuit;
    this.locationId = locationId;
    this.responsibleType = responsibleType;
    this.phone = phone;
    this.mail = mail;
    this.obs = obs;
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

  public ResponsibleType getResponsibleType() {
    return responsibleType;
  }

  public void setResponsibleType(ResponsibleType responsibleType) {
    this.responsibleType = responsibleType;
  }
}