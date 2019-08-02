package com.enano.cloudbean.dtos;

import java.util.Date;
import java.util.List;

import com.enano.cloudbean.entities.Commodity;

public class ProcessDto {
  
  private Long id;
  private int processNumber;
  private String referenceName;
  private Date date;
  private String obs;
  private List<Commodity> processedCommodities;
  private List<BasicIncomeInfoDto> naturalCommodities;

  public ProcessDto () {}

  public ProcessDto(Long id, int processNumber, String referenceName, Date date, String obs,
      List<Commodity> processedCommodities, List<BasicIncomeInfoDto> naturalCommodities) {
    this.id = id;
    this.processNumber = processNumber;
    this.referenceName = referenceName;
    this.date = date;
    this.obs = obs;
    this.processedCommodities = processedCommodities;
    this.naturalCommodities = naturalCommodities;
  }

  public Long getId() {
    return (id != null && id > 0) ? id : null;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public int getProcessNumber() {
    return processNumber;
  }

  public void setProcessNumber(int processNumber) {
    this.processNumber = processNumber;
  }

  public String getReferenceName() {
    return referenceName;
  }

  public void setReferenceName(String referenceName) {
    this.referenceName = referenceName;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public String getObs() {
    return obs;
  }

  public void setObs(String obs) {
    this.obs = obs;
  }

  public List<Commodity> getProcessedCommodities() {
    return processedCommodities;
  }

  public void setProcessedCommodities(List<Commodity> processedCommodities) {
    this.processedCommodities = processedCommodities;
  }

  public List<BasicIncomeInfoDto> getNaturalCommodities() {
    return naturalCommodities;
  }

  public void setNaturalCommodities(List<BasicIncomeInfoDto> naturalCommodities) {
    this.naturalCommodities = naturalCommodities;
  }

  @Override
  public String toString() {
    return "ProcessDto [id=" + id + ", processNumber=" + processNumber + ", referenceName="
        + referenceName + ", date=" + date + ", obs=" + obs + "]";
  }
}
