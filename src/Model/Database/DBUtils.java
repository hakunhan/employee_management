package Database;

import com.mysql.cj.jdbc.exceptions.NotUpdatable;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DBUtils {
    private String url;
    private String user;
    private String password;
    private Connection connection;
    private Statement statement;

    public DBUtils(){
        initialize();
    }

    private void initialize(){
        Properties p = new Properties();
        try{
            p.load(new FileInputStream("src\\Database\\database.properties"));
            url = p.getProperty("url");
            user = p.getProperty("user");
            password = p.getProperty("password");

            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url + "?user=" + user+ "&password=" + password
                    + "&useUnicode=true&characterEncoding=UTF-8");
        } catch (ClassNotFoundException | SQLException | IOException e) {
            e.printStackTrace();
        }

        if (connection == null){
            throw new NullPointerException("Connection is null");
        }
        else {
            System.out.println("Connected");
        }
    }

    public void createStatement(){
        if (this.statement == null){
            try {
                this.statement = connection.createStatement();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    public ResultSet retrieveData(String mysqlCommand){
        try {
            createStatement();
            ResultSet resultSet = statement.executeQuery(mysqlCommand);
            return resultSet;
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return null;
    }

    private ResultSet executeQuery(String mysqlStatement, int[] indexes, String[] values){
        ResultSet result = null;

        if(mysqlStatement == null){
            throw new NullPointerException("mysqlStatement is null");
        }

        if (indexes != null && values != null) {
            try {
                PreparedStatement ps = connection.prepareStatement(mysqlStatement);

                for (int i = 0; i < values.length; i++) {
                    ps.setString(indexes[i], values[i]);
                }

                result = ps.executeQuery();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return result;
    }

    private int executeStatement(String mysqlStatement, int[] indexes, String[] values){
        int rowNo = 0;

        if (mysqlStatement == null){
            throw new NullPointerException("mysqlStatement is null");
        }
        if (indexes != null && values != null) {
            try {
                PreparedStatement ps = connection.prepareStatement(mysqlStatement);

                for (int i = 0; i < values.length; i++) {
                    ps.setString(indexes[i], values[i]);
                }
                rowNo = ps.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return rowNo;
    }

    public int insertData(String mysqlStatement, int[] indexes, String[] values){
        return executeStatement(mysqlStatement, indexes, values);
    }

    public int updateData(String mysqlStatement, int[] indexes, String[] values){
        return executeStatement(mysqlStatement, indexes, values);
    }

    public int deleteData(String mysqlStatement, int[] indexes, String[] values){
        return executeStatement(mysqlStatement, indexes, values);
    }

    public ResultSet selectData(String mysqlStatement, int[] indexes, String[] values){
        return executeQuery(mysqlStatement, indexes, values);
    }

    public static void main(String[] args) {
        DBUtils utils = new DBUtils();

        String mysqlCommand = "SELECT * FROM employee;";
        ResultSet rs = utils.retrieveData(mysqlCommand);
        try{
            while (rs.next()){
                System.out.println(rs.getString(1));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
