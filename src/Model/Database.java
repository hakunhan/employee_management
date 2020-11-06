package Model;

import java.util.Iterator;

public class Database {
    private MySet<Account> accountList;
    private MySet<Employee> employeeList;

    public Database(){
        accountList = new MySet<>();
        employeeList = new MySet<>();
    }

    public void addAccount(Account acc){
        accountList.insert(acc);
    }

    public void removeAccount(Account acc){
        accountList.remove(acc);
    }

    public boolean accountIsIn(Account acc){
        return accountList.isIn(acc);
    }

    public void addEmployee(Employee employee){
        employeeList.insert(employee);
    }

    public void removeEmployee(Employee employee){
        employeeList.remove(employee);
    }

    public Employee getEmployee(int employee_ID){
        Iterator iterator = employeeList.iterator();

        while(iterator.hasNext()){
            Employee e = (Employee) iterator.next();

            if (e.getID() == employee_ID){
                return e;
            }
        }

        return null;
    }
}
