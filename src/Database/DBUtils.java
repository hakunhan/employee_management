package Database;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class DBUtils {
    public void initialize(){
        Properties p = new Properties();
        try{
            p.load(new FileInputStream("src\\Database\\database.properties"));
            String url = p.getProperty("url");
            String user = p.getProperty("user");
            String password = p.getProperty("password");
            System.out.println(url);
            System.out.println(user);
            System.out.println(password);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        DBUtils utils = new DBUtils();
        utils.initialize();
    }
}
