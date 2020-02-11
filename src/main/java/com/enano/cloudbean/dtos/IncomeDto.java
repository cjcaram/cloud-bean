package com.enano.cloudbean.dtos;

import java.util.Date;

import com.enano.cloudbean.entities.Analysis;
import com.enano.cloudbean.entities.Commodity;

public class IncomeDto extends BasicIncomeDto {
  
  private Analysis analysis;
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
  private Date downloadDate;
  private Date modificationDate;
  private String obs;
  private String imgDir;
  private Commodity commodity;
  
  public IncomeDto() {
  }
  
  public IncomeDto(Long id, Analysis analysis, Integer incomeNo, String waybill) {
    super(id, incomeNo);
    this.analysis = analysis;
    this.waybill = waybill;
  }
  
  public IncomeDto(Long id, Analysis analysis, String waybill, Integer incomeNo,
      String depositCertificate, String ctg, Integer grossWeight, Integer truckWeight,
      String driverName, String truckPatent, String trailerPatent, BaseCompanyDto waybillOwner,
      BaseCompanyDto commercialSender, BaseCompanyDto receiver, BaseCompanyDto transporter,
      BaseLocationDto origin, Date downloadDate, Date modificationDate, String obs, String imgDir,
      Commodity commodity) {
    super(id, incomeNo);
    this.analysis = analysis;
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
    this.downloadDate = downloadDate;
    this.modificationDate = modificationDate;
    this.obs = obs;
    this.imgDir = imgDir;
    this.commodity = commodity;
  }

  
  
  public Analysis getAnalysis() {
    return analysis;
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

  public void setAnalysis(Analysis analysis) {
    this.analysis = analysis;
  }

  public Commodity getCommodity() {
    return commodity;
  }

  public void setCommodity(Commodity commodity) {
    this.commodity = commodity;
  }
}
