package com.enano.cloudbean.dtos;

public class BaseLocationDto {
  private Integer id;
  private String name;
  
  BaseLocationDto() {
  }

  public BaseLocationDto(Integer id, String name) {
    this.id = id;
    this.name = name;
  }

  public Integer getId() {
    return (id != null && id > 0) ? id : null;
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
  
}
