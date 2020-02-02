package com.enano.cloudbean.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mercaderia_stock_salida")
public class CommodityStockOutcome {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  @Column(name="mercaderia_stock_id")
  private Long commodityStockId;
  
  @Column(name="salida_id")
  private Long outcomeId;
  
  public CommodityStockOutcome() {}

}
