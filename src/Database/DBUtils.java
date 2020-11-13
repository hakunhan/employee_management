package Database;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtils {
    private String url;
    private String user;
    private String password;
    private Connection connection;

    public void initialize(){
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

    public static void main(String[] args) {
        DBUtils utils = new DBUtils();
        utils.initialize();
    }
}
