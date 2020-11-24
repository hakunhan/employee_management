package Model.Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeSqlStatement {
    private DBUtils dbUtils;

    public EmployeeSqlStatement(){
        this.dbUtils = new DBUtils();
    }

    public Object[] getEmployeeId(){
        String sqlStatement = "SELECT id FROM employee;";
        ArrayList<Integer> result = new ArrayList<>();
        ResultSet employee_id = dbUtils.retrieveData(sqlStatement);

        try{
            while(employee_id.next()){
                result.add(employee_id.getInt(1));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return result.toArray();
    }

    public Object[] getEmployee(int id){
        String sqlStatement = "SELECT * FROM employee where id=?;";
        int[] indexes = {1};
        String[] values = {Integer.toString(id)};
        Object[] result = new Object[5];

        ResultSet employee = dbUtils.selectData(sqlStatement, indexes, values);
        try{
            while(employee.next()){
                for (int i = 0; i < 5; i++)
                    result[i] = employee.getString(i+1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return result;
    }
}
