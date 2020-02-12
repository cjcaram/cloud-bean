package com.enano.cloudbean.dtos;

public class CommodityFilterDto {
  
  private Long originId;
  private Long ownerId;
  private String numCP;
  private Long grainTypeId;
  private Integer gmgMin;
  private Integer gmgMax;
  private String harvesting;
  private Long qualityTypeId;
  private Long[] incomeId;
  private Long[] outcomeId;
  private Long[] processId;
  private String locationInPlant;
  
  public CommodityFilterDto () {}
  
  public CommodityFilterDto(Long originId, Long ownerId, String numCP, 
      Long grainTypeId, Integer gmgMin, Integer gmgMax, String harvesting, Long qualityTypeId,
      Integer incomeNumber, Long[] incomeId, Long[] outcomeId, Long[] processId, String locationInPlant) {
    this.originId = originId;
    this.ownerId = ownerId;
    this.numCP = numCP;
    this.grainTypeId = grainTypeId;
    this.gmgMin = gmgMin;
    this.gmgMax = gmgMax;
    this.harvesting = harvesting;
    this.qualityTypeId = qualityTypeId;
    this.incomeId = incomeId;
    this.outcomeId = outcomeId;
    this.processId = processId;
    this.locationInPlant = locationInPlant;
  }

  public Long getOriginId() {
    return originId;
  }

  public void setOriginId(Long originId) {
    this.originId = originId;
  }

  public Long getOwnerId() {
    return ownerId;
  }

  public void setOwnerId(Long ownerId) {
    this.ownerId = ownerId;
  }

  public String getNumCP() {
    return numCP;
  }

  public void setNumCP(String numCP) {
    this.numCP = numCP;
  }

  public Long getGrainTypeId() {
    return grainTypeId;
  }

  public void setGrainTypeId(Long grainTypeId) {
    this.grainTypeId = grainTypeId;
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

  public String getHarvesting() {
    return harvesting;
  }

  public void setHarvesting(String harvesting) {
    this.harvesting = harvesting;
  }

  public Long getQualityTypeId() {
    return qualityTypeId;
  }

  public void setQualityTypeId(Long qualityTypeId) {
    this.qualityTypeId = qualityTypeId;
  }

  public String getLocationInPlant() {
    return locationInPlant;
  }

  public void setLocationInPlant(String locationInPlant) {
    this.locationInPlant = locationInPlant;
  }

  public Long[] getIncomeId() {
    return incomeId;
  }
  
  public void setIncomeId(Long[] incomeId) {
    this.incomeId = incomeId;
  }

  public Long[] getOutcomeId() {
    return outcomeId;
  }

  public void setOutcomeId(Long[] outcomeId) {
    this.outcomeId = outcomeId;
  }

  public Long[] getProcessId() {
    return processId;
  }

  public void setProcessId(Long[] processId) {
    this.processId = processId;
  }

  public Object getIncomeIdAsString() {
    String result = "";
    for (int i = 0; i < this.incomeId.length; i++) {
      if (i > 0) {
        result += ",";
      }
      result += this.incomeId[i].toString();
    }
    return result;
  }

  
}
