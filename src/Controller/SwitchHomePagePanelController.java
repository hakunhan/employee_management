package Controller;

import Model.Database.DBUtils;
import View.Manager.ManagerFrame;
import View.Manager.ManagerHomePagePanel;

import javax.swing.*;

public class SwitchHomePagePanelController {
    private JPanel managerHomePagePanel;
    private DBUtils database = new DBUtils();
    private ManagerFrame frame;
    public SwitchHomePagePanelController(ManagerFrame frame){
        if (frame == null){
            throw new NullPointerException("Frame is null");
        }
        this.frame = frame;
    }

    public JPanel getManagerHomePagePanel(){
        return new ManagerHomePagePanel(frame);
    }
}
