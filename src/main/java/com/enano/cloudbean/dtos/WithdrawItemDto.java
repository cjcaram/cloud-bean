package com.enano.cloudbean.dtos;

public class WithdrawItemDto {
  private Long id;
  private int withdrawAmt;
  
  public WithdrawItemDto() {
  }

  public WithdrawItemDto(Long id, int withdrawAmt) {
    this.id = id;
    this.withdrawAmt = withdrawAmt;
  }
  
  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }
  public int getWithdrawAmt() {
    return withdrawAmt;
  }
  public void setWithdrawAmt(int withdrawAmt) {
    this.withdrawAmt = withdrawAmt;
  }

}