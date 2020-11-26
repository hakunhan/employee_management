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

    public void deleteAccount(int employee_id){
        String mysqlStatement = "DELETE FROM account WHERE employee_id = ?";
        int[] indexes = {1};
        String[] values = {Integer.toString(employee_id)};
        dbUtils.deleteData(mysqlStatement,indexes,values);
    }
}
