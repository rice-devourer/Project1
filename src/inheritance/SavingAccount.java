package inheritance;

public class SavingAccount extends BankAccount {
    //SavingAccount is a subclass/child of BankAccount
    //BankAccount is superclass/parent of SavingAccount

    private double interestRate;
    //shadowing
    //private double balance = 1;

    public SavingAccount() {
        super(0);
        this.interestRate = 0.1;

        //double b = super.balance;
        //double c = this.balance;
    }
    public SavingAccount(double amount, double interestRate) {
        super(amount);
        this.interestRate = interestRate;
    }

    public void applyInterest() {
        double interest = getBalance() * interestRate;
        deposit(interest);

        //inline variables
        //deposit(getBalance() * interestRate);
    }

    /*
    @Override
    public double getBalance() {
        return 0;
    }
    */

}
