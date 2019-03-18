package com.enano.cloudbean.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "salida")
public class Outcome {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name="numero_salida")
  private int outcomeNumber;
  @OneToOne
  @JoinColumn(name="analisis_id", nullable = true)
  private Analysis analysisId;
  @OneToOne
  @JoinColumn(name="entrada_id", nullable = true)
  private Income incomeId;
  @Column(name="mercaderia_id")
  private Long commodityId;
  @Column(name="parte_proceso_id")
  private Long processId;
  @Column(name="img_dir")
  private String imgPath;
  @Column(name="cp_numero")
  private String waybill;
  @Column(name="ctg")
  private String ctg;
  @Column(name="fecha_carga")
  private Date loadingDate;
  @OneToOne
  @JoinColumn(name="titular_CP_id", nullable = true)
  private ComercialEntity waybillOwner;
  @OneToOne
  @JoinColumn(name="remitente_comercial_id", nullable = true)
  private ComercialEntity commercialSender;
  @Column(name="representante_entregador")
  private String deliveryRepresentative;
  @OneToOne
  @JoinColumn(name="destinatario_id", nullable = true)
  private ComercialEntity receiver;
  @OneToOne
  @JoinColumn(name = "grano_especie", nullable = true)
  private GrainType grainType;
  @Column(name="cantidad_bolsa")
  private int bagQuantity;
  @OneToOne
  @JoinColumn(name = "tipo_bolsa")
  private PackagingType packagingType;
  @Column(name="calidad")
  private String quality;
  @Column(name="peso_bruto")
  private int grossWeight;
  @Column(name="peso_tara")
  private int truckWeight;
  @Column(name="obsercaciones")
  private String obs;
  @OneToOne
  @JoinColumn(name="destino", nullable = true)
  private Location destiny;
  @OneToOne
  @JoinColumn(name="transporte", nullable = true)
  private ComercialEntity carrier;
  @Column(name="chofer")
  private String driverName;
  @Column(name="patente_camion")
  private String truckPatent;
  @Column(name="patente_acoplado")
  private String trailerPatent;
  @Column(name="KM_a_recorrer")
  private Integer distanceToTravel;
 
  public Outcome() {
  }
  
  public Outcome(Long id, int outcomeNumber, Analysis analysisId, Income incomeId, Long commodityId,
      Long processId, String imgPath, String waybill, String ctg, Date loadingDate,
      ComercialEntity waybillOwner, ComercialEntity commercialSender, String deliveryRepresentative,
      ComercialEntity receiver, GrainType grainType, int bagQuantity, PackagingType packagingType,
      String quality, int grossWeight, int truckWeight, String obs, Location destiny,
      ComercialEntity carrier, String driverName, String truckPatent, String trailerPatent,
      Integer distanceToTravel) {
    this.id = id;
    this.outcomeNumber = outcomeNumber;
    this.analysisId = analysisId;
    this.incomeId = incomeId;
    this.commodityId = commodityId;
    this.processId = processId;
    this.imgPath = imgPath;
    this.waybill = waybill;
    this.ctg = ctg;
    this.loadingDate = loadingDate;
    this.waybillOwner = waybillOwner;
    this.commercialSender = commercialSender;
    this.deliveryRepresentative = deliveryRepresentative;
    this.receiver = receiver;
    this.grainType = grainType;
    this.bagQuantity = bagQuantity;
    this.packagingType = packagingType;
    this.quality = quality;
    this.grossWeight = grossWeight;
    this.truckWeight = truckWeight;
    this.obs = obs;
    this.destiny = destiny;
    this.carrier = carrier;
    this.driverName = driverName;
    this.truckPatent = truckPatent;
    this.trailerPatent = trailerPatent;
    this.distanceToTravel = distanceToTravel;
  }
 
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Analysis getAnalysisId() {
    return analysisId;
  }

  public void setAnalysisId(Analysis analysisId) {
    this.analysisId = analysisId;
  }

  public Income getIncomeId() {
    return incomeId;
  }

  public void setIncomeId(Income incomeId) {
    this.incomeId = incomeId;
  }

  public Long getCommodityId() {
    return commodityId;
  }

  public void setCommodityId(Long commodityId) {
    this.commodityId = commodityId;
  }

  public Long getProcessId() {
    return processId;
  }

  public void setProcessId(Long processId) {
    this.processId = processId;
  }

  public String getImgPath() {
    return imgPath;
  }

  public void setImgPath(String imgPath) {
    this.imgPath = imgPath;
  }

  public String getWaybill() {
    return waybill;
  }

  public void setWaybill(String waybill) {
    this.waybill = waybill;
  }

  public String getCtg() {
    return ctg;
  }

  public void setCtg(String ctg) {
    this.ctg = ctg;
  }

  public Date getLoadingDate() {
    return loadingDate;
  }

  public void setLoadingDate(Date loadingDate) {
    this.loadingDate = loadingDate;
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

  public String getDeliveryRepresentative() {
    return deliveryRepresentative;
  }

  public void setDeliveryRepresentative(String deliveryRepresentative) {
    this.deliveryRepresentative = deliveryRepresentative;
  }

  public ComercialEntity getReceiver() {
    return receiver;
  }

  public void setReceiver(ComercialEntity receiver) {
    this.receiver = receiver;
  }

  public GrainType getGrainType() {
    return grainType;
  }

  public void setGrainType(GrainType grainType) {
    this.grainType = grainType;
  }

  public String getQuality() {
    return quality;
  }

  public void setQuality(String quality) {
    this.quality = quality;
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

  public String getObs() {
    return obs;
  }

  public void setObs(String obs) {
    this.obs = obs;
  }

  public Location getDestiny() {
    return destiny;
  }

  public void setDestiny(Location destiny) {
    this.destiny = destiny;
  }

  public ComercialEntity getCarrier() {
    return carrier;
  }

  public void setCarrier(ComercialEntity carrier) {
    this.carrier = carrier;
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

  public Integer getDistanceToTravel() {
    return distanceToTravel;
  }

  public void setDistanceToTravel(Integer distanceToTravel) {
    this.distanceToTravel = distanceToTravel;
  }

  public int getOutcomeNumber() {
    return outcomeNumber;
  }

  public void setOutcomeNumber(int outcomeNumber) {
    this.outcomeNumber = outcomeNumber;
  }

  public String getDriverName() {
    return driverName;
  }

  public void setDriverName(String driverName) {
    this.driverName = driverName;
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
}