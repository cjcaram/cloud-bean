package com.enano.cloudbean.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "entrada")
public class Income {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @OneToOne(fetch = FetchType.EAGER)
  @JoinColumn(name="analisis_id", nullable = true)
  private Analysis analysis;
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
  @OneToOne
  @JoinColumn(name="titular_CP", nullable = true)
  private ComercialEntity waybillOwner;
  @OneToOne
  @JoinColumn(name="remitente_comercial", nullable = true)
  private ComercialEntity commercialSender;
  @OneToOne
  @JoinColumn(name="destinatario", nullable = true)
  private ComercialEntity receiver;
  @OneToOne
  @JoinColumn(name="transporte", nullable = true)
  private ComercialEntity transporter;
  @OneToOne
  @JoinColumn(name="procedencia", nullable = true)
  private Location origin;
  @OneToOne
  @JoinColumn(name = "grano_especie_id")
  private GrainType grainType;
  @Column(name="cantidad_bolsa")
  private int bagQuantity;
  @OneToOne
  @JoinColumn(name = "tipo_bolsa")
  private PackagingType packagingType;
  @Column(name="ubicacion")
  private String locationInPlant;
  @Column(name="fecha_descarga")
  private Date downloadDate;
  @JsonIgnore
  @Column(name="fecha_modificacion")
  private Date modificationDate;
  @Column(name="observaciones")
  private String obs;
  @Column(name="img_dir")
  private String imgDir;
  @Column(name="cosecha")
  private String harvesting;
  
  public Income() {
  }
  
  public Income(Long id, Analysis analysis, int incomeNo, String waybill, String depositCertificate,
      String ctg, int grossWeight, int truckWeight, String driverName, String truckPatent,
      String trailerPatent, ComercialEntity waybillOwner, ComercialEntity commercialSender, ComercialEntity receiver,
      ComercialEntity transporter, Location origin, GrainType grainType, int bagQuantity,
      PackagingType packagingType, String locationInPlant, Date downloadDate, Date modificationDate,
      String obs, String imgDir, String harvesting) {
    this.id = id;
    this.analysis = analysis;
    this.incomeNo = incomeNo;
    this.waybill = waybill;
    this.depositCertificate = depositCertificate;
    this.ctg = ctg;
    this.grossWeight = grossWeight;
    this.truckWeight = truckWeight;
    this.driverName = driverName.toUpperCase();
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

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Analysis getAnalysis() {
    return analysis;
  }

  public void setAnalysis(Analysis analysis) {
    this.analysis = analysis;
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
    this.driverName = driverName.toUpperCase();
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

  public ComercialEntity getWaybillOwner() {
    return waybillOwner;
  }

  public void setWaybillOwner(ComercialEntity waybillOwner) {
    this.waybillOwner = waybillOwner;
  }

  public ComercialEntity getCommercialSender() {
    return commercialSender;
  }

  public void setCommercialSender(ComercialEntity commercialSender) {
    this.commercialSender = commercialSender;
  }

  public ComercialEntity getReceiver() {
    return receiver;
  }

  public void setReceiver(ComercialEntity receiver) {
    this.receiver = receiver;
  }

  public ComercialEntity getTransporter() {
    return transporter;
  }

  public void setTransporter(ComercialEntity transporter) {
    this.transporter = transporter;
  }

  public Location getOrigin() {
    return origin;
  }

  public void setOriginId(Location origin) {
    this.origin = origin;
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

  public void setOrigin(Location origin) {
    this.origin = origin;
  }

}
