package com.enano.cloudbean.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "entrada")
public class Income {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name="analisis_id")
  private int analysisId;
  @Column(name="numero_ingreso")
  private int incomeNo;
  @Column(name="carta_de_porte")
  private String waybill;
  @Column(name="cert_de_deposito")
  private String depositCertificate;
  @Column(name="CTG")
  private String ctg;
  @Column(name="peso_bruto")
  private int grossWeight;
  @Column(name="peso_tara")
  private int truckWeight;
  @Column(name="chofer")
  private String driverName;
  @Column(name="patente_camion")
  private String truckPatent;
  @Column(name="patente_acoplado")
  private String trailerPatent;
  @Column(name="titular_CP")
  private int waybillOwnerId;
  @Column(name="remitente_comercial")
  private int commercialSenderId;
  @Column(name="destinatario")
  private int receiverId;
  @Column(name="transporte")
  private int transporterId;
  @Column(name="procedencia")
  private int originId;
  @ManyToOne
  @JoinColumn(name = "grano_especie_id")
  private GrainType grainType;
  @Column(name="cantidad_bolsa")
  private int bagQuantity;
  @ManyToOne
  @JoinColumn(name = "tipo_bolsa")
  private PackagingType packaginType;
  @Column(name="ubicacion")
  private String locationInPlant;
  @Column(name="fecha_descarga")
  private Date downloadDate;
  @Column(name="fecha_modificacion")
  private Date modificationDate;
  @Column(name="observaciones")
  private String obs;
  @Column(name="img_dir")
  private String imgDir;
  
  public Income() {
  }
  
  public Income(Long id, int analysisId, int incomeNo, String waybill, String depositCertificate,
      String ctg, int grossWeight, int truckWeight, String driverName, String truckPatent,
      String trailerPatent, int waybillOwnerId, int commercialSenderId, int receiverId,
      int transporterId, int originId, GrainType grainType, int bagQuantity,
      PackagingType packaginType, String locationInPlant, Date downloadDate, Date modificationDate,
      String obs, String imgDir) {
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
    this.commercialSenderId = commercialSenderId;
    this.receiverId = receiverId;
    this.transporterId = transporterId;
    this.originId = originId;
    this.grainType = grainType;
    this.bagQuantity = bagQuantity;
    this.packaginType = packaginType;
    this.locationInPlant = locationInPlant;
    this.downloadDate = downloadDate;
    this.modificationDate = modificationDate;
    this.obs = obs;
    this.imgDir = imgDir;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public int getAnalysisId() {
    return analysisId;
  }

  public void setAnalysisId(int analysisId) {
    this.analysisId = analysisId;
  }

  public int getIncomeNo() {
    return incomeNo;
  }

  public void setIncomeNo(int incomeNo) {
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

  public int getGrossWeight() {
    return grossWeight;
  }

  public void setGrossWeight(int grossWeight) {
    this.grossWeight = grossWeight;
  }

  public int getTruckWeight() {
    return truckWeight;
  }

  public void setTruckWeight(int truckWeight) {
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

  public int getWaybillOwnerId() {
    return waybillOwnerId;
  }

  public void setWaybillOwnerId(int waybillOwnerId) {
    this.waybillOwnerId = waybillOwnerId;
  }

  public int getCommercialSenderId() {
    return commercialSenderId;
  }

  public void setCommercialSenderId(int commercialSenderId) {
    this.commercialSenderId = commercialSenderId;
  }

  public int getReceiverId() {
    return receiverId;
  }

  public void setReceiverId(int receiverId) {
    this.receiverId = receiverId;
  }

  public int getTransporterId() {
    return transporterId;
  }

  public void setTransporterId(int transporterId) {
    this.transporterId = transporterId;
  }

  public int getOriginId() {
    return originId;
  }

  public void setOriginId(int originId) {
    this.originId = originId;
  }

  public GrainType getGrainType() {
    return grainType;
  }

  public void setGrainType(GrainType grainType) {
    this.grainType = grainType;
  }

  public int getBagQuantity() {
    return bagQuantity;
  }

  public void setBagQuantity(int bagQuantity) {
    this.bagQuantity = bagQuantity;
  }

  public PackagingType getPackaginType() {
    return packaginType;
  }

  public void setPackaginType(PackagingType packaginType) {
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
