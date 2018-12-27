package com.enano.cloudbean.dtos;

import java.util.List;

public class WithdrawAgrochemicalDto {
  
  private String workOrder;
  private List<WithdrawItemDto> items;

  public WithdrawAgrochemicalDto() {}

  public WithdrawAgrochemicalDto(String workOrder, List<WithdrawItemDto> items) {
    this.workOrder = workOrder;
    this.items = items;
  }

  public String getWorkOrder() {
    return workOrder;
  }

  public void setWorkOrder(String workOrder) {
    this.workOrder = workOrder;
  }

  public List<WithdrawItemDto> getItems() {
    return items;
  }

  public void setItems(List<WithdrawItemDto> items) {
    this.items = items;
  }
}
