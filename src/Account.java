public class Account {
    private int EmployeeID;
    private String username;
    private String password;

    public Account(int EmployeeID,String username, String password){
    	this.EmployeeID = EmployeeID;
    	this.username = username;
    	this.password = password
    }

    public int getEmployeeID{
    	return EmployeeID;
    }

    public void setEmployeeID{
    	this.EmployeeID = EmployeeID;
    }

    public String getUsername{
    	return username;
    }

    public void setUsername{
    	this.username = username;
    }

    public String getPassword{
    	return password;
    }

    public void setPassword{
    	this.password = password;
    }

}
