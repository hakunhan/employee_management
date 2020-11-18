package Database;

public class WorkTimeTableSqlStatement {
    private DBUtils dbUtils;

    public WorkTimeTableSqlStatement(){
        this.dbUtils = new DBUtils();
    }
    public void insertIntoWorkTimeTable(int employee_id, String[] workTimeTable){
        String mysqlStatement = "INSERT INTO workTimeTable VALUES(?,?,?,?,?,?,?,?);";
        int[] indexes = {1,2,3,4,5,6,7,8};
        String[] values = new String[8];
        values[0] = Integer.toString(employee_id);

        System.arraycopy(workTimeTable, 0, values, 1, values.length - 1);

        dbUtils.insertData(mysqlStatement,indexes,values);
    }

    public void updateMonday(int employee_id, String newValue){
        String mysqlStatement = "UPDATE workTimeTable SET monday=? WHERE employee_id=?;";
        int[] indexes = {1,2};
        String[] values = {newValue, Integer.toString(employee_id)};

        dbUtils.updateData(mysqlStatement,indexes,values);
    }

    public void updateTuesday(int employee_id, String newValue){
        String mysqlStatement = "UPDATE workTimeTable SET tuesday=? WHERE employee_id=?;";
        int[] indexes = {1,2};
        String[] values = {newValue,Integer.toString(employee_id)};

        dbUtils.updateData(mysqlStatement,indexes,values);
    }

    public void updateWednesday(int employee_id, String newValue){
        String mysqlStatement = "UPDATE workTimeTable SET wednesday=? WHERE employee_id=?;";
        int[] indexes = {1,2};
        String[] values = {newValue,Integer.toString(employee_id)};

        dbUtils.updateData(mysqlStatement,indexes,values);
    }

    public void updateThursday(int employee_id, String newValue){
        String mysqlStatement = "UPDATE workTimeTable SET thursday=? WHERE employee_id=?;";
        int[] indexes = {1,2};
        String[] values = {newValue,Integer.toString(employee_id)};

        dbUtils.updateData(mysqlStatement,indexes,values);
    }

    public void updateFriday(int employee_id, String newValue){
        String mysqlStatement = "UPDATE workTimeTable SET friday=? WHERE employee_id=?;";
        int[] indexes = {1,2};
        String[] values = {newValue,Integer.toString(employee_id)};

        dbUtils.updateData(mysqlStatement,indexes,values);
    }

    public void updateSaturday(int employee_id, String newValue){
        String mysqlStatement = "UPDATE workTimeTable SET saturday=? WHERE employee_id=?;";
        int[] indexes = {1,2};
        String[] values = {newValue,Integer.toString(employee_id)};

        dbUtils.updateData(mysqlStatement,indexes,values);
    }

    public void updateSunday(int employee_id, String newValue){
        String mysqlStatement = "UPDATE workTimeTable SET sunday=? WHERE employee_id=?;";
        int[] indexes = {1,2};
        String[] values = {newValue, Integer.toString(employee_id)};

        dbUtils.updateData(mysqlStatement,indexes,values);
    }

    public void deleteWorkTimeTable(int employee_id){
        String mysqlStatement = "DELETE FROM workTimeTable WHERE employee_id=?;";
        int[] indexes = {1};
        String[] values = {Integer.toString(employee_id)};

        dbUtils.deleteData(mysqlStatement, indexes, values);
    }

    public String[] getWorkTimeTableOfEmployee(int employee_id){
        return null;
    }

    public static void main(String[] args) {
        WorkTimeTableSqlStatement sqlStatement = new WorkTimeTableSqlStatement();

        String[] employee_workTimeTable = {"a","b",null,"d", null,"f","g"};
        //sqlStatement.insertIntoWorkTimeTable(3,employee_workTimeTable);

        sqlStatement.updateMonday(3,"21:00");
    }


}
