package com.enano.report;

import static com.enano.cloudbean.utils.GeneralConstants.MEASURMENT_UNITS;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class BuildExcelFile {
  
  protected static final Logger LOGGER = LogManager.getLogger(BuildExcelFile.class);
  protected static final String TITLE_STYLE = "title";
  protected static final String HEADER_STYLE = "header";
  protected static final String CELL_STYLE = "cell";
  protected static final String TOTALS_STYLE = "total";
  
  protected Map<String, CellStyle> styles;
  private Workbook wb;
  protected Sheet sheet;
  protected Row currentRow;
  private DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
  
  BuildExcelFile() {
    LOGGER.info("Creating workbook");
    wb = new XSSFWorkbook();
    styles = createStyles(wb);
  }
  
  protected void createSheet(String name) {
    LOGGER.info("Creating Sheet");
    sheet = wb.createSheet(name);
    PrintSetup printSetup = sheet.getPrintSetup();
    printSetup.setLandscape(true);
    sheet.setFitToPage(true);
    sheet.setHorizontallyCenter(true);
  }

  protected void createTitleRow(String title, String range) {
    LOGGER.info("Creating Title.");
    Row titleRow = sheet.createRow(0);
    titleRow.setHeightInPoints(45);
    Cell titleCell = titleRow.createCell(0);
    titleCell.setCellValue(title);
    titleCell.setCellStyle(styles.get(TITLE_STYLE));
    sheet.addMergedRegion(CellRangeAddress.valueOf(range));
  }
  
  protected void createHeadersRow(String[] columnsHeader) {
    LOGGER.info("Creating Header.");
    Row headerRow = sheet.createRow(1);
    headerRow.setHeightInPoints(40);
    Cell headerCell;
    for (int i = 0; i < columnsHeader.length; i++) {
      headerCell = headerRow.createCell(i);
      headerCell.setCellValue(columnsHeader[i]);
      headerCell.setCellStyle(styles.get(HEADER_STYLE));
    }
  }

  protected void writeCell(int columnNumber, String style, Object value) {
    Cell cell = currentRow.createCell(columnNumber);
    if (value instanceof Double) {
      cell.setCellValue((double) value);
    } else if (value instanceof Integer || value instanceof Long) {
      cell.setCellType(CellType.NUMERIC);
      cell.setCellValue((int) value);
    } else if (value instanceof Date) {
      cell.setCellType(CellType.STRING);
      cell.setCellValue(dateFormat.format(value));
    } else{
      if (value == null) {
        cell.setCellValue("");
      } else {
        cell.setCellValue((String.valueOf(value)));
      }
    }
    cell.setCellStyle(styles.get(style));
  }

  protected void setColumnsWidth(Integer[] width) {
    LOGGER.info("Set columns width");
    for (int i = 0; i < width.length; i ++) {
      sheet.setColumnWidth(i, width[i]*256);
    }
  }
  
  public byte[] getReport() throws IOException {
    LOGGER.info("Writing Bytes");
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    wb.write(out);
    wb.close();
    return out.toByteArray();
  }
  
  protected String getMeasurmentUnitName(int measurmentUnitId) {
    return MEASURMENT_UNITS.get(measurmentUnitId).getName();
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
