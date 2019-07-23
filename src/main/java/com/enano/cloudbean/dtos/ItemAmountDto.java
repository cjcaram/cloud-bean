package com.enano.cloudbean.dtos;

public class ItemAmountDto {
  
  private Long id;
  private Float amount;
  
  public ItemAmountDto() {
  }
  
  public ItemAmountDto(Long id, Float amount) {
    this.id = id;
    this.amount = amount;
  }

  public Long getId() {
    return (id != null && id > 0) ? id : null;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Float getAmount() {
    return amount;
  }

  public void setAmount(Float amount) {
    this.amount = amount;
  }
  
  

}
