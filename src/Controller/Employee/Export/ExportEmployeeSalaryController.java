package Controller.Employee.Export;

import Controller.Manager.HourlyRate.HourlyRateController;
import Model.Database.DBUtils;
import Model.Database.SalarySqlStatement;
import Model.Database.ScheduleSqlStatement;
import Model.ExcelTable.EmployeeSalaryExcelPrinter;
import Model.ExcelTable.ReadEmployeeExcelFile;

import java.io.IOException;

public class ExportEmployeeSalaryController {
    private DBUtils dbUtils;
    private ScheduleSqlStatement scheduleSqlStatement;
    private SalarySqlStatement salarySqlStatement;
    private int employee_id;

    public ExportEmployeeSalaryController(int employee_id){
        dbUtils = new DBUtils();
        salarySqlStatement = new SalarySqlStatement();
        scheduleSqlStatement = new ScheduleSqlStatement();
        this.employee_id = employee_id;
    }

    private String getEmployeeName(){
        return scheduleSqlStatement.getEmployeeName(employee_id);
    }

    public void exportEmployeeSalary(){
        ReadEmployeeExcelFile readEmployeeExcelFile = new ReadEmployeeExcelFile();
        HourlyRateController hourlyRateController = new HourlyRateController();
        float hourlyRate = hourlyRateController.getHourlyRate();

        try{
            EmployeeSalaryExcelPrinter employeeSalaryExcelPrinter = new EmployeeSalaryExcelPrinter(getEmployeeName(), readEmployeeExcelFile);
            employeeSalaryExcelPrinter.printSalaryTable(hourlyRate);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
