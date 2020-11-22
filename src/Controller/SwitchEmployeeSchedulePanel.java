package Controller;

import Model.Database.DBUtils;
import Model.Database.ScheduleSqlStatement;
import View.Manager.ManageEmployeeSchedulePanel;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SwitchEmployeeSchedulePanel {
    private JPanel manageEmployeeSchedulePanel;
    private  DBUtils database = new DBUtils();

    private Object[][] updateManageEmployeeSchedulePanel(){
        ScheduleSqlStatement scheduleSqlStatement = new ScheduleSqlStatement();
        String statement = "SELECT COUNT(id) FROM employee;";
        ResultSet countEmployee = database.retrieveData(statement);
        int numberOfEmployee = 0;

        try {
            if (countEmployee.next()){
                numberOfEmployee = countEmployee.getInt(1);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        Object[][] employeeSchedules = new Object[numberOfEmployee][8];

        for (int i = 0; i < numberOfEmployee; i++){
            employeeSchedules[i] = scheduleSqlStatement.getScheduleEmployee(i+1);
        }

        return employeeSchedules;
    }

    public SwitchEmployeeSchedulePanel(){
        manageEmployeeSchedulePanel = new ManageEmployeeSchedulePanel(updateManageEmployeeSchedulePanel());
    }

    public JPanel getManageEmployeeSchedulePanel(){
        return new ManageEmployeeSchedulePanel(updateManageEmployeeSchedulePanel());
    }
}
