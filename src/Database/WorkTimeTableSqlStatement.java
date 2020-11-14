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

    public void updateMonday(String oldValues, String newValue){
        String mysqlStatement = "UPDATE workTimeTable SET monday=? WHERE monday=?;";
        int[] indexes = {1,2};
        String[] values = {newValue,oldValues};

        dbUtils.updateData(mysqlStatement,indexes,values);
    }

    public void updateTuesday(String oldValues, String newValue){
        String mysqlStatement = "UPDATE workTimeTable SET tuesday=? WHERE tuesday=?;";
        int[] indexes = {1,2};
        String[] values = {newValue,oldValues};

        dbUtils.updateData(mysqlStatement,indexes,values);
    }

    public void updateWednesday(String oldValues, String newValue){
        String mysqlStatement = "UPDATE workTimeTable SET wednesday=? WHERE wednesday=?;";
        int[] indexes = {1,2};
        String[] values = {newValue,oldValues};

        dbUtils.updateData(mysqlStatement,indexes,values);
    }

    public void updateThursday(String oldValues, String newValue){
        String mysqlStatement = "UPDATE workTimeTable SET thursday=? WHERE thursday=?;";
        int[] indexes = {1,2};
        String[] values = {newValue,oldValues};

        dbUtils.updateData(mysqlStatement,indexes,values);
    }

    public void updateFriday(String oldValues, String newValue){
        String mysqlStatement = "UPDATE workTimeTable SET friday=? WHERE friday=?;";
        int[] indexes = {1,2};
        String[] values = {newValue,oldValues};

        dbUtils.updateData(mysqlStatement,indexes,values);
    }

    public void updateSaturday(String oldValues, String newValue){
        String mysqlStatement = "UPDATE workTimeTable SET saturday=? WHERE saturday=?;";
        int[] indexes = {1,2};
        String[] values = {newValue,oldValues};

        dbUtils.updateData(mysqlStatement,indexes,values);
    }

    public void updateSunday(String oldValues, String newValue){
        String mysqlStatement = "UPDATE workTimeTable SET sunday=? WHERE sunday=?;";
        int[] indexes = {1,2};
        String[] values = {newValue,oldValues};

        dbUtils.updateData(mysqlStatement,indexes,values);
    }
}
