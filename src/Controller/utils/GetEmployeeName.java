package Controller.utils;

import Model.Database.DBUtils;
import Model.Database.EmployeeSqlStatement;
public class GetEmployeeName {
    private DBUtils dbUtils;
    private EmployeeSqlStatement employeeSqlStatement;
    private int employee_id;

    public GetEmployeeName(int employee_id){
        dbUtils = new DBUtils();
        employeeSqlStatement = new EmployeeSqlStatement();
        this.employee_id = employee_id;
    }

    public String getEmployeeName(){
        return employeeSqlStatement.getEmployeeName(employee_id);
    }
}
