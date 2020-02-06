package com.enano.cloudbean.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "entrada")
public class Income {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @OneToOne(fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
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
  @Column(name="fecha_descarga")
  private Date downloadDate;
  @JsonIgnore
  @Column(name="fecha_modificacion")
  private Date modificationDate;
  @Column(name="observaciones")
  private String obs;
  @Column(name="img_dir")
  private String imgDir;
  
  @ManyToMany(cascade = { CascadeType.ALL })
  @JoinTable(
      name = "mercaderia_entrada", 
      joinColumns = { @JoinColumn(name = "entrada_id") }, 
      inverseJoinColumns = { @JoinColumn(name = "mercaderia_id") }
  )
  Set<Commodity> commodities = new HashSet<>();
  
  public Income() {
  }
  
  public Income(Long id, Analysis analysis, int incomeNo, String waybill, String depositCertificate,
      String ctg, int grossWeight, int truckWeight, String driverName, String truckPatent,
      String trailerPatent, ComercialEntity waybillOwner, ComercialEntity commercialSender,
      ComercialEntity receiver, ComercialEntity transporter, Location origin, Date downloadDate,
      Date modificationDate, String obs, String imgDir, Set<Commodity> commodities) {
    this.id = id;
    this.analysis = analysis;
    this.incomeNo = incomeNo;
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
    this.commodities = commodities;
  }
  
  public Long getId() {
    return (id != null && id > 0) ? id : null;
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

  public void setOrigin(Location origin) {
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

  public Set<Commodity> getCommodities() {
    return commodities;
  }

  public void setCommodities(Set<Commodity> commodities) {
    this.commodities = commodities;
  }

  @Override
  public String toString() {
    return "Income [id=" + id + ", analysis=" + analysis + ", incomeNo=" + incomeNo + ", waybill="
        + waybill + ", depositCertificate=" + depositCertificate + ", ctg=" + ctg + ", grossWeight="
        + grossWeight + ", truckWeight=" + truckWeight + ", driverName=" + driverName
        + ", truckPatent=" + truckPatent + ", trailerPatent=" + trailerPatent + ", waybillOwner="
        + waybillOwner + ", commercialSender=" + commercialSender + ", receiver=" + receiver
        + ", transporter=" + transporter + ", origin=" + origin + ", downloadDate=" + downloadDate
        + ", modificationDate=" + modificationDate + ", obs=" + obs + ", imgDir=" + imgDir + "]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((analysis == null) ? 0 : analysis.hashCode());
    result = prime * result + ((commercialSender == null) ? 0 : commercialSender.hashCode());
    result = prime * result + ((ctg == null) ? 0 : ctg.hashCode());
    result = prime * result + ((depositCertificate == null) ? 0 : depositCertificate.hashCode());
    result = prime * result + ((downloadDate == null) ? 0 : downloadDate.hashCode());
    result = prime * result + ((driverName == null) ? 0 : driverName.hashCode());
    result = prime * result + grossWeight;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result = prime * result + ((imgDir == null) ? 0 : imgDir.hashCode());
    result = prime * result + incomeNo;
    result = prime * result + ((modificationDate == null) ? 0 : modificationDate.hashCode());
    result = prime * result + ((obs == null) ? 0 : obs.hashCode());
    result = prime * result + ((origin == null) ? 0 : origin.hashCode());
    result = prime * result + ((receiver == null) ? 0 : receiver.hashCode());
    result = prime * result + ((trailerPatent == null) ? 0 : trailerPatent.hashCode());
    result = prime * result + ((transporter == null) ? 0 : transporter.hashCode());
    result = prime * result + ((truckPatent == null) ? 0 : truckPatent.hashCode());
    result = prime * result + truckWeight;
    result = prime * result + ((waybill == null) ? 0 : waybill.hashCode());
    result = prime * result + ((waybillOwner == null) ? 0 : waybillOwner.hashCode());
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
    Income other = (Income) obj;
    if (analysis == null) {
      if (other.analysis != null)
        return false;
    } else if (!analysis.equals(other.analysis))
      return false;
    if (commercialSender == null) {
      if (other.commercialSender != null)
        return false;
    } else if (!commercialSender.equals(other.commercialSender))
      return false;
    if (ctg == null) {
      if (other.ctg != null)
        return false;
    } else if (!ctg.equals(other.ctg))
      return false;
    if (depositCertificate == null) {
      if (other.depositCertificate != null)
        return false;
    } else if (!depositCertificate.equals(other.depositCertificate))
      return false;
    if (downloadDate == null) {
      if (other.downloadDate != null)
        return false;
    } else if (!downloadDate.equals(other.downloadDate))
      return false;
    if (driverName == null) {
      if (other.driverName != null)
        return false;
    } else if (!driverName.equals(other.driverName))
      return false;
    if (grossWeight != other.grossWeight)
      return false;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    if (imgDir == null) {
      if (other.imgDir != null)
        return false;
    } else if (!imgDir.equals(other.imgDir))
      return false;
    if (incomeNo != other.incomeNo)
      return false;
    if (modificationDate == null) {
      if (other.modificationDate != null)
        return false;
    } else if (!modificationDate.equals(other.modificationDate))
      return false;
    if (obs == null) {
      if (other.obs != null)
        return false;
    } else if (!obs.equals(other.obs))
      return false;
    if (origin == null) {
      if (other.origin != null)
        return false;
    } else if (!origin.equals(other.origin))
      return false;
    if (receiver == null) {
      if (other.receiver != null)
        return false;
    } else if (!receiver.equals(other.receiver))
      return false;
    if (trailerPatent == null) {
      if (other.trailerPatent != null)
        return false;
    } else if (!trailerPatent.equals(other.trailerPatent))
      return false;
    if (transporter == null) {
      if (other.transporter != null)
        return false;
    } else if (!transporter.equals(other.transporter))
      return false;
    if (truckPatent == null) {
      if (other.truckPatent != null)
        return false;
    } else if (!truckPatent.equals(other.truckPatent))
      return false;
    if (truckWeight != other.truckWeight)
      return false;
    if (waybill == null) {
      if (other.waybill != null)
        return false;
    } else if (!waybill.equals(other.waybill))
      return false;
    if (waybillOwner == null) {
      if (other.waybillOwner != null)
        return false;
    } else if (!waybillOwner.equals(other.waybillOwner))
      return false;
    return true;
  }
  
}
