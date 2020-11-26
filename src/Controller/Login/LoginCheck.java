package Controller.Login;

import Controller.Employee.SwitchEmployeeHomePagePanelController;
import Controller.Manager.SwitchManagerHomePagePanelController;
import Model.Database.DBUtils;
import Model.Database.AccountSqlStatement;
import View.Login.Login;
import View.Manager.ManagerFrame;
import View.Employee.EmployeeFrame;
import utils.NotPossibleException;

import javax.swing.*;

public class LoginCheck {
    private DBUtils dbUtils;
    private AccountSqlStatement accountSqlStatement;
    private Login loginFrame;
    private String loginUsername;
    private String loginPassword;
    private int employee_id;

    public LoginCheck(String loginUsername, String loginPassword, Login loginFrame){
        this.loginFrame = loginFrame;
        this.loginUsername = loginUsername;
        this.loginPassword = loginPassword;
        dbUtils = new DBUtils();
        accountSqlStatement = new AccountSqlStatement();
    }

    private int checkRole(){
        int _employee_id = accountSqlStatement.getIdAccount(loginUsername,loginPassword);
        if (_employee_id == 0){
            JOptionPane.showMessageDialog(loginFrame, "Wrong username/password!");
            return -1;
        }else
            JOptionPane.showMessageDialog(loginFrame, "Successfully login!");
        this.employee_id = _employee_id;

        if(employee_id != 111){
            return 0;
        }
        else if(employee_id == 111){
            return 1;
        }
        else if(employee_id == 999){
            return 2;
        }

        return -1;
    }

    public JFrame getFrame(){
        int result = checkRole();
        switch (result){
            case 0:
                EmployeeFrame employeeFrame = new EmployeeFrame();
                employeeFrame.setEmployeeId(employee_id);
                SwitchEmployeeHomePagePanelController switchEmployeeHomePagePanelController = new SwitchEmployeeHomePagePanelController(employeeFrame);
                employeeFrame.setJPanel(switchEmployeeHomePagePanelController.getManagerHomePagePanel());
                return employeeFrame;
            case 1:
                ManagerFrame managerFrame = new ManagerFrame();
                managerFrame.setEmployee_id(employee_id);
                SwitchManagerHomePagePanelController switchManagerHomePagePanelController = new SwitchManagerHomePagePanelController(managerFrame);
                managerFrame.setJPanel(switchManagerHomePagePanelController.getManagerHomePagePanel());
                return managerFrame;
            case 2:
                break;
            case -1:
                break;
            default:
                throw new NotPossibleException("Oof");
        }

        throw new NotPossibleException("Wat a noob!");
    }
}
