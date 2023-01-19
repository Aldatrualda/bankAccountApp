package functionality;

public abstract class Account implements IBaseRate {
    //List common properties for saving and checking accounts
    private String firstName;
    private String socialSecurityNumber;
    private static int index = 10000;
    protected String accountNumber;
    private double balance;
    protected double rate;

    //Constructor to set base properties and initialize the account
    public Account(String firstName, String socialSecurityNumber, double initDeposit) {
        this.firstName = firstName;
        this.socialSecurityNumber = socialSecurityNumber;
        balance = initDeposit;

        /* GENERATE ACCOUNT NUMBER.
        MainClasses.Account number consists of 11 digital number.
        First: 1(MainClasses.Checking account) or 2(MainClasses.Saving account);
        Second: next two number we get from last two digital numbers of socialSecurityNumber;
        Third: unique 5 digital number from index
        Forth: 3 random digital number
         */
        this.accountNumber = setNumberAccount();
        this.rate = setRate();
    }

    //Sum to balance some accrued
    public void compound() {
        double accruedInterest = balance * (rate / 100);
        balance = balance + accruedInterest;
        System.out.println("BALANCE WITH ACCRUED: " + balance + "$");
    }

    //Set rate for current account
    public abstract double setRate();

    //Set number account
    private String setNumberAccount() {
        index++;
        String lastTwoNumberOfsSN = socialSecurityNumber.substring(socialSecurityNumber.length() - 2);
        int randomNumber = (int) (Math.random() * Math.pow(10, 3));
        return lastTwoNumberOfsSN + index + randomNumber;
    }

    //List common methods
    public void deposit(double amount) {
        balance = balance + amount;
    }

    public void withDraw(double amount) {
        balance = balance - amount;
    }

    public void transfer(String toWhere, double amount) {
        balance = balance - amount;
    }

    public void showBalance() {
        System.out.println("Balance: " + balance + "$");
    }

    //Show info
    public void showInfo() {
        System.out.print(
                "NEW ACCOUNT: NAME: " + firstName +
                        "\nSECURITY NUMBER: " + socialSecurityNumber +
                        "\nBALANCE: " + balance + "$\n"
        );
    }
}
