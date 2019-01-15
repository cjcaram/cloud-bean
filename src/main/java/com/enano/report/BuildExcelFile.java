package com.enano.report;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.PrintSetup;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.enano.cloudbean.entities.AgrochemicalApplication;
import com.enano.cloudbean.entities.Application;

public class BuildExcelFile {
  
  private static final Logger LOGGER = LogManager.getLogger(BuildExcelFile.class);
  private static final String TITLE_STYLE = "title";
  private static final String HEADER_STYLE = "header";
  private static final String CELL_STYLE = "cell";
  private static final String TOTALS_STYLE = "total";
  private static final String[] COLUMNS_HEADER = {"Número", "Fecha", "Tipo", "Precio de Aplicación", "Lote", "Detalles", "Costos por ha.",  "Cantidad de Hectareas", "Costo total"};
  
  private Map<String, CellStyle> styles;
  private Workbook wb;
  private Sheet sheet;
  private Row currentRow;
  private DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
  
  public BuildExcelFile() {
    LOGGER.info("Creating workbook");
    wb = new XSSFWorkbook();
    styles = createStyles(wb);
    createSheet();
  }
  
  private void createSheet() {
    LOGGER.info("Creating Sheet");
    sheet = wb.createSheet("Costos");
    PrintSetup printSetup = sheet.getPrintSetup();
    printSetup.setLandscape(true);
    sheet.setFitToPage(true);
    sheet.setHorizontallyCenter(true);
  }

  public void buildExcel(List<Application> applications) {
    createTitleRow();
    createHeadersRow();
    createCellsWithInfo(applications);
    setColumnsWidth();
  }
  
  private void createTitleRow() {
    LOGGER.info("Creating Title.");
    Row titleRow = sheet.createRow(0);
    titleRow.setHeightInPoints(45);
    Cell titleCell = titleRow.createCell(0);
    titleCell.setCellValue("Costos de Aplicación de Agroquimicos");
    titleCell.setCellStyle(styles.get(TITLE_STYLE));
    sheet.addMergedRegion(CellRangeAddress.valueOf("$A$1:$I$1"));
  }
  
  private void createHeadersRow() {
    LOGGER.info("Creating Header.");
    Row headerRow = sheet.createRow(1);
    headerRow.setHeightInPoints(40);
    Cell headerCell;
    for (int i = 0; i < COLUMNS_HEADER.length; i++) {
      headerCell = headerRow.createCell(i);
      headerCell.setCellValue(COLUMNS_HEADER[i]);
      headerCell.setCellStyle(styles.get(HEADER_STYLE));
    }
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

  private void writeCell(int columnNumber, String style, Object value) {
    Cell cell = currentRow.createCell(columnNumber);
    if (value instanceof Double) {
      cell.setCellValue((double) value);
    } else if (value instanceof Integer) {
      cell.setCellType(CellType.NUMERIC);
      cell.setCellValue((int) value);
    } else if (value instanceof Date) {
      cell.setCellType(CellType.STRING);
      cell.setCellValue(formatter.format(value));
    } else if (value instanceof String){
      cell.setCellValue((String) value);
    } else {
      cell.setCellValue((RichTextString) value);
    }
    cell.setCellStyle(styles.get(style));
  }

  private void setColumnsWidth() {
    LOGGER.info("Set columns width");
    sheet.setColumnWidth(0, 9*256);
    sheet.setColumnWidth(1, 15*256);
    sheet.setColumnWidth(2, 30*256);
    sheet.setColumnWidth(3, 10*256);
    sheet.setColumnWidth(4, 30*256);
    sheet.setColumnWidth(5, 30*256);
    sheet.setColumnWidth(6, 12*256);
    sheet.setColumnWidth(7, 12*256);
    sheet.setColumnWidth(8, 15*256);
  }
  
  public byte[] getReport() throws IOException {
    LOGGER.info("Writing Bytes");
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    wb.write(out);
    wb.close();
    return out.toByteArray();
  }
  
  private static Map<String, CellStyle> createStyles(Workbook wb){
     Map<String, CellStyle> styles = new HashMap<>();
     CellStyle style;
     Font titleFont = wb.createFont();
     titleFont.setFontHeightInPoints((short)18);
     titleFont.setBold(true);
     style = wb.createCellStyle();
     setHorizontalAndVerticalAligmentToCenter(style);
     style.setFont(titleFont);
     styles.put(TITLE_STYLE, style);

     Font monthFont = wb.createFont();
     monthFont.setFontHeightInPoints((short)11);
     monthFont.setColor(IndexedColors.WHITE.getIndex());
     style = wb.createCellStyle();
     setHorizontalAndVerticalAligmentToCenter(style);
     style.setFillForegroundColor(IndexedColors.GREY_50_PERCENT.getIndex());
     style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
     style.setFont(monthFont);
     style.setWrapText(true);
     styles.put(HEADER_STYLE, style);

     style = wb.createCellStyle();
     setHorizontalAndVerticalAligmentToCenter(style);
     style.setWrapText(true);
     setAroundBordersBlack(style);
     styles.put(CELL_STYLE, style);

     style = wb.createCellStyle();
     setHorizontalAndVerticalAligmentToCenter(style);
     style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
     style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
     style.setDataFormat(wb.createDataFormat().getFormat("0.00"));
     setAroundBordersBlack(style);
     styles.put(TOTALS_STYLE, style);

     return styles;
 }

  private static void setHorizontalAndVerticalAligmentToCenter(CellStyle style) {
    style.setAlignment(HorizontalAlignment.CENTER);
     style.setVerticalAlignment(VerticalAlignment.CENTER);
  }

  private static void setAroundBordersBlack(CellStyle style) {
    style.setBorderRight(BorderStyle.THIN);
     style.setRightBorderColor(IndexedColors.BLACK.getIndex());
     style.setBorderLeft(BorderStyle.THIN);
     style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
     style.setBorderTop(BorderStyle.THIN);
     style.setTopBorderColor(IndexedColors.BLACK.getIndex());
     style.setBorderBottom(BorderStyle.THIN);
     style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
  }
  
}
