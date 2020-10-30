import java.util.Date;

public class Employee {
    private int ID;
    private String name;
    private String phoneNumber;
    private Date dob;
    private Account account;
    private WorkTimetable workTimetable;

    public Employee(int ID, String name, String phoneNumber,String address , Date dob, Account account) {
        if(!validateID(ID)){
            System.out.println("Invalid ID: " + ID);
            return;
        }
        if(!validateName(name)){
            System.out.println("Invalid name: " + name);
            return;
        }
        if(!validatePhoneNumber(phoneNumber)){
            System.out.println("Invalid phone number: " + phoneNumber);
            return;
        }
        if(!validateAddress(address)){
            System.out.println("Invalid address: " + address);
            return;
        }
        if(!validateDob(dob)){
            System.out.println("Invalid date of birth: " + dob);
            return;
        }
        if(!validateAccount(account)){
            System.out.println("Invalid account: "+account);
            return;
        }

        this.ID = ID;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.dob = dob;
        this.account = account;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Date getDob() {
        return dob;
    }

    public Account getAccount() {
        return account;
    }

    public void setID(int ID) {
        if (!validateID(ID))
            return;
        this.ID = ID;
    }

    public void setName(String name) {
        if (!validateName(name))
            return;
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (!validatePhoneNumber(phoneNumber))
            return;
        this.phoneNumber = phoneNumber;
    }

    public void setDob(Date dob) {
        if (!validateDob(dob))
            return;
        this.dob = dob;
    }

    public void setAccount(Account account) {
        if (validateAccount(account))
            return;
        this.account = account;
    }

    public void viewWorkTime(){

    }

    public void exportWorkTimetable(){

    }

    public void calculateSalary(){

    }
    public boolean validateID(int ID){
        return ID >= 1 && ID <= 111;
    }

    public boolean validateName(String name){
        return name != null && name.length() > 0 && name.length() <= 30;
    }

    public boolean validatePhoneNumber(String phoneNumber){
        return phoneNumber != null && phoneNumber.length() > 0 && phoneNumber.length() <= 10;
    }

    public boolean validateAddress(String address){
        return address != null && address.length() > 0 && address.length() <=50;
    }

    public boolean validateDob(Date dob){
        return dob != null;
    }

    public boolean validateAccount(Account account){
        return account != null;
    }
}
