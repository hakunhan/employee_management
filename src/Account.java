import java.util.Date;

public class Account {
    private String username;
    private String password;

    public Account(String username, String password){
        if (!validateUsername(username)){
            System.out.println("Invalid username: " + username);
            return;
        }
        if (!validatePassword(password)){
            System.out.println("Invalid password: " + password);
            return;
        }
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        if (!validateUsername(username))
            return;
        this.username = username;
    }

    public void setPassword(String password) {
        if (!validatePassword(password))
            return;
        this.password = password;
    }

    public boolean validateUsername(String username){
        return username != null && username.length() > 0 && username.length() <=30;
    }

    public boolean validatePassword(String password){
        return password != null && password.length() > 0 && password.length() <=30;
    }
}
