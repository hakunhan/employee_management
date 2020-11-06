package ExcelTable;

import java.io.*;
import java.util.Date;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class EmployeeSalaryExcelPrinter {
    private String employeeName;
    private GetTime time = new GetTime();
    private String month = time.getMonth();
    private int year = time.getYear();
    private File timetable = new File(employeeName + month + "-" + year + ".xlsx");
    private int rowNum = 0;

    /**
     *  constructor that create excel .xlsx file and set rows height and columns width
     */
    public EmployeeSalaryExcelPrinter(String employeeName) throws IOException {
        this.employeeName = employeeName;
        GetTime time = new GetTime();
        String month = time.getMonth();
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Sheet 1");
        ReadExcelFile read = new ReadExcelFile();
        int cellMergeLength = read.countEmployeeWorkDay(employeeName);

        //setting columnWidth
        sheet.setColumnWidth(1, 5600);
        sheet.setColumnWidth(2, 5600);
        sheet.setColumnWidth(3, 5600);
        sheet.setColumnWidth(4, 5600);

        this.rowNum = 0;
        int cellNum = 1;
        Row row = sheet.createRow(++rowNum);
        Cell cell_one = row.createCell(cellNum++);
        cell_one.setCellStyle(FormatCell.format(workbook,FormatCell.cellColor[6]));
        cell_one.setCellValue("NAME");
        Cell cell_two = row.createCell(cellNum++);
        cell_two.setCellStyle(FormatCell.format(workbook,FormatCell.cellColor[6]));
        cell_two.setCellValue("DAY");
        Cell cell_three = row.createCell(cellNum++);
        cell_three.setCellStyle(FormatCell.format(workbook,FormatCell.cellColor[6]));
        cell_three.setCellValue("TIME");
        Cell cell_four = row.createCell(cellNum++);
        cell_four.setCellStyle(FormatCell.format(workbook,FormatCell.cellColor[6]));
        cell_four.setCellValue("HOUR");

        sheet.addMergedRegion(new CellRangeAddress(2, 2 + cellMergeLength, 1,1));
        Row row_two = sheet.createRow(++rowNum);
        Cell mergeCell = row_two.createCell(1);
        mergeCell.setCellStyle(FormatCell.format(workbook));
        mergeCell.setCellValue(employeeName);

        sheet.setDefaultRowHeight((short) 400);
        FileOutputStream outputStream = new FileOutputStream(employeeName+ "-" + month+ "-" + year + ".xlsx");
        workbook.write(outputStream);
        outputStream.close();
    }

    public Object[][] calculateEmployeeWorkHours(Object[][] employeeWorkInMonth){
        Object[][] result = new Object[employeeWorkInMonth.length][3];
        return null;
    }

    public static void main(String[] args) throws IOException {
        EmployeeSalaryExcelPrinter printer = new EmployeeSalaryExcelPrinter("Hieu");
    }
}
