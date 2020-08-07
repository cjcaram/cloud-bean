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
  private int incomeNo;
  private int outcomeNo;
  private int processNo;
  private PaginationInfo paginationInfo;
  
  
  public CommodityFilterDto () {}
  
  public CommodityFilterDto(Long originId, Long ownerId, String numCP, Long grainTypeId,
      Integer gmgMin, Integer gmgMax, String harvesting, Long qualityTypeId, Long[] incomeId,
      Long[] outcomeId, Long[] processId, String locationInPlant, int incomeNo, int outcomeNo,
      int processNo, PaginationInfo paginationInfo) {
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
    this.incomeNo = incomeNo;
    this.outcomeNo = outcomeNo;
    this.processNo = processNo;
    this.paginationInfo = paginationInfo;
  }

  public Long getOriginId() {
    return (originId != null && originId > 0) ? originId : null;
  }

  public void setOriginId(Long originId) {
    this.originId = originId;
  }

  public Long getOwnerId() {
    return (ownerId != null && ownerId > 0) ? ownerId : null;
  }

  public void setOwnerId(Long ownerId) {
    this.ownerId = ownerId;
  }

  public String getNumCP() {
    return (numCP != null && numCP.length() > 0) ? numCP : null;
  }

  public void setNumCP(String numCP) {
    this.numCP = numCP;
  }

  public Long getGrainTypeId() {
    return (grainTypeId != null && grainTypeId > 0) ? grainTypeId : null;
  }

  public void setGrainTypeId(Long grainTypeId) {
    this.grainTypeId = grainTypeId;
  }

  public Integer getGmgMin() {
    return (gmgMin != null && gmgMin > 0) ? gmgMin : null;
  }

  public void setGmgMin(Integer gmgMin) {
    this.gmgMin = gmgMin;
  }

  public Integer getGmgMax() {
    return (gmgMax != null && gmgMax > 0) ? gmgMax : null;
  }

  public void setGmgMax(Integer gmgMax) {
    this.gmgMax = gmgMax;
  }

  public String getHarvesting() {
    return (harvesting != null && harvesting.length() > 0) ? harvesting : null;
  }

  public void setHarvesting(String harvesting) {
    this.harvesting = harvesting;
  }

  public Long getQualityTypeId() {
    return (qualityTypeId != null && qualityTypeId > 0) ? qualityTypeId : null;
  }

  public void setQualityTypeId(Long qualityTypeId) {
    this.qualityTypeId = qualityTypeId;
  }

  public String getLocationInPlant() {
    return (locationInPlant != null && locationInPlant.length() > 0) ? locationInPlant : null;
  }

  public void setLocationInPlant(String locationInPlant) {
    this.locationInPlant = locationInPlant;
  }

  public Long[] getIncomeId() {
    return (incomeId != null && incomeId.length > 0) ? incomeId : null;
  }
  
  public void setIncomeId(Long[] incomeId) {
    this.incomeId = incomeId;
  }

  public Long[] getOutcomeId() {
    return (outcomeId != null && outcomeId.length > 0) ? outcomeId : null;
  }

  public void setOutcomeId(Long[] outcomeId) {
    this.outcomeId = outcomeId;
  }

  public Long[] getProcessId() {
    return (processId != null && processId.length > 0) ? processId : null;
  }

  public void setProcessId(Long[] processId) {
    this.processId = processId;
  }

  public int getIncomeNo() {
    return incomeNo;
  }

  public void setIncomeNo(int incomeNo) {
    this.incomeNo = incomeNo;
  }

  public int getOutcomeNo() {
    return outcomeNo;
  }

  public void setOutcomeNo(int outcomeNo) {
    this.outcomeNo = outcomeNo;
  }

  public int getProcessNo() {
    return processNo;
  }

  public void setProcessNo(int processNo) {
    this.processNo = processNo;
  }

  public PaginationInfo getPaginationInfo() {
    return paginationInfo;
  }

  public void setPaginationInfo(PaginationInfo paginationInfo) {
    this.paginationInfo = paginationInfo;
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
