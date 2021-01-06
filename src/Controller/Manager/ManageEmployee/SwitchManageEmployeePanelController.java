package Controller.Manager.ManageEmployee;

import Model.Database.DBUtils;
import Model.Database.EmployeeSqlStatement;
import View.Manager.ManageEmployeePanel;
import View.Employee.EmployeeFrame;
import View.Manager.ManagerFrame;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SwitchManageEmployeePanelController {
    private DBUtils database = new DBUtils();
    private ManagerFrame managerFrame;

    public SwitchManageEmployeePanelController(ManagerFrame managerFrame){
        if (managerFrame == null){
            throw new NullPointerException("Frame is null");
        }
        this.managerFrame = managerFrame;
    }

    private Object[][] getEmployeeSchedule() {
        EmployeeSqlStatement employeeSqlStatement = new EmployeeSqlStatement();
        String statement = "SELECT COUNT(id) FROM employee;";
        ResultSet countEmployee = database.retrieveData(statement);
        int numberOfEmployee = 0;

        try {
            if (countEmployee.next()) {
                numberOfEmployee = countEmployee.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Object[][] employees = new Object[numberOfEmployee][6];
        Object[] employeeID = new EmployeeSqlStatement().getEmployeeId();

        for (int i = 0; i < numberOfEmployee; i++) {
            employees[i] = employeeSqlStatement.getEmployee((int) employeeID[i]);
            employees[i][5] = "\u00D8";
        }

        return employees;
    }

    public JPanel getManageEmployeePanel(){
        return new ManageEmployeePanel(managerFrame, getEmployeeSchedule());
    }
}
