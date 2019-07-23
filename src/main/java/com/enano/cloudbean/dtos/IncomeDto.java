package com.enano.cloudbean.dtos;

import java.util.Date;

import com.enano.cloudbean.entities.Analysis;
import com.enano.cloudbean.entities.GrainType;
import com.enano.cloudbean.entities.PackagingType;

public class IncomeDto {
  private Integer id;
  private Analysis analysis;
  private Integer incomeNo;
  private String waybill;
  private String depositCertificate;
  private String ctg;
  private Integer grossWeight;
  private Integer truckWeight;
  private String driverName;
  private String truckPatent;
  private String trailerPatent;
  private BaseCompanyDto waybillOwner;
  private BaseCompanyDto commercialSender;
  private BaseCompanyDto receiver;
  private BaseCompanyDto transporter;
  private BaseLocationDto origin;
  private GrainType grainType;
  private Integer bagQuantity;
  private PackagingType packagingType;
  private String locationInPlant;
  private Date downloadDate;
  private Date modificationDate;
  private String obs;
  private String imgDir;
  private String harvesting;
  
  public IncomeDto() {
  }
  
  public IncomeDto(Integer id, Analysis analysis, Integer incomeNo, String waybill) {
    this.id = id;
    this.analysis = analysis;
    this.incomeNo = incomeNo;
    this.waybill = waybill;
  }
  
  public IncomeDto(Integer id, Analysis analysis, Integer incomeNo, String waybill,
      String depositCertificate, String ctg, Integer grossWeight, Integer truckWeight,
      String driverName, String truckPatent, String trailerPatent, BaseCompanyDto waybillOwner, 
      BaseCompanyDto commercialSender, BaseCompanyDto receiver, BaseCompanyDto transporter, 
      BaseLocationDto origin, GrainType grainType, String grainTypeVariety, 
      Integer bagQuantity, PackagingType packagingType, String locationInPlant, 
      Date downloadDate, Date modificationDate, String obs, String imgDir, String harvesting) {
    this.id = id;
    this.analysis = analysis;
    this.incomeNo = incomeNo;
    this.waybill = waybill;
    this.depositCertificate = depositCertificate;
    this.ctg = ctg;
    this.grossWeight = grossWeight;
    this.truckWeight = truckWeight;
    this.driverName = driverName;
    this.truckPatent = truckPatent;
    this.trailerPatent = trailerPatent;
    this.waybillOwner = waybillOwner;
    this.commercialSender = commercialSender;
    this.receiver = receiver;
    this.transporter = transporter;
    this.origin = origin;
    this.grainType = grainType;
    this.bagQuantity = bagQuantity;
    this.packagingType = packagingType;
    this.locationInPlant = locationInPlant;
    this.downloadDate = downloadDate;
    this.modificationDate = modificationDate;
    this.obs = obs;
    this.imgDir = imgDir;
    this.harvesting = harvesting;
  }

  public Integer getId() {
    return (id != null && id > 0) ? id : null;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Analysis getAnalysis() {
    return analysis;
  }

  public void setAnalysisId(Analysis analysis) {
    this.analysis = analysis;
  }

  public Integer getIncomeNo() {
    return incomeNo;
  }

  public void setIncomeNo(Integer incomeNo) {
    this.incomeNo = incomeNo;
  }

  public String getWaybill() {
    return waybill;
  }

  public void setWaybill(String waybill) {
    this.waybill = waybill;
  }

  public String getDepositCertificate() {
    return depositCertificate;
  }

  public void setDepositCertificate(String depositCertificate) {
    this.depositCertificate = depositCertificate;
  }

  public String getCtg() {
    return ctg;
  }

  public void setCtg(String ctg) {
    this.ctg = ctg;
  }

  public Integer getGrossWeight() {
    return grossWeight;
  }

  public void setGrossWeight(Integer grossWeight) {
    this.grossWeight = grossWeight;
  }

  public Integer getTruckWeight() {
    return truckWeight;
  }

  public void setTruckWeight(Integer truckWeight) {
    this.truckWeight = truckWeight;
  }

  public String getDriverName() {
    return driverName;
  }

  public void setDriverName(String driverName) {
    this.driverName = driverName;
  }

  public String getTruckPatent() {
    return truckPatent;
  }

  public void setTruckPatent(String truckPatent) {
    this.truckPatent = truckPatent;
  }

  public String getTrailerPatent() {
    return trailerPatent;
  }

  public void setTrailerPatent(String trailerPatent) {
    this.trailerPatent = trailerPatent;
  }

  public BaseCompanyDto getWaybillOwner() {
    return waybillOwner;
  }

  public void setWaybillOwner(BaseCompanyDto waybillOwner) {
    this.waybillOwner = waybillOwner;
  }

  public BaseCompanyDto getCommercialSender() {
    return commercialSender;
  }

  public void setCommercialSender(BaseCompanyDto commercialSender) {
    this.commercialSender = commercialSender;
  }

  public BaseCompanyDto getReceiver() {
    return receiver;
  }

  public void setReceiver(BaseCompanyDto receiver) {
    this.receiver = receiver;
  }

  public BaseCompanyDto getTransporter() {
    return transporter;
  }

  public void setTransporter(BaseCompanyDto transporter) {
    this.transporter = transporter;
  }

  public BaseLocationDto getOrigin() {
    return origin;
  }

  public void setOrigin(BaseLocationDto origin) {
    this.origin = origin;
  }

  public GrainType getGrainType() {
    return grainType;
  }

  public void setGrainType(GrainType grainType) {
    this.grainType = grainType;
  }

  public Integer getBagQuantity() {
    return bagQuantity;
  }

  public void setBagQuantity(Integer bagQuantity) {
    this.bagQuantity = bagQuantity;
  }

  public PackagingType getPackagingType() {
    return packagingType;
  }

  public void setPackagingType(PackagingType packagingType) {
    this.packagingType = packagingType;
  }

  public String getLocationInPlant() {
    return locationInPlant;
  }

  public void setLocationInPlant(String locationInPlant) {
    this.locationInPlant = locationInPlant;
  }

  public Date getDownloadDate() {
    return downloadDate;
  }

  public void setDownloadDate(Date downloadDate) {
    this.downloadDate = downloadDate;
  }

  public Date getModificationDate() {
    return modificationDate;
  }

  public void setModificationDate(Date modificationDate) {
    this.modificationDate = modificationDate;
  }

  public String getObs() {
    return obs;
  }

  public void setObs(String obs) {
    this.obs = obs;
  }

  public String getImgDir() {
    return imgDir;
  }

  public void setImgDir(String imgDir) {
    this.imgDir = imgDir;
  }

  public String getHarvesting() {
    return harvesting;
  }

  public void setHarvesting(String harvesting) {
    this.harvesting = harvesting;
  }

  public void setAnalysis(Analysis analysis) {
    this.analysis = analysis;
  }
}
