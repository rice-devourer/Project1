package dataStructures;
import dataStructures.ScientificNumber;

public class ScientificNumberTester {
    public static void main(String[] args){
        ScientificNumber million = new ScientificNumber(1,6);
        ScientificNumber thousand = new ScientificNumber(1,3);
        ScientificNumber hundred = new ScientificNumber(1,2);
        ScientificNumber fiveBillion = new ScientificNumber(5,7);
        million.add(thousand);
        System.out.println(million);
        fiveBillion.subtract(hundred);
        System.out.println(fiveBillion);
        hundred.multiply(thousand);
        thousand.division(hundred);
        System.out.println(hundred);
        System.out.println(thousand);
    }
}
