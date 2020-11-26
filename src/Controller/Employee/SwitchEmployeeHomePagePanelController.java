package Controller.Employee;

import Model.Database.DBUtils;
import View.Employee.EmployeeFrame;
import View.Employee.EmployeeHomePagePanel;

import javax.swing.*;

public class SwitchEmployeeHomePagePanelController {
    private DBUtils database = new DBUtils();
    private EmployeeFrame frame;
    public SwitchEmployeeHomePagePanelController(EmployeeFrame frame){
        if (frame == null){
            throw new NullPointerException("Frame is null");
        }
        this.frame = frame;
    }

    public JPanel getManagerHomePagePanel(){
        return new EmployeeHomePagePanel(frame);
    }
}
