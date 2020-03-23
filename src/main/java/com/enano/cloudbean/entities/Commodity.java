package com.enano.cloudbean.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table( name = "mercaderia")
public class Commodity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @OneToOne
  @JoinColumn(name="tipo_calidad_id", nullable = true)
  private QualityType qualityType;
  @OneToOne
  @JoinColumn(name="tipo_bolsa_id", nullable = true)
  private PackagingType packagingType;
  @Column(name="cantidad_bulto")
  private Integer bagQuantity;
  @Column(name="cantidad_kg")
  private Integer amount;
  @Column(name="ubicacion")
  private String locationInPlant;
  @Column(name="gramaje")
  private Integer gramaje;
  @Column(name="obs")
  private String obs;
  @OneToOne
  @JoinColumn(name = "grano_especie_id")
  private GrainType grainType;
  @Column(name="cosecha")
  private String harvesting;
  @Column(name="propietario")
  private Long owner;
  
  
  @ManyToMany(mappedBy = "commodities")
  @JsonIgnore
  private Set<Outcome> outcomes = new HashSet<>();
  
  @ManyToMany(mappedBy = "commodities")
  @JsonIgnore
  private Set<Income> incomes = new HashSet<>();
  
  @ManyToMany(mappedBy = "commoditiesToProcess")
  @JsonIgnore
  private Set<Process> commoditiesToProcess = new HashSet<>();
  
  @ManyToMany(mappedBy = "commoditiesProcessed")
  @JsonIgnore
  private Set<Process> commoditiesProcessed = new HashSet<>();

  public Commodity(Long id, QualityType qualityType, PackagingType packagingType,
      Integer bagQuantity, Integer amount, String locationInPlant, Integer gramaje, String obs,
      GrainType grainType, String harvesting, Long owner) {
    this.id = id;
    this.qualityType = qualityType;
    this.packagingType = packagingType;
    this.bagQuantity = bagQuantity;
    this.amount = amount;
    this.locationInPlant = locationInPlant;
    this.gramaje = gramaje;
    this.obs = obs;
    this.grainType = grainType;
    this.harvesting = harvesting;
    this.owner = owner;
  }

  public Commodity() {
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

  public Set<Outcome> getOutcomes() {
    return outcomes;
  }

  public void setOutcomes(Set<Outcome> outcomes) {
    this.outcomes = outcomes;
  }

  public Set<Income> getIncomes() {
    return incomes;
  }

  public void setIncomes(Set<Income> incomes) {
    this.incomes = incomes;
  }
  
  @Override
  public String toString() {
    return "Commodity [id=" + id + ", qualityType=" + qualityType + ", packagingType="
        + packagingType + ", bagQuantity=" + bagQuantity + ", amount=" + amount
        + ", locationInPlant=" + locationInPlant + ", gramaje=" + gramaje + ", obs=" + obs
        + ", grainType=" + grainType + ", harvesting=" + harvesting + ", owner=" + owner + "]";
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
    Commodity other = (Commodity) obj;
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
