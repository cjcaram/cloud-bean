package com.enano.report;

import java.util.List;

import com.enano.cloudbean.entities.RemoveAgrochemical;

public class AgrochemicalWithdrawReport extends BuildExcelFile{
  
  private static final String[] COLUMNS_HEADER = {"Orden de Trabajo", "Agroquimico", "Principio Activo", 
      "Cantidad Retirada", "Unidad de Medida", "Fecha de Retiro"};
  private static final Integer[] COLUMNS_WIDTH = {15, 25, 25, 12, 10, 15};
  
  public AgrochemicalWithdrawReport() {
    super();
    createSheet("Retiros");
  }
  
  public void buildExcel(List<RemoveAgrochemical> withdrawedAgrochemicals) {
    createTitleRow("Historial de Retiros", "$A$1:$F$1");
    createHeadersRow(COLUMNS_HEADER);
    createCellsWithInfo(withdrawedAgrochemicals);
    setColumnsWidth(COLUMNS_WIDTH);
  }
  
  private void createCellsWithInfo(List<RemoveAgrochemical> withdrawedAgrochemicals) {
    int rownum = 2;
    int col;
    for (RemoveAgrochemical item : withdrawedAgrochemicals) {
      col = 0;
      currentRow = sheet.createRow(rownum++);
      writeCell(col++, CELL_STYLE, item.getWorkOrderId());
      writeCell(col++, CELL_STYLE, item.getAgrochemical().getName());
      writeCell(col++, CELL_STYLE, item.getAgrochemical().getActivePrincipie());
      writeCell(col++, TOTALS_STYLE, item.getAmount());
      writeCell(col++, CELL_STYLE, getMeasurmentUnitName(item.getAgrochemical().getMeasurementUnit()));
      writeCell(col++, CELL_STYLE, item.getDate());
    }
  }
}
