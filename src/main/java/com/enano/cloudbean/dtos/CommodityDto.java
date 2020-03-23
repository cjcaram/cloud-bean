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
  
  public static Commodity From(CommodityStock item) {
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

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((amount == null) ? 0 : amount.hashCode());
    result = prime * result + ((bagQuantity == null) ? 0 : bagQuantity.hashCode());
    result = prime * result + ((grainType == null) ? 0 : grainType.hashCode());
    result = prime * result + ((gramaje == null) ? 0 : gramaje.hashCode());
    result = prime * result + ((harvesting == null) ? 0 : harvesting.hashCode());
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result = prime * result + ((locationInPlant == null) ? 0 : locationInPlant.hashCode());
    result = prime * result + ((obs == null) ? 0 : obs.hashCode());
    result = prime * result + ((owner == null) ? 0 : owner.hashCode());
    result = prime * result + ((packagingType == null) ? 0 : packagingType.hashCode());
    result = prime * result + ((qualityType == null) ? 0 : qualityType.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    CommodityDto other = (CommodityDto) obj;
    if (amount == null) {
      if (other.amount != null)
        return false;
    } else if (!amount.equals(other.amount))
      return false;
    if (bagQuantity == null) {
      if (other.bagQuantity != null)
        return false;
    } else if (!bagQuantity.equals(other.bagQuantity))
      return false;
    if (grainType == null) {
      if (other.grainType != null)
        return false;
    } else if (!grainType.equals(other.grainType))
      return false;
    if (gramaje == null) {
      if (other.gramaje != null)
        return false;
    } else if (!gramaje.equals(other.gramaje))
      return false;
    if (harvesting == null) {
      if (other.harvesting != null)
        return false;
    } else if (!harvesting.equals(other.harvesting))
      return false;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    if (locationInPlant == null) {
      if (other.locationInPlant != null)
        return false;
    } else if (!locationInPlant.equals(other.locationInPlant))
      return false;
    if (obs == null) {
      if (other.obs != null)
        return false;
    } else if (!obs.equals(other.obs))
      return false;
    if (owner == null) {
      if (other.owner != null)
        return false;
    } else if (!owner.equals(other.owner))
      return false;
    if (packagingType == null) {
      if (other.packagingType != null)
        return false;
    } else if (!packagingType.equals(other.packagingType))
      return false;
    if (qualityType == null) {
      if (other.qualityType != null)
        return false;
    } else if (!qualityType.equals(other.qualityType))
      return false;
    return true;
  }
}
