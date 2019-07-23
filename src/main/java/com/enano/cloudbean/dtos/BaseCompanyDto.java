package com.enano.cloudbean.dtos;

public class BaseCompanyDto {
  private Long id;
  private String name;
  
  public BaseCompanyDto() {
  }
  
  public BaseCompanyDto(Long id, String name) {
    this.id = id;
    this.name = name;
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

}
