package Controller.Profile;

import Model.Database.DBUtils;
import Model.Database.EmployeeSqlStatement;

public class UpdateProfileController {
    private DBUtils dbUtils;
    private EmployeeSqlStatement employeeSqlStatement;
    private int employee_id;
    private String[] updateProfile;

    public UpdateProfileController(int employee_id, String[] updateProfile){
        dbUtils = new DBUtils();
        employeeSqlStatement = new EmployeeSqlStatement();
        this.employee_id = employee_id;
        this.updateProfile = updateProfile;
    }

    public void updateProfile(){
        if (updateProfile[0] != null && updateProfile[0].length() > 0)
            employeeSqlStatement.updateName(employee_id, updateProfile[0]);
        if (updateProfile[1] != null && updateProfile[1].length() > 0)
            employeeSqlStatement.updatePhoneNumber(employee_id, updateProfile[1]);
        if (updateProfile[2] != null && updateProfile[2].length() > 0)
            employeeSqlStatement.updateAddress(employee_id, updateProfile[2]);
        if (updateProfile[3] != null && updateProfile[3].length() > 0)
            employeeSqlStatement.updateDob(employee_id, updateProfile[3]);
    }
}
