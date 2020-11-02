public class Authentication {
    private Database database;

    public Authentication(Database database){
        this.database = database;
    }

    public void login(Account acc){
        if (!database.accountIsIn(acc)){
            wrongAccount();
        }

        if (database.getEmployee(acc.getEmployee_ID()) == null){
            wrongAccount();
        }
    }

    private void wrongAccount(){
        System.out.println("Wrong account!");
    }
}
