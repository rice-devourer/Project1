package lambdas;

import inheritance.BankAccount;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Lambdas {
    //lambdas - a small block of code
    // (parameters) -> expression
    public static void main(String[] args) {
        ArrayList<BankAccount> accounts = new ArrayList<>();
        accounts.add(new BankAccount(100));
        accounts.add(new BankAccount(1000));
        accounts.add(new BankAccount(200));
        accounts.add(new BankAccount(300));
        accounts.add(new BankAccount(500));
        accounts.add(new BankAccount(700));

        /*for (BankAccount acc : accounts){
            acc.deposit(100);
        }*/

        Consumer<BankAccount> lambda = (account) -> {
            account.deposit(20);
        };
        accounts.forEach(lambda);

        accounts.forEach((account -> System.out.println("The account has a balance of " + account.getBalance())));

        ArrayList<String> strings = new ArrayList<>();
        strings.add("Hello");
        strings.add("world");
        strings.add("elephant");
        strings.add("cat");

        //Consumer
        /*
        A functional interface which accepts parameters, and does not return any values.
         */
        Consumer<String> lambdas;
        lambdas = (str) -> {
            str = str.substring(str.length()-1)+str.substring(1,str.length()-1)+str.substring(0,1);
            System.out.println(str);
        };

        //strings.forEach(lambdas);


        //Supplier
        /*
        A functional interface which returns an object
         */
        Supplier<Integer> randomNumberSupplier;
        randomNumberSupplier = () -> {
            int random = (int)(Math.random()*10);
            return random;
        };
        for(int i = 0; i<10; i++) System.out.println(randomNumberSupplier.get());

        //Create a supplier that creates a string of random alphabet characters (a-z) of a random length between 1 and 16
        Supplier<String> randomStringSupplier;
        randomStringSupplier = () -> {
            Random random = new Random();
            StringBuilder str = new StringBuilder();
            for (int i = 0;i<16;i++) {
                if (random.nextInt(1, 3) == 1){
                    char rnd = (char) random.nextInt(65, 91);
                    str.append(rnd);
                }else{char rnd = (char) random.nextInt(97, 123);
                    str.append(rnd);}

            }
            return str.toString();
        };
        for(int i = 0; i<10; i++) System.out.println(randomStringSupplier.get());


        List<Integer> numList = new ArrayList<>();
        for(int i=0; i<10; i++) numList.add(randomNumberSupplier.get());
        System.out.println("The input is " + Arrays.toString(numList.toArray()));
        printOdds(numList);


        //Function
        //Both accepts parameters and returns an object
        List<Integer> numList2 = List.of(0, 1, 2, 3, 4, 5);
        Function<Integer, Double> half = (input) -> {
            double newNum = input/2.0;
            return newNum;
        };
        List<Double> numList3 = new ArrayList<>();
        for(int num : numList2) numList3.add(half.apply(num));

        //Predicate
        Predicate<Integer> isEven = num -> num%2==0;
        boolean bool = isEven.test(3);
        Predicate<Integer> isPositive = num -> num>=0;
        boolean bool2 = isEven.and(isPositive).test(10);

        List<Integer> numList4 = List.of(1, 2, 3, 4, 5, 6, 7);
        numList4.replaceAll((num) -> num * 2);
        numList4.removeIf((num) -> num%2==0);
        numList4.removeIf(isEven);

        //accounts.sort(Comparator.comparingDouble((account) -> account.getBalance())); //key extractor lambda function
        accounts.sort(Comparator.comparingDouble(BankAccount::getBalance));

        List<Double> balances = accounts.stream().map(BankAccount::getBalance).toList();
    }

    /*
        Write a Consumer that accepts an integer and prints the number if it is odd
        USING THAT CONSUMER, write a method which accepts a list of integers and print out the odd numbers
         */
    //    (argument) -> body
    private static Consumer<Integer> printOdd =(num) -> {
        if (num%2!=0){System.out.println(num);}
    };

    private static void printOdds(List<Integer> nums) {
        nums.forEach(printOdd);
    }

}
