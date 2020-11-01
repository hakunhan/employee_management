import java.util.Date;

public class Manager extends Employee{
    private Database database;

    public Manager(int ID, String name, String phoneNumber, String address, Date dob, Account account, Database database) {
        super(ID, name, phoneNumber,address, dob, account);
        this.database = database;
    }

    public void addEmployee(Employee e){
        database.addEmployee(e);
    }

    public void removeEmployee(Employee e){

    }
}
