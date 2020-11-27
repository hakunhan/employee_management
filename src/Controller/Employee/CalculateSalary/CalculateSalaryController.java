package Controller.Employee.CalculateSalary;

import Controller.Manager.HourlyRate.HourlyRateController;
import Model.Database.DBUtils;
import Model.Database.SalarySqlStatement;
import Model.Database.ScheduleSqlStatement;
import Model.ExcelTable.CalculateSalary;
import Model.ExcelTable.EmployeeSalaryExcelPrinter;
import Model.ExcelTable.ReadEmployeeExcelFile;

import java.io.IOException;

public class CalculateSalaryController {
    private DBUtils dbUtils;
    private ScheduleSqlStatement scheduleSqlStatement;
    private SalarySqlStatement salarySqlStatement;
    private int employee_id;

    public CalculateSalaryController(int employee_id){
        dbUtils = new DBUtils();
        salarySqlStatement = new SalarySqlStatement();
        scheduleSqlStatement = new ScheduleSqlStatement();
        this.employee_id = employee_id;
    }

    private String getEmployeeName(){
        return scheduleSqlStatement.getEmployeeName(employee_id);
    }

    public float calculateEmployeeSalary(){
        ReadEmployeeExcelFile readEmployeeExcelFile = new ReadEmployeeExcelFile();
        HourlyRateController hourlyRateController = new HourlyRateController();
        float hourlyRate = hourlyRateController.getHourlyRate();
        float salary = 0;

        try{
            CalculateSalary calculateSalary = new CalculateSalary(getEmployeeName(), readEmployeeExcelFile);
            salary = calculateSalary.calculateSalary(hourlyRate);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return salary;
    }
}
