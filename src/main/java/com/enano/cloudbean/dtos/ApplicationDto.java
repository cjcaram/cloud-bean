package com.enano.cloudbean.dtos;

import java.util.Date;
import java.util.Set;

import com.enano.cloudbean.entities.AgrochemicalAppType;
import com.enano.cloudbean.entities.AgrochemicalApplication;
import com.enano.cloudbean.entities.LandBatch;

public class ApplicationDto {
  private Long id;
  private Integer applicationNumber;
  private Date applicationDate;
  private LandBatch landBatch;
  private Integer haAmount;
  private AgrochemicalAppType applicationType;
  private Set<AgrochemicalApplication> items;
  
  public ApplicationDto() {
  }

  public ApplicationDto(Long id, Integer applicationNumber, Date applicationDate, LandBatch landBatch,
      Integer haAmount, AgrochemicalAppType applicationType, Set<AgrochemicalApplication> items) {
    this.id = id;
    this.applicationNumber = applicationNumber;
    this.applicationDate = applicationDate;
    this.landBatch = landBatch;
    this.haAmount = haAmount;
    this.applicationType = applicationType;
    this.items = items;
  }

  public Integer getApplicationNumber() {
    return applicationNumber;
  }

  public void setApplicationNumber(Integer applicationNumber) {
    this.applicationNumber = applicationNumber;
  }

  public Date getApplicationDate() {
    return applicationDate;
  }

  public void setApplicationDate(Date applicationDate) {
    this.applicationDate = applicationDate;
  }

  public LandBatch getLandBatch() {
    return landBatch;
  }

  public void setLandBatch(LandBatch landBatch) {
    this.landBatch = landBatch;
  }

  public Integer getHaAmount() {
    return haAmount;
  }

  public void setHaAmount(Integer haAmount) {
    this.haAmount = haAmount;
  }

  public AgrochemicalAppType getApplicationType() {
    return applicationType;
  }

  public void setApplicationType(AgrochemicalAppType applicationType) {
    this.applicationType = applicationType;
  }

  public Set<AgrochemicalApplication> getItems() {
    return items;
  }

  public void setItems(Set<AgrochemicalApplication> items) {
    this.items = items;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }
}

