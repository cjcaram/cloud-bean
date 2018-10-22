package com.enano.cloudbean.dtos;

import java.util.Date;

public class IncomeDto {
  private Integer id;
  private Integer analysisId;
  private Integer incomeNo;
  private String waybill;
  private String depositCertificate;
  private String ctg;
  private Integer grossWeight;
  private Integer truckWeight;
  private String driverName;
  private String truckPatent;
  private String trailerPatent;
  private Integer waybillOwnerId;
  private String waybillOwner;
  private Integer commercialSenderId;
  private String commercialSender;
  private Integer receiverId;
  private String receiver;
  private Integer transporterId;
  private String transporter;
  private Integer originId;
  private String origin;
  private Integer grainTypeId;
  private String grainType;
  private String grainTypeVariety;
  private Integer bagQuantity;
  private Integer packaginTypeId;
  private String packaginType;
  private String locationInPlant;
  private Date downloadDate;
  private Date modificationDate;
  private String obs;
  private String imgDir;
  
  public IncomeDto() {
  }
  
  public IncomeDto(Integer id, Integer analysisId, Integer incomeNo, String waybill,
      String depositCertificate, String ctg, Integer grossWeight, Integer truckWeight,
      String driverName, String truckPatent, String trailerPatent, Integer waybillOwnerId,
      String waybillOwner, Integer commercialSenderId, String commercialSender, Integer receiverId,
      String receiver, Integer transporterId, String transporter, Integer originId, String origin,
      Integer grainTypeId, String grainType, String grainTypeVariety, Integer bagQuantity,
      Integer packaginTypeId, String packaginType, String locationInPlant, Date downloadDate,
      Date modificationDate, String obs, String imgDir) {
    this.id = id;
    this.analysisId = analysisId;
    this.incomeNo = incomeNo;
    this.waybill = waybill;
    this.depositCertificate = depositCertificate;
    this.ctg = ctg;
    this.grossWeight = grossWeight;
    this.truckWeight = truckWeight;
    this.driverName = driverName;
    this.truckPatent = truckPatent;
    this.trailerPatent = trailerPatent;
    this.waybillOwnerId = waybillOwnerId;
    this.waybillOwner = waybillOwner;
    this.commercialSenderId = commercialSenderId;
    this.commercialSender = commercialSender;
    this.receiverId = receiverId;
    this.receiver = receiver;
    this.transporterId = transporterId;
    this.transporter = transporter;
    this.originId = originId;
    this.origin = origin;
    this.grainTypeId = grainTypeId;
    this.grainType = grainType;
    this.grainTypeVariety = grainTypeVariety;
    this.bagQuantity = bagQuantity;
    this.packaginTypeId = packaginTypeId;
    this.packaginType = packaginType;
    this.locationInPlant = locationInPlant;
    this.downloadDate = downloadDate;
    this.modificationDate = modificationDate;
    this.obs = obs;
    this.imgDir = imgDir;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getAnalysisId() {
    return analysisId;
  }

  public void setAnalysisId(Integer analysisId) {
    this.analysisId = analysisId;
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

  public Integer getWaybillOwnerId() {
    return waybillOwnerId;
  }

  public void setWaybillOwnerId(Integer waybillOwnerId) {
    this.waybillOwnerId = waybillOwnerId;
  }

  public String getWaybillOwner() {
    return waybillOwner;
  }

  public void setWaybillOwner(String waybillOwner) {
    this.waybillOwner = waybillOwner;
  }

  public Integer getCommercialSenderId() {
    return commercialSenderId;
  }

  public void setCommercialSenderId(Integer commercialSenderId) {
    this.commercialSenderId = commercialSenderId;
  }

  public String getCommercialSender() {
    return commercialSender;
  }

  public void setCommercialSender(String commercialSender) {
    this.commercialSender = commercialSender;
  }

  public Integer getReceiverId() {
    return receiverId;
  }

  public void setReceiverId(Integer receiverId) {
    this.receiverId = receiverId;
  }

  public String getReceiver() {
    return receiver;
  }

  public void setReceiver(String receiver) {
    this.receiver = receiver;
  }

  public Integer getTransporterId() {
    return transporterId;
  }

  public void setTransporterId(Integer transporterId) {
    this.transporterId = transporterId;
  }

  public String getTransporter() {
    return transporter;
  }

  public void setTransporter(String transporter) {
    this.transporter = transporter;
  }

  public Integer getOriginId() {
    return originId;
  }

  public void setOriginId(Integer originId) {
    this.originId = originId;
  }

  public String getOrigin() {
    return origin;
  }

  public void setOrigin(String origin) {
    this.origin = origin;
  }

  public Integer getGrainTypeId() {
    return grainTypeId;
  }

  public void setGrainTypeId(Integer grainTypeId) {
    this.grainTypeId = grainTypeId;
  }

  public String getGrainType() {
    return grainType;
  }

  public void setGrainType(String grainType) {
    this.grainType = grainType;
  }

  public String getGrainTypeVariety() {
    return grainTypeVariety;
  }

  public void setGrainTypeVariety(String grainTypeVariety) {
    this.grainTypeVariety = grainTypeVariety;
  }

  public Integer getBagQuantity() {
    return bagQuantity;
  }

  public void setBagQuantity(Integer bagQuantity) {
    this.bagQuantity = bagQuantity;
  }

  public Integer getPackaginTypeId() {
    return packaginTypeId;
  }

  public void setPackaginTypeId(Integer packaginTypeId) {
    this.packaginTypeId = packaginTypeId;
  }

  public String getPackaginType() {
    return packaginType;
  }

  public void setPackaginType(String packaginType) {
    this.packaginType = packaginType;
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
}
