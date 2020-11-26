package Controller.Profile;

import Model.Database.DBUtils;
import Model.Database.EmployeeSqlStatement;

public class GetProfileController {
    private DBUtils dbUtils;
    private EmployeeSqlStatement employeeSqlStatement;
    private int employeeId;

    public GetProfileController(int employeeId){
        dbUtils = new DBUtils();
        employeeSqlStatement = new EmployeeSqlStatement();
        this.employeeId = employeeId;
    }

    public String[] getEmployeeInfo(){
        Object[] employeeInfo = employeeSqlStatement.getEmployee(employeeId);
        String[] result = new String[4];

        System.arraycopy(employeeInfo, 1, result, 0, result.length);
        return result;
    }
}
