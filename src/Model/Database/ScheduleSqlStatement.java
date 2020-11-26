package Model.Database;

import org.omg.PortableInterceptor.INACTIVE;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

public class ScheduleSqlStatement {
    private DBUtils dbUtils;

    public ScheduleSqlStatement(){
        this.dbUtils = new DBUtils();
    }
    public void insertIntoSchedule(int employee_id, String[] schedule){
        String mysqlStatement = "INSERT INTO schedule VALUES(?,?,?,?,?,?,?,?);";
        int[] indexes = {1,2,3,4,5,6,7,8};
        String[] values = new String[8];
        values[0] = Integer.toString(employee_id);

        System.arraycopy(schedule, 0, values, 1, values.length - 1);

        dbUtils.insertData(mysqlStatement,indexes,values);
    }

    public void updateMonday(int employee_id, String newValue){
        String mysqlStatement = "UPDATE schedule SET monday=? WHERE employee_id=?;";
        int[] indexes = {1,2};
        String[] values = {newValue, Integer.toString(employee_id)};

        dbUtils.updateData(mysqlStatement,indexes,values);
    }

    public void updateTuesday(int employee_id, String newValue){
        String mysqlStatement = "UPDATE schedule SET tuesday=? WHERE employee_id=?;";
        int[] indexes = {1,2};
        String[] values = {newValue,Integer.toString(employee_id)};

        dbUtils.updateData(mysqlStatement,indexes,values);
    }

    public void updateWednesday(int employee_id, String newValue){
        String mysqlStatement = "UPDATE schedule SET wednesday=? WHERE employee_id=?;";
        int[] indexes = {1,2};
        String[] values = {newValue,Integer.toString(employee_id)};

        dbUtils.updateData(mysqlStatement,indexes,values);
    }

    public void updateThursday(int employee_id, String newValue){
        String mysqlStatement = "UPDATE schedule SET thursday=? WHERE employee_id=?;";
        int[] indexes = {1,2};
        String[] values = {newValue,Integer.toString(employee_id)};

        dbUtils.updateData(mysqlStatement,indexes,values);
    }

    public void updateFriday(int employee_id, String newValue){
        String mysqlStatement = "UPDATE schedule SET friday=? WHERE employee_id=?;";
        int[] indexes = {1,2};
        String[] values = {newValue,Integer.toString(employee_id)};

        dbUtils.updateData(mysqlStatement,indexes,values);
    }

    public void updateSaturday(int employee_id, String newValue){
        String mysqlStatement = "UPDATE schedule SET saturday=? WHERE employee_id=?;";
        int[] indexes = {1,2};
        String[] values = {newValue,Integer.toString(employee_id)};

        dbUtils.updateData(mysqlStatement,indexes,values);
    }

    public void updateSunday(int employee_id, String newValue){
        String mysqlStatement = "UPDATE schedule SET sunday=? WHERE employee_id=?;";
        int[] indexes = {1,2};
        String[] values = {newValue, Integer.toString(employee_id)};

        dbUtils.updateData(mysqlStatement,indexes,values);
    }

    public void deleteSchedule(int employee_id){
        String mysqlStatement = "DELETE FROM schedule WHERE employee_id=?;";
        int[] indexes = {1};
        String[] values = {Integer.toString(employee_id)};

        dbUtils.deleteData(mysqlStatement, indexes, values);
    }

    public Object[] getEmployeeId(){
        String sqlStatement = "SELECT employee_id FROM schedule;";
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

    public String[] getScheduleEmployeeWithId(int employee_id){
        String mysqlStatement = "SELECT employee_id, employee.name, monday, tuesday, wednesday, thursday, friday, saturday, sunday FROM schedule INNER JOIN employee ON employee.id = schedule.employee_id WHERE employee_id=?;";
        int[] indexes = {1};
        String[] values = {Integer.toString(employee_id)};
        //add place for REMOVE button in view => result have 9 + 1 blank value
        String[] result = new String[10];

        ResultSet employee_schedule = dbUtils.selectData(mysqlStatement,indexes,values);
        try{
            while(employee_schedule.next()){
                for (int i = 0; i < 9; i++)
                    result[i] = employee_schedule.getString(i+1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return result;
    }

    public String[] getScheduleEmployeeWithOutId(int employee_id){
        String mysqlStatement = "SELECT employee.name, monday, tuesday, wednesday, thursday, friday, saturday, sunday FROM schedule INNER JOIN employee ON employee.id = schedule.employee_id WHERE employee_id=?;";
        int[] indexes = {1};
        String[] values = {Integer.toString(employee_id)};
        String[] result = new String[8];

        ResultSet employee_schedule = dbUtils.selectData(mysqlStatement,indexes,values);
        try{
            while(employee_schedule.next()){
                for (int i = 0; i < result.length; i++)
                    result[i] = employee_schedule.getString(i+1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return result;
    }

    public Object[] getEmployeeInScheduleName(){
        String sqlStatement = "SELECT employee.name FROM employee INNER JOIN schedule ON employee.id = schedule.employee_id;";
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

    public String getEmployeeName(int employee_id){
        String sqlStatement = "SELECT employee.name FROM employee INNER JOIN schedule ON employee.id = schedule.employee_id WHERE employee_id = ?;";
        int[] indexes = {1};
        String[] values = {Integer.toString(employee_id)};

        ResultSet employee_name = dbUtils.selectData(sqlStatement, indexes, values);
        String result = null;
        try{
            while(employee_name.next()){
                result = employee_name.getString(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return result;
    }
}
