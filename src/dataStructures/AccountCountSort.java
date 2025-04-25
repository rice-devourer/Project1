package dataStructures;

import inheritance.BankAccount;
import inheritance.SavingAccount;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AccountCountSort {

    public static void main(String[] args) {
        List<BankAccount> accounts = new ArrayList<>();
        accounts.add(new BankAccount(100));
        accounts.add(new BankAccount(250));
        accounts.add(new BankAccount(124));
        accounts.add(new BankAccount(5321));
        accounts.add(new SavingAccount(124, 0.1));
        accounts.add(new BankAccount(4331));
        accounts.add(new BankAccount(241234));
        accounts.add(new BankAccount(14));
        accounts.add(new BankAccount(0));
        accounts.add(new SavingAccount(100, 0.1));
        accounts.add(new BankAccount(233));

        Collections.sort(accounts, (account1,account2) -> (int) (account1.getBalance()-account2.getBalance()));
        for(BankAccount account : accounts){
            System.out.println(account.getBalance());
        }
    }
}
