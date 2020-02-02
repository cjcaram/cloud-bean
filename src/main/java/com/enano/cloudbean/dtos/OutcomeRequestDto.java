package com.enano.cloudbean.dtos;

import java.util.Date;
import java.util.List;

import com.enano.cloudbean.entities.Analysis;
import com.enano.cloudbean.entities.ComercialEntity;
import com.enano.cloudbean.entities.Location;
import com.enano.cloudbean.entities.Outcome;
import com.enano.cloudbean.entities.PackagingType;

public class OutcomeRequestDto {
  private Long id;
  private int outcomeNumber;
  private Analysis analysisId;
  private List<Long> commodityStockIds;
  private String imgPath;
  private String waybill;
  private String ctg;
  private Date loadingDate;
  private ComercialEntity waybillOwner;
  private ComercialEntity commercialSender;
  private String deliveryRepresentative;
  private ComercialEntity receiver;
  private int bagQuantity;
  private PackagingType packagingType;
  private int grossWeight;
  private int truckWeight;
  private String obs;
  private Location destiny;
  private ComercialEntity carrier;
  private String driverName;
  private String truckPatent;
  private String trailerPatent;
  private Integer distanceToTravel;
  
  public static Outcome From(OutcomeRequestDto requestDto) {
    Outcome outcome = new Outcome();
    
    outcome.setId(requestDto.getId());
    outcome.setAnalysisId(requestDto.getAnalysisId());
    outcome.setBagQuantity(requestDto.getBagQuantity());
    outcome.setCarrier(requestDto.getCarrier());
    outcome.setCommercialSender(requestDto.getCommercialSender());
    outcome.setCtg(requestDto.getCtg());
    outcome.setDeliveryRepresentative(requestDto.getDeliveryRepresentative());
    outcome.setDestiny(requestDto.getDestiny());
    outcome.setDistanceToTravel(requestDto.getDistanceToTravel());
    outcome.setDriverName(requestDto.getDriverName());
    outcome.setGrossWeight(requestDto.getGrossWeight());
    outcome.setImgPath(requestDto.getImgPath());
    outcome.setLoadingDate(requestDto.getLoadingDate());
    outcome.setObs(requestDto.getObs());
    outcome.setOutcomeNumber(requestDto.getOutcomeNumber());
    outcome.setPackagingType(requestDto.getPackagingType());
    outcome.setReceiver(requestDto.getReceiver());
    outcome.setTrailerPatent(requestDto.getTrailerPatent());
    outcome.setTruckPatent(requestDto.getTrailerPatent());
    outcome.setTruckWeight(requestDto.getTruckWeight());
    outcome.setWaybill(requestDto.getWaybill());
    outcome.setWaybillOwner(requestDto.getWaybillOwner());
    
    return outcome; 
  }
 
  public OutcomeRequestDto() { }
  
  public OutcomeRequestDto(Long id, int outcomeNumber, Analysis analysisId,
      List<Long> commodityStockIds, String imgPath, String waybill, String ctg, Date loadingDate,
      ComercialEntity waybillOwner, ComercialEntity commercialSender, String deliveryRepresentative,
      ComercialEntity receiver, int bagQuantity, PackagingType packagingType, int grossWeight,
      int truckWeight, String obs, Location destiny, ComercialEntity carrier, String driverName,
      String truckPatent, String trailerPatent, Integer distanceToTravel) {
    this.id = id;
    this.outcomeNumber = outcomeNumber;
    this.analysisId = analysisId;
    this.commodityStockIds = commodityStockIds;
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

  public int getOutcomeNumber() {
    return outcomeNumber;
  }

  public void setOutcomeNumber(int outcomeNumber) {
    this.outcomeNumber = outcomeNumber;
  }

  public Analysis getAnalysisId() {
    return analysisId;
  }

  public void setAnalysisId(Analysis analysisId) {
    this.analysisId = analysisId;
  }

  public List<Long> getCommodityStockIds() {
    return commodityStockIds;
  }

  public void setCommodityStockIds(List<Long> commodityStockIds) {
    this.commodityStockIds = commodityStockIds;
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

  public Integer getDistanceToTravel() {
    return distanceToTravel;
  }

  public void setDistanceToTravel(Integer distanceToTravel) {
    this.distanceToTravel = distanceToTravel;
  }
  
}
