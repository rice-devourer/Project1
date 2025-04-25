package inheritance;

public class BankTester {

    public static void main(String[] args){
        BankAccount newAcc = new BankAccount(100);
        try {
            newAcc.withdraw(50);
            newAcc.withdraw(100);
        } catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch(RuntimeException e) {
            //More specific (subclasses) exceptions first!
        } finally {

        }
        try{
            newAcc.deposit(2000000);
        }catch (InvalidDepositException e){
            if (e.getMessage().equals("little")){
                System.out.println("to little money, money>0.01");
            } else if(e.getMessage().equals("much")){
                System.out.println("to much money, at most 20 bucks please");
            } else {
                System.out.println("Unknown error, try updating software");
            }
        }

        /*BankAccount newAcc = new BankAccount(123);
        newAcc.deposit(20);
        System.out.println("The BankAccount has a balance of " + newAcc.getBalance());

        SavingAccount newSavings = new SavingAccount(1000, 0.1);
        newSavings.deposit(100);
        System.out.println(newSavings.getBalance());
        newSavings.applyInterest();
        System.out.println(newSavings.getBalance());

        Object obj = new BankAccount();
        BankAccount acc = new SavingAccount();
        //SavingAccount acc2 = new BankAccount(); wrong direction!
        try{
            ((SavingAccount)obj).applyInterest();
            Integer.parseInt("hi");
        } catch (ClassCastException error){

        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {

        }

        if(obj instanceof SavingAccount) {
            System.out.println("obj is a SavingAccount");
            SavingAccount savingAccount = (SavingAccount) acc;
            savingAccount.applyInterest();
        } else if(obj instanceof BankAccount) {
            System.out.println("obj is a BankAccount");
        } else {
            System.out.println("obj is not an Account");
        }

        //patterns
        if(obj instanceof SavingAccount savingAccount) {
            System.out.println("obj is a SavingAccount");
            savingAccount.applyInterest();
        }*/

    }
}
