package com.enano.cloudbean.dtos;

public class IncomeFiltersDto {
  
  private Integer origin;
  private Integer cpOwner;
  private String numCP;
  private Integer receiver;
  private Integer grainType;
  private Integer gmgMin;
  private Integer gmgMax;
  
  public IncomeFiltersDto () {}

  public IncomeFiltersDto(Integer origin, Integer cpOwner, String numCP, Integer receiver,
      Integer grainType, Integer gmgMin, Integer gmgMax) {
    this.origin = origin;
    this.cpOwner = cpOwner;
    this.numCP = numCP;
    this.receiver = receiver;
    this.grainType = grainType;
    this.gmgMin = gmgMin;
    this.gmgMax = gmgMax;
  }

  public Integer getOrigin() {
    return origin;
  }

  public void setOrigin(Integer origin) {
    this.origin = origin;
  }

  public Integer getCpOwner() {
    return cpOwner;
  }

  public void setCpOwner(Integer cpOwner) {
    this.cpOwner = cpOwner;
  }

  public String getNumCP() {
    return numCP;
  }

  public void setNumCP(String numCP) {
    this.numCP = numCP;
  }

  public Integer getReceiver() {
    return receiver;
  }

  public void setReceiver(Integer receiver) {
    this.receiver = receiver;
  }

  public Integer getGrainType() {
    return grainType;
  }

  public void setGrainType(Integer grainType) {
    this.grainType = grainType;
  }

  public Integer getGmgMin() {
    return gmgMin;
  }

  public void setGmgMin(Integer gmgMin) {
    this.gmgMin = gmgMin;
  }

  public Integer getGmgMax() {
    return gmgMax;
  }

  public void setGmgMax(Integer gmgMax) {
    this.gmgMax = gmgMax;
  }
}
