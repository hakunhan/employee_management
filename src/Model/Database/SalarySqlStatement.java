package Model.Database;

import Model.Salary;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SalarySqlStatement {
    private DBUtils dbUtils;

    public SalarySqlStatement(){
        this.dbUtils = new DBUtils();
    }

    public void insertIntoSalary(float hourlyRate){
        String mysqlStatement = "INSERT INTO schedule VALUES(?);";
        int[] indexes = {1};
        String[] values = {Float.toString(hourlyRate)};

        dbUtils.insertData(mysqlStatement,indexes,values);
    }

    public float getHourlyRate(){
        String mysqlStatement = "SELECT * FROM hourlyRate;";
        float result = 0;
        ResultSet hourlyRate = dbUtils.retrieveData(mysqlStatement);

        try{
            while(hourlyRate.next()){
                result = hourlyRate.getFloat(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return result;
    }

    public void updateSalary(float hourlyRate){
        String mysqlStatement = "UPDATE salary set hourlyRate = ?;";
        int[] indexes = {1};
        String[] values = {Float.toString(hourlyRate)};

        dbUtils.updateData(mysqlStatement,indexes,values);
    }
}
