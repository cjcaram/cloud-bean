package com.enano.report;

import java.util.List;
import java.util.Set;

import com.enano.cloudbean.entities.AgrochemicalApplication;
import com.enano.cloudbean.entities.Application;

public class AgrochemicalApplicationCostReport extends BuildExcelFile {

  private static final String[] COLUMNS_HEADER = {"Número", "Fecha", "Tipo", "Precio de Aplicación", "Lote", "Detalles", "Costos por ha.",  "Cantidad de Hectareas", "Costo total"};
  private static final Integer[] COLUMNS_WIDTH = {9, 15, 30, 10, 30, 30, 12, 12, 15};
  
  public AgrochemicalApplicationCostReport() {
    super();
    createSheet("Costos");
  }
  
  public void buildExcel(List<Application> applications) {
    createTitleRow("Costos de Aplicación de Agroquimicos", "$A$1:$I$1");
    createHeadersRow(COLUMNS_HEADER);
    createCellsWithInfo(applications);
    setColumnsWidth(COLUMNS_WIDTH);
  }
  
  private void createCellsWithInfo(List<Application> applications) {
    LOGGER.info("Writing details.");
    int rownum = 2;
    int col;
    for (Application app : applications) {
      col = 0;
      currentRow = sheet.createRow(rownum++);
      Set<AgrochemicalApplication> items = app.getItems();
      double applicationPriceByType = app.getApplicationType().getPricePerHa();
      double applicationCost = calculateApplicationCostPerHa(applicationPriceByType, items);
      writeCell(col++, CELL_STYLE, app.getApplicationNumber());
      writeCell(col++, CELL_STYLE, app.getApplicationDate());
      writeCell(col++, CELL_STYLE, app.getApplicationType().getName());
      writeCell(col++, CELL_STYLE, applicationPriceByType);
      writeCell(col++, CELL_STYLE, app.getLandBatch().getName());
      writeCell(col++, CELL_STYLE, getItemDetails(items));
      writeCell(col++, TOTALS_STYLE, applicationCost);
      writeCell(col++, CELL_STYLE, app.getHaAmount());
      writeCell(col++, TOTALS_STYLE, applicationCost * app.getHaAmount());
    }
  }
  

  private double calculateApplicationCostPerHa(double pricePerHa,
      Set<AgrochemicalApplication> items) {
    double result = 0;
    for (AgrochemicalApplication item : items) {
      result += item.getDosage() * item.getAgrochemical().getPrice();
    }
    return result + pricePerHa;
  }

  private String getItemDetails(Set<AgrochemicalApplication> items) {
    String itemDetails = "";
    for (AgrochemicalApplication item : items) {
      itemDetails += item.getAgrochemical().getName() + ": " + item.getDosage() + System.lineSeparator();
    }
    return itemDetails;
  }
}
