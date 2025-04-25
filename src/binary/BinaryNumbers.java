package binary;

import com.sun.source.tree.BreakTree;
import dataStructures.Pair;

public class BinaryNumbers {

    public static void main(String[] args) {
        int x = 10; //00000000 00000000 00000000 00001010


        int a = 0b1100; //12
        int b = 0b1010; //10
        //And
        int and = a & b;
        //Or
        int or = a | b;
        //Exclusive Or
        int xor = a ^ b;
        //Negation
        int notA = ~ a;
        int notB = ~ b;
        System.out.println(Integer.toBinaryString(a));
        System.out.println(Integer.toBinaryString(b));
        System.out.println(Integer.toBinaryString(and) + " AND &    Int value " + and);
        System.out.println(Integer.toBinaryString(or) + " OR | Int value " + or);
        System.out.println(Integer.toBinaryString(xor) + " XOR | Int value " + xor);
        System.out.println(Integer.toBinaryString(notA) + " ~a | Int value " + notA);
        System.out.println(Integer.toBinaryString(notB) + " ~b | Int value " + notB);
        System.out.println();

        int c = -0b101;
        //Left Shift (signed)
        int leftShift1 = c << 1;
        //Right Shift (signed)
        int rightShift1 = c >> 1;
        //Unsigned right shift
        int rightUnsignedShift = c >>> 1;
        System.out.println(Integer.toBinaryString(leftShift1) + " left | Int value " + leftShift1);
        System.out.println(Integer.toBinaryString(rightShift1) + " right | Int value " + rightShift1);
        System.out.println(Integer.toBinaryString(rightUnsignedShift) + " right unsigned | Int value " + rightUnsignedShift);

        int ip = 0b11110000_10101010;
        int fourthOctet = ip & 0b11111111;
        int thirdOctet = ip >> 8 & 0b11111111;
        System.out.println("4th octet " + Integer.toBinaryString(fourthOctet));
        System.out.println("3rd octet " + Integer.toBinaryString(thirdOctet));

        System.out.println(toBinaryString(ip));

        //Integers
    }

    public static String toBinaryString(int num) {
        int holder = num;
        String returnVal = "";
        if (num == 0){
            return ("0000000000000000000000000000000000000000");
        }
        while (holder!=1){
            returnVal = (holder%2!=0 ? "1" : "0") + returnVal;
            holder /= 2;
        }
        returnVal = (holder<0 ? "1": "0") + returnVal;
        return returnVal;
    }


}
