package Model.Database;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SalarySqlStatement {
    private DBUtils dbUtils;

    public SalarySqlStatement(){
        this.dbUtils = new DBUtils();
    }

    public void insertIntoSalary(float hourlyRate){
        String mysqlStatement = "INSERT INTO salary VALUES(?);";
        int[] indexes = {1};
        String[] values = {Float.toString(hourlyRate)};

        dbUtils.insertData(mysqlStatement,indexes,values);
    }

    public float getHourlyRate(){
        String mysqlStatement = "SELECT * FROM salary;";
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
        String mysqlStatement = "UPDATE salary set hourlyRate = ? where hourlyRate = ?;";
        int[] indexes = {1,2};
        String[] values = {Float.toString(hourlyRate), Float.toString(getHourlyRate())};

        dbUtils.updateData(mysqlStatement,indexes,values);
    }
}
