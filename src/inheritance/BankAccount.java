package inheritance;

import java.io.IOException;

public class BankAccount {
    /*
    Access modifier
    public      - can be accessed anywhere
    protected   - can be accessed in subclasses
    package     - default, can be accessed from classes in the same package
    private     - can only be accessed from methods within this class
     */

    /*
    final
    final variables cannot be reassigned
    final methods cannot be overridden
    final classes cannot be inherited
     */
    private double balance;

    //Constructor
    public BankAccount() {
        //No parameter, default constructor
        balance = 0;

    }
    public BankAccount(double amount) {
        balance = amount;

    }

    //Getter
    public double getBalance() {
        return balance;
    }

    //Mutator
    public void deposit(double amount) throws InvalidDepositException {
        if ((amount>20)){
            throw new InvalidDepositException("much");
        } else if (amount<0.01) {
            throw new InvalidDepositException("little");
        }
        balance += amount;
    }
    public void withdraw(double amount) throws IllegalArgumentException, RuntimeException {
        if(amount > balance) {
            IllegalArgumentException e = new IllegalArgumentException("Attempting to withdraw an amount higher than the balance");
            throw e;
        }
        balance -= amount;
    }

    //Encapsulation
    //  When in doubt, keep it private
}
