package Database;

public class WorkTimeTableSqlStatement {
    private DBUtils dbUtils;

    public WorkTimeTableSqlStatement(){
        this.dbUtils = new DBUtils();
    }
    public void insertIntoWorkTimeTable(String[] values){
        String mysqlStatement = "INSERT INTO workTimeTable VALUES(?);";
        int[] indexes = {1,2,3,4,5,6,7};

        dbUtils.insertData(mysqlStatement,indexes,values);
    }

    public void updateMonday(String employee_id, String newValue){
        String mysqlStatement = "UPDATE workTimeTable SET monday=? WHERE employee_id=?;";
        int[] indexes = {1,2};
        String[] values = {newValue, employee_id};

        dbUtils.updateData(mysqlStatement,indexes,values);
    }

    public void updateTuesday(String employee_id, String newValue){
        String mysqlStatement = "UPDATE workTimeTable SET tuesday=? WHERE employee_id=?;";
        int[] indexes = {1,2};
        String[] values = {newValue,employee_id};

        dbUtils.updateData(mysqlStatement,indexes,values);
    }

    public void updateWednesday(String employee_id, String newValue){
        String mysqlStatement = "UPDATE workTimeTable SET wednesday=? WHERE employee_id=?;";
        int[] indexes = {1,2};
        String[] values = {newValue,employee_id};

        dbUtils.updateData(mysqlStatement,indexes,values);
    }

    public void updateThursday(String employee_id, String newValue){
        String mysqlStatement = "UPDATE workTimeTable SET thursday=? WHERE employee_id=?;";
        int[] indexes = {1,2};
        String[] values = {newValue,employee_id};

        dbUtils.updateData(mysqlStatement,indexes,values);
    }

    public void updateFriday(String employee_id, String newValue){
        String mysqlStatement = "UPDATE workTimeTable SET friday=? WHERE employee_id=?;";
        int[] indexes = {1,2};
        String[] values = {newValue,employee_id};

        dbUtils.updateData(mysqlStatement,indexes,values);
    }

    public void updateSaturday(String employee_id, String newValue){
        String mysqlStatement = "UPDATE workTimeTable SET saturday=? WHERE employee_id=?;";
        int[] indexes = {1,2};
        String[] values = {newValue,employee_id};

        dbUtils.updateData(mysqlStatement,indexes,values);
    }

    public void updateSunday(String employee_id, String newValue){
        String mysqlStatement = "UPDATE workTimeTable SET sunday=? WHERE employee_id=?;";
        int[] indexes = {1,2};
        String[] values = {newValue,employee_id};

        dbUtils.updateData(mysqlStatement,indexes,values);
    }

    public void deleteWorkTimeTable
}
