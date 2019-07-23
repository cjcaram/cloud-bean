package com.enano.cloudbean.dtos;

public class MeasurmentUnitsDto {
  private Long id;
  private String name;
  private String symbol;
  
  public MeasurmentUnitsDto(String name, String symbol) {
    this.name = name;
    this.symbol = symbol;
  }
  
  public MeasurmentUnitsDto(Long id, String name, String symbol) {
    this.id = id;
    this.name = name;
    this.symbol = symbol;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSymbol() {
    return symbol;
  }

  public void setSymbol(String symbol) {
    this.symbol = symbol;
  }

  public Long getId() {
    return (id != null && id > 0) ? id : null;
  }

  public void setId(Long id) {
    this.id = id;
  }
}
