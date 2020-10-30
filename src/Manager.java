import java.util.Date;

public class Manager extends Employee{
    public Manager(int ID, String name, String phoneNumber, String address, Date dob, Account account) {
        super(ID, name, phoneNumber,address, dob, account);
    }
}
