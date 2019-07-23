package com.enano.cloudbean.dtos;

public class WithdrawItemDto {
  private Long id;
  private Float withdrawAmt;
  
  public WithdrawItemDto() {
  }

  public WithdrawItemDto(Long id, Float withdrawAmt) {
    this.id = id;
    this.withdrawAmt = withdrawAmt;
  }
  
  public Long getId() {
    return (id != null && id > 0) ? id : null;
  }
  public void setId(Long id) {
    this.id = id;
  }
  public Float getWithdrawAmt() {
    return withdrawAmt;
  }
  public void setWithdrawAmt(Float withdrawAmt) {
    this.withdrawAmt = withdrawAmt;
  }

}