package Controller.Manager.ManageEmployee;

import Model.Database.DBUtils;
import Model.Database.EmployeeSqlStatement;
import View.Manager.ManageEmployeeSchedulePanel;
import View.Manager.ManagerFrame;
import utils.NotPossibleException;

public class AddEmployeeController {
    private ManageEmployeeSchedulePanel manageEmployeeSchedulePanel;
    private DBUtils database = new DBUtils();
    private ManagerFrame managerFrame;
    private EmployeeSqlStatement employeeSqlStatement = new EmployeeSqlStatement();
    private String[] employee_info;

    public AddEmployeeController(ManagerFrame managerFrame, String[] employee_info){
        this.managerFrame = managerFrame;
        this.employee_info = employee_info;
    }

    private int checkAvailableId(){
        Object[] currentEmployeeId = employeeSqlStatement.getEmployeeId();
        int availableId = 0;

        for (int i = 0; i < currentEmployeeId.length - 1; i++){
            if(Integer.parseInt((String) currentEmployeeId[i]) + 1 != Integer.parseInt((String) currentEmployeeId[i+1])){
                availableId = i+1;
                return availableId;
            }
        }

        availableId = Integer.parseInt((String) currentEmployeeId[currentEmployeeId.length-1]) + 1;
        return availableId;
    }
}
