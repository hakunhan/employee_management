import Controller.Manager.SwitchHomePagePanelController;
import View.Manager.*;

import javax.swing.*;

public class testRun extends JFrame {
    public static void main(String[] args){
        ManagerFrame frame = new ManagerFrame();
        frame.setJPanel(new SwitchHomePagePanelController(frame).getManagerHomePagePanel());
    }
}
