package com.enano.report;

import java.util.List;

import com.enano.cloudbean.entities.Agrochemical;

public class AgrochemicalStockReport extends BuildExcelFile {
  
  private static final String[] COLUMNS_HEADER = {"Nombre", "Principio Activo", "Concentración (%)", 
      "Cantidad en Stock", "Unidad de Medida", "Precio Unitario", "Fecha de Compra", "Fecha de Vencimiento", 
      "Factura", "Observaciones",  "Laboratorio", "Lote de Fabricación"};
  private static final Integer[] COLUMNS_WIDTH = {30, 25, 17, 17, 10, 10, 15, 15, 12, 45, 12, 12};
  
  public AgrochemicalStockReport() {
    super();
    createSheet("Stock");
  }
  
  public void buildExcel(List<Agrochemical> agrochemicals) {
    createTitleRow("Stock de Agroquimicos", "$A$1:$L$1");
    createHeadersRow(COLUMNS_HEADER);
    createCellsWithInfo(agrochemicals);
    setColumnsWidth(COLUMNS_WIDTH);
  }
  
  private void createCellsWithInfo(List<Agrochemical> agrochemicals) {
    int rownum = 2;
    int col;
    for (Agrochemical item : agrochemicals) {
      col = 0;
      currentRow = sheet.createRow(rownum++);
      writeCell(col++, CELL_STYLE, item.getName());
      writeCell(col++, CELL_STYLE, item.getActivePrincipie());
      writeCell(col++, CELL_STYLE, item.getPrincipeActiveConcentration());
      writeCell(col++, TOTALS_STYLE, item.getAmount());
      writeCell(col++, CELL_STYLE, getMeasurmentUnitName(item.getMeasurementUnit()));
      writeCell(col++, TOTALS_STYLE, item.getPrice());
      writeCell(col++, CELL_STYLE, item.getPurchaseDate());
      writeCell(col++, CELL_STYLE, item.getExpirationDate());
      writeCell(col++, CELL_STYLE, item.getBill());
      writeCell(col++, CELL_STYLE, item.getNota());
      writeCell(col++, CELL_STYLE, item.getLaboratory());
      writeCell(col++, CELL_STYLE, item.getBatchCode());
    }
  }
}
