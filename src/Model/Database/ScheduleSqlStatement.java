package Model.Database;

import java.sql.ResultSet;
import java.sql.SQLException;

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

    public String[] getScheduleEmployee(int employee_id){
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

    public static void main(String[] args) {
        ScheduleSqlStatement sqlStatement = new ScheduleSqlStatement();

        String[] employee_schedule = {"a","b",null,"d", null,"f","g"};
        //sqlStatement.insertIntoSchedule(1,employee_schedule);

        //sqlStatement.updateMonday(1,"21:00");

        String[] test = sqlStatement.getScheduleEmployee(1);

        for(String a:test){
            System.out.print(a + " ");
        }
    }
}
