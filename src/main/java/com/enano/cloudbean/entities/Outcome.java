package com.enano.cloudbean.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
  @Column(name="cantidad_bolsa")
  private int bagQuantity;
  @OneToOne
  @JoinColumn(name = "tipo_bolsa")
  private PackagingType packagingType;
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
  
  @ManyToMany(cascade = { CascadeType.ALL })
  @JoinTable(
      name = "mercaderia_salida", 
      joinColumns = { @JoinColumn(name = "salida_id") }, 
      inverseJoinColumns = { @JoinColumn(name = "mercaderia_id") }
  )
  Set<Commodity> commodities = new HashSet<>();
 
  public Outcome() {
  }
  
  public Outcome(Long id, int outcomeNumber, Analysis analysisId, 
      String imgPath, String waybill, String ctg, Date loadingDate, ComercialEntity waybillOwner,
      ComercialEntity commercialSender, String deliveryRepresentative, ComercialEntity receiver,
      int bagQuantity, PackagingType packagingType, int grossWeight, int truckWeight, String obs,
      Location destiny, ComercialEntity carrier, String driverName, String truckPatent,
      String trailerPatent, Integer distanceToTravel, HashSet<Commodity> commodities) {
    this.id = id;
    this.outcomeNumber = outcomeNumber;
    this.analysisId = analysisId;
    this.imgPath = imgPath;
    this.waybill = waybill;
    this.ctg = ctg;
    this.loadingDate = loadingDate;
    this.waybillOwner = waybillOwner;
    this.commercialSender = commercialSender;
    this.deliveryRepresentative = deliveryRepresentative;
    this.receiver = receiver;
    this.bagQuantity = bagQuantity;
    this.packagingType = packagingType;
    this.grossWeight = grossWeight;
    this.truckWeight = truckWeight;
    this.obs = obs;
    this.destiny = destiny;
    this.carrier = carrier;
    this.driverName = driverName.toUpperCase();
    this.truckPatent = truckPatent;
    this.trailerPatent = trailerPatent;
    this.distanceToTravel = distanceToTravel;
    this.commodities = commodities;
  }
  
  public Long getId() {
    return (id != null && id > 0) ? id : null;
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
    this.driverName = driverName.toUpperCase();
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

  public Set<Commodity> getCommodities() {
    return commodities;
  }

  public void setCommodities(Set<Commodity> commodities) {
    this.commodities = commodities;
  }
}
