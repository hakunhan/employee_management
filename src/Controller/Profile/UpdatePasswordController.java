package Controller.Profile;

import Model.Database.AccountSqlStatement;
import Model.Database.DBUtils;

public class UpdatePasswordController {
    private DBUtils dbUtils;
    private AccountSqlStatement accountSqlStatement;
    private int employee_id;
    private String inputOldPassword;
    private String inputNewPassword;

    public UpdatePasswordController(int employee_id, String inputOldPassword, String inputNewPassword){
        dbUtils = new DBUtils();
        accountSqlStatement = new AccountSqlStatement();
        this.employee_id = employee_id;
        this.inputOldPassword = inputOldPassword;
        this.inputNewPassword = inputNewPassword;
    }

    public UpdatePasswordController(int employee_id, String inputNewPassword){
        dbUtils = new DBUtils();
        accountSqlStatement = new AccountSqlStatement();
        this.employee_id = employee_id;
        this.inputNewPassword = inputNewPassword;
    }

    public boolean checkOldPassword(){
        String dbPassword = accountSqlStatement.getPassword(employee_id);
        return dbPassword.equals(inputOldPassword);
    }

    public boolean updatePassword(){
        if (inputNewPassword == null){
            return false;
        }
        accountSqlStatement.updatePassword(employee_id, inputNewPassword);
        return true;
    }
}
