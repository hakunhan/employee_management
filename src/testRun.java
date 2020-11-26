import Controller.Manager.SwitchHomePagePanelController;
import View.Employee.EmployeeFrame;

import javax.swing.*;

public class testRun extends JFrame {
    public static void main(String[] args){
        EmployeeFrame frame = new EmployeeFrame();
        frame.setJPanel(new SwitchHomePagePanelController(frame).getManagerHomePagePanel());
    }
}
