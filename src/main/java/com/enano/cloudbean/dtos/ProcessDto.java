package com.enano.cloudbean.dtos;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import com.enano.cloudbean.entities.Commodity;
import com.enano.cloudbean.entities.GrainType;

public class ProcessDto {
  
  private Long id;
  private int processNumber;
  private String referenceName;
  private Date date;
  private String obs;
  private Set<CommodityDto> processedCommodities;
  private Set<CommodityDto> naturalCommodities;

  public ProcessDto () {}

  public ProcessDto(Long id, int processNumber, String referenceName, Date date, String obs,
      Set<CommodityDto> processedCommodities, Set<CommodityDto> naturalCommodities) {
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

  public Set<CommodityDto> getProcessedCommodities() {
    return processedCommodities;
  }

  public void setProcessedCommodities(Set<CommodityDto> processedCommodities) {
    this.processedCommodities = processedCommodities;
  }
  
  public Set<CommodityDto> getNaturalCommodities() {
    return naturalCommodities;
  }
  
  public void setNaturalCommodities(Set<CommodityDto> naturalCommodities) {
    this.naturalCommodities = naturalCommodities;
  }
  
  
  
  public Set<Commodity> getCommoditiesToProcess() {
    Set<Commodity> commodities = this.naturalCommodities.stream()
        .map(item -> CommodityDto.From(item))
        .collect(Collectors.toSet());
    return commodities;
  }
  
  public Set<Commodity> getCommoditiesProcessed() {
    CommodityDto auxValues = this.naturalCommodities.iterator().next();
    
    GrainType auxGrainType = auxValues.getGrainType();
    String auxHarvesting = auxValues.getHarvesting();
    Long auxOwner = auxValues.getOwner();
    
    Set<Commodity> commodities = new HashSet<>();
    for(CommodityDto processedItem : processedCommodities) {
      commodities.add(CommodityDto.From(processedItem, auxGrainType, auxHarvesting, auxOwner));
    }
    
    return commodities;
  }

  @Override
  public String toString() {
    return "ProcessDto [id=" + id + ", processNumber=" + processNumber + ", referenceName="
        + referenceName + ", date=" + date + ", obs=" + obs + "]";
  }
}
