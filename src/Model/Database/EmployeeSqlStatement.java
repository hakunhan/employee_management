package Model.Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeSqlStatement {
    private DBUtils dbUtils;

    public EmployeeSqlStatement(){
        this.dbUtils = new DBUtils();
    }

    public void insertIntoEmployee(String[] employee_info){
        String mysqlStatement = "INSERT INTO employee VALUES(?,?,?,?,?);";
        int[] indexes = {1,2,3,4,5};
        String[] values = new String[5];
        System.arraycopy(employee_info, 0, values, 0, values.length);

        dbUtils.insertData(mysqlStatement,indexes,values);
    }

    public void updateId(String name, int newValue){
        String mysqlStatement = "UPDATE employee SET id=? WHERE name=?;";
        int[] indexes = {1,2};
        String[] values = {Integer.toString(newValue), name};

        dbUtils.updateData(mysqlStatement,indexes,values);
    }

    public void updateName(int id, String newValue){
        String mysqlStatement = "UPDATE employee SET name=? WHERE id=?;";
        int[] indexes = {1,2};
        String[] values = {newValue, Integer.toString(id)};

        dbUtils.updateData(mysqlStatement,indexes,values);
    }

    public void updatePhoneNumber(int id, String newValue){
        String mysqlStatement = "UPDATE employee SET phoneNumber=? WHERE id=?;";
        int[] indexes = {1,2};
        String[] values = {newValue, Integer.toString(id)};

        dbUtils.updateData(mysqlStatement,indexes,values);
    }

    public void updateAddress(int id, String newValue){
        String mysqlStatement = "UPDATE employee SET address=? WHERE id=?;";
        int[] indexes = {1,2};
        String[] values = {newValue, Integer.toString(id)};

        dbUtils.updateData(mysqlStatement,indexes,values);
    }

    public void updateDob(int id, String newValue){
        String mysqlStatement = "UPDATE employee SET dob=? WHERE id=?;";
        int[] indexes = {1,2};
        String[] values = {newValue, Integer.toString(id)};

        dbUtils.updateData(mysqlStatement,indexes,values);
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
        Object[] result = new Object[6];

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

    public Object[] getEmployeeName(){
        String sqlStatement = "SELECT name FROM employee;";
        ArrayList<String> result = new ArrayList<>();
        ResultSet employee_name = dbUtils.retrieveData(sqlStatement);

        try{
            while(employee_name.next()){
                result.add(employee_name.getString(1));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return result.toArray();
    }

    public String getEmployeeName(int employeeId){
        String sqlStatement = "SELECT name FROM employee WHERE id = ?;";
        int[] indexes = {1};
        String[] values = {Integer.toString(employeeId)};
        ResultSet employee_name = dbUtils.selectData(sqlStatement, indexes, values);
        String employeeName = null;

        try{
            while(employee_name.next()){
                employeeName = employee_name.getString(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return employeeName;
    }

    public void deleteEmployee(int id){
        String sqlStatement = "DELETE FROM employee where id = ?;";
        int[] indexes = {1};
        String[] values = {Integer.toString(id)};

        dbUtils.deleteData(sqlStatement,indexes,values);
    }
}
