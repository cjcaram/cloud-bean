package com.enano.cloudbean.dtos;

import com.enano.cloudbean.entities.Commodity;
import com.enano.cloudbean.entities.CommodityStock;
import com.enano.cloudbean.entities.GrainType;
import com.enano.cloudbean.entities.PackagingType;
import com.enano.cloudbean.entities.QualityType;

public class CommodityDto {
  private Long id;
  private QualityType qualityType;
  private PackagingType packagingType;
  private Integer bagQuantity;
  private Integer amount;
  private String locationInPlant;
  private Integer gramaje;
  private String obs;
  private GrainType grainType;
  private Boolean editable = true;
  private String harvesting;
  private Long owner;

  public CommodityDto() {
  }
  
  public CommodityDto(Long id, QualityType qualityType, PackagingType packagingType,
      Integer bagQuantity, Integer amount, String locationInPlant, Integer gramaje, String obs,
      Long processId, GrainType grainType, String harvesting, Boolean editable, Long owner) {
    this.id = id;
    this.qualityType = qualityType;
    this.packagingType = packagingType;
    this.bagQuantity = bagQuantity;
    this.amount = amount;
    this.locationInPlant = locationInPlant;
    this.gramaje = gramaje;
    this.obs = obs;
    this.harvesting = harvesting;
    this.owner = owner;
    this.editable = (editable == null) ? true : editable;
  }
  
  public static CommodityStock From(Commodity commodity) {
    CommodityStock stock = new CommodityStock();
    stock.setOwner(commodity.getOwner());
    stock.setAmount(commodity.getAmount());
    stock.setBagQuantity(Integer.valueOf(commodity.getBagQuantity()));
    stock.setLocationInPlant(commodity.getLocationInPlant());
    stock.setObs(commodity.getObs());
    stock.setPackagingType(commodity.getPackagingType());
    stock.setQualityType(commodity.getQualityType());
    stock.setGrainType(commodity.getGrainType());
    stock.setGramaje(commodity.getGramaje());
    stock.setHarvesting(commodity.getHarvesting());
    stock.setCommodityId(commodity.getId());
    return stock;
  }
  
  public static Commodity From(CommodityDto item) {
    Commodity commodity = new Commodity();
    commodity.setId(item.getId());
    commodity.setAmount(item.getAmount());
    commodity.setBagQuantity(item.getBagQuantity());
    commodity.setGrainType(item.getGrainType());
    commodity.setGramaje(item.getGramaje());
    commodity.setHarvesting(item.getHarvesting());
    commodity.setLocationInPlant(item.getLocationInPlant());
    commodity.setOwner(item.getOwner());
    commodity.setPackagingType(item.getPackagingType());
    commodity.setQualityType(item.getQualityType());
    commodity.setObs(item.getObs());
    return commodity;
  }
  
  public static Commodity From(CommodityDto commoditydto, GrainType grainType, String harvesting, Long owner) {
    commoditydto.setGrainType(grainType);
    commoditydto.setHarvesting(harvesting);
    commoditydto.setOwner(owner);
    return From(commoditydto);
  }
  
  public Long getId() {
    return (id != null && id > 0) ? id : null;
  }

  public void setId(Long id) {
    this.id = (id != null && id < 0) ? null : id;
  }

  public QualityType getQualityType() {
    return qualityType;
  }

  public void setQualityType(QualityType qualityType) {
    this.qualityType = qualityType;
  }

  public PackagingType getPackagingType() {
    return packagingType;
  }

  public void setPackagingType(PackagingType packagingType) {
    this.packagingType = packagingType;
  }

  public Integer getBagQuantity() {
    return bagQuantity;
  }

  public void setBagQuantity(Integer bagQuantity) {
    this.bagQuantity = bagQuantity;
  }

  public Integer getAmount() {
    return amount;
  }

  public void setAmount(Integer amount) {
    this.amount = amount;
  }

  public String getLocationInPlant() {
    return locationInPlant;
  }

  public void setLocationInPlant(String locationInPlant) {
    this.locationInPlant = locationInPlant;
  }

  public Integer getGramaje() {
    return gramaje;
  }

  public void setGramaje(Integer gramaje) {
    this.gramaje = gramaje;
  }

  public String getObs() {
    return obs;
  }

  public void setObs(String obs) {
    this.obs = obs;
  }

  public Boolean isEditable() {
    if (editable == null) {
      this.editable = true;
    }
    return editable;
  }

  public void setEditable(Boolean editable) {
    if (editable == null) {
      this.editable = true;
    }
    this.editable = editable;
  }

  public GrainType getGrainType() {
    return grainType;
  }

  public void setGrainType(GrainType grainType) {
    this.grainType = grainType;
  }

  public String getHarvesting() {
    return harvesting;
  }

  public void setHarvesting(String harvesting) {
    this.harvesting = harvesting;
  }

  public Long getOwner() {
    return owner;
  }

  public void setOwner(Long owner) {
    this.owner = owner;
  }

}
