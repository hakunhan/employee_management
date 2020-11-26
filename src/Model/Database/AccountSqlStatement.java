package Model.Database;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountSqlStatement {
    private DBUtils dbUtils;

    public AccountSqlStatement(){
        this.dbUtils = new DBUtils();
    }

    public void insertIntoAccount(int employee_id, String[] account_info){
        String mysqlStatement = "INSERT INTO ACCOUNT VALUES (?,?,?);";
        int[] indexes = {1,2,3};
        String[] values = new String[3];
        values[0] = Integer.toString(employee_id);

        System.arraycopy(account_info, 0, values, 1, values.length - 1);
        dbUtils.insertData(mysqlStatement, indexes,values);
    }

    public void updatePassword(int employee_id, String newPassword){
        String mysqlStatement = "UPDATE ACCOUNT SET PASSWORD = ? WHERE employee_id = ?;";
        int[] indexes = {1,2};
        String[] values = {Integer.toString(employee_id), newPassword};

        dbUtils.updateData(mysqlStatement, indexes,values);
    }

    public void deleteAccount(int employee_id){
        String mysqlStatement = "DELETE FROM account WHERE employee_id = ?";
        int[] indexes = {1};
        String[] values = {Integer.toString(employee_id)};
        dbUtils.deleteData(mysqlStatement,indexes,values);
    }

    public int getIdAccount(String username, String password){
       String mysqlStatement = "SELECT employee_id FROM account WHERE username = ? AND password = ?;";
       int[] indexes = {1,2};
       String[] values = {username, password};
       int result = 0;

       ResultSet id = dbUtils.selectData(mysqlStatement, indexes, values);
       try{
           while(id.next()){
               result = id.getInt(1);
           }
       } catch (SQLException throwables) {
           throwables.printStackTrace();
       }

       return result;
    }

    public String getPassword(int employeeId){
        String mysqlStatement = "SELECT password FROM account WHERE employee_id = ?";
        int[] indexes = {1};
        String[] values = {Integer.toString(employeeId)};
        String result = null;

        ResultSet id = dbUtils.selectData(mysqlStatement, indexes, values);
        try{
            while(id.next()){
                result = id.getString(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return result;
    }
}
