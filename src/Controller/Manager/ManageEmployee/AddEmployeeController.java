package Controller.Manager.ManageEmployee;

import Model.Database.AccountSqlStatement;
import Model.Database.DBUtils;
import Model.Database.EmployeeSqlStatement;
import View.Manager.ManagerFrame;

import javax.swing.*;

public class AddEmployeeController {
    private DBUtils database = new DBUtils();
    private ManagerFrame managerFrame;
    private EmployeeSqlStatement employeeSqlStatement = new EmployeeSqlStatement();
    private AccountSqlStatement accountSqlStatement = new AccountSqlStatement();
    private String[] employee_info;

    public AddEmployeeController(ManagerFrame managerFrame, String[] employee_info){
        this.managerFrame = managerFrame;
        this.employee_info = employee_info;
    }

    private int checkAvailableId(){
        Object[] currentEmployeeId = employeeSqlStatement.getEmployeeId();
        int availableId = 0;

        for (int i = 0; i < currentEmployeeId.length - 1; i++){
            if( (int) currentEmployeeId[i] + 1 != (int) currentEmployeeId[i+1]){
                availableId = i+1;
                return availableId;
            }
        }

        availableId = (int) currentEmployeeId[currentEmployeeId.length-1] + 1;
        return availableId;
    }

    private void addEmployeeAndAccount(){
        String[] employeeInfo = new String[5];
        String[] employeeAccount = new String[2];
        int employeeId = checkAvailableId();
        employeeInfo[0] = Integer.toString(employeeId);
        System.arraycopy(employee_info, 2, employeeInfo, 1, employeeInfo.length-1);
        System.arraycopy(employeeInfo,1, employeeAccount, 0, employeeAccount.length);
        employeeSqlStatement.insertIntoEmployee(employeeInfo);
        accountSqlStatement.insertIntoAccount(employeeId, employeeAccount);
    }

    public JPanel updateManageEmployee(){
        addEmployeeAndAccount();
        SwitchManageEmployeePanelController switchManageEmployeePanelController = new SwitchManageEmployeePanelController(managerFrame);
        return switchManageEmployeePanelController.getManageEmployeePanel();
    }
}
