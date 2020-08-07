package com.enano.cloudbean.dtos;

public class PaginationInfo {

  private int rowsPerPage = 25;
  private int totalItems = 0;
  private int page = 0;
  
  public PaginationInfo() {}
  
  public PaginationInfo(int rowsPerPage, int totalItems, int page) {
    this.rowsPerPage = rowsPerPage;
    this.totalItems = totalItems;
    this.page = page;
  }

  public int getRowsPerPage() {
    return rowsPerPage;
  }

  public void setRowsPerPage(int rowsPerPage) {
    this.rowsPerPage = rowsPerPage;
  }

  public int getTotalItems() {
    return totalItems;
  }

  public void setTotalItems(int totalItems) {
    this.totalItems = totalItems;
  }

  public int getPage() {
    return page;
  }

  public void setPage(int page) {
    this.page = page;
  }
}
