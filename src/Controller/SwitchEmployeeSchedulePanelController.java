package Controller;

import Model.Database.DBUtils;
import Model.Database.ScheduleSqlStatement;
import Model.Manager;
import View.Manager.ManageEmployeeSchedulePanel;
import View.Manager.ManagerFrame;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SwitchEmployeeSchedulePanelController {
    private JPanel manageEmployeeSchedulePanel;
    private  DBUtils database = new DBUtils();
    private ManagerFrame frame;
    public SwitchEmployeeSchedulePanelController(ManagerFrame frame){
        this.frame = frame;
    }

    private Object[][] updateManageEmployeeSchedulePanel(){
        ScheduleSqlStatement scheduleSqlStatement = new ScheduleSqlStatement();
        String statement = "SELECT COUNT(employee_id) FROM schedule;";
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

    public SwitchEmployeeSchedulePanelController(){
        manageEmployeeSchedulePanel = new ManageEmployeeSchedulePanel(updateManageEmployeeSchedulePanel(), frame);
    }

    public JPanel getManageEmployeeSchedulePanel(){
        return new ManageEmployeeSchedulePanel(updateManageEmployeeSchedulePanel(), frame);
    }
}
