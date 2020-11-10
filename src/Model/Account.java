package Model;

public class Account {
    private int Employee_ID;
    private String username;
    private String password;

    public Account(int Employee_ID, String username, String password){
        if (!validateID(Employee_ID)) {
            System.out.println("Invalid Employee_ID: " + Employee_ID);
            return;
        }
        if (!validateUsername(username)){
            System.out.println("Invalid username: " + username);
            return;
        }
        if (!validatePassword(password)){
            System.out.println("Invalid password: " + password);
            return;
        }
        this.Employee_ID = Employee_ID;
        this.username = username;
        this.password = password;
    }

    public int getEmployee_ID() {
        return Employee_ID;
    }

    public void setEmployee_ID(int employee_ID) {
        Employee_ID = employee_ID;
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

    public boolean validateID(int ID) {
        return ID >= 1 && ID <= 111;
    }
}
