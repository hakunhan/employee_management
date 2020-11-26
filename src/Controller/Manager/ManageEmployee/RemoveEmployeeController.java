package Controller.Manager.ManageEmployee;

import Model.Database.AccountSqlStatement;
import Model.Database.DBUtils;
import Model.Database.EmployeeSqlStatement;
import View.Employee.EmployeeFrame;
import View.Manager.ManagerFrame;

import javax.swing.*;

public class RemoveEmployeeController {
    private JPanel manageEmployeeSchedulePanel;
    private DBUtils database = new DBUtils();
    private ManagerFrame frame;
    private int employee_id;

    public RemoveEmployeeController(ManagerFrame frame, int employee_id){
        this.frame = frame;
        this.employee_id = employee_id;
    }

    private void removeEmployee(){
        EmployeeSqlStatement employeeSqlStatement = new EmployeeSqlStatement();
        AccountSqlStatement accountSqlStatement = new AccountSqlStatement();
        accountSqlStatement.deleteAccount(employee_id);
        employeeSqlStatement.deleteEmployee(employee_id);
    }

    public JPanel updateEmployeeSchedule(){
        removeEmployee();
        SwitchManageEmployeePanelController switchManageEmployeePanelController = new SwitchManageEmployeePanelController(frame);
        return switchManageEmployeePanelController.getManageEmployeePanel();
    }
}
