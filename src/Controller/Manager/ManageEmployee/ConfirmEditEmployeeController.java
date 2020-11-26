package Controller.Manager.ManageEmployee;

import Controller.Manager.SwitchHomePagePanelController;
import Model.Database.DBUtils;
import Model.Database.EmployeeSqlStatement;
import View.Employee.EmployeeFrame;
import View.Manager.ManagerFrame;

import javax.swing.*;

public class ConfirmEditEmployeeController {
    private  DBUtils database = new DBUtils();
    private EmployeeSqlStatement employeeSqlStatement = new EmployeeSqlStatement();
    private ManagerFrame managerFrame;
    private Object[][] employees;

    public ConfirmEditEmployeeController(ManagerFrame managerFrame, Object[][] employees){
        this.employees = employees;
        this.managerFrame = managerFrame;
    }

    private Object[][] getTheChange(Object[][] employees){
        Object[][] employeesChange = new Object[employees.length][5];

        for (int i = 0; i < employees.length; i++){
            employeesChange[i][0] = employees[i][0];
        }

        for (int i = 0; i < employees.length; i++){
            for (int j = 0; j < 5; j++){
                if (this.employees[i][j] != employees[i][j])
                    employeesChange[i][j] = employees[i][j];
            }
        }

        return employeesChange;
    }

    private boolean updateChange(Object[][] employeeSchedule){
        Object[][] changes = getTheChange(employeeSchedule);

        for (Object[] change : changes) {
            for (int j = 1; j < 5; j++) {
                if (change[j] == null) {
                    continue;
                }
                switch (j) {
                    case 1:
                        employeeSqlStatement.updateName(Integer.parseInt((String) change[0]), (String) change[j]);
                        break;
                    case 2:
                        employeeSqlStatement.updatePhoneNumber(Integer.parseInt((String) change[0]), (String) change[j]);
                        break;
                    case 3:
                        employeeSqlStatement.updateAddress(Integer.parseInt((String) change[0]), (String) change[j]);
                        break;
                    case 4:
                        employeeSqlStatement.updateDob(Integer.parseInt((String) change[0]), (String) change[j]);
                        break;
                }
            }
        }

        return true;
    }

    public JPanel updateAndReturnHomePage(Object[][] employees){
        updateChange(employees);
        SwitchHomePagePanelController switchHomePagePanelController = new SwitchHomePagePanelController(managerFrame);
        return switchHomePagePanelController.getManagerHomePagePanel();
    }
}
