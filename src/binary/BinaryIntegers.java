package binary;

public class BinaryIntegers {

    public static void main(String[] args) {
        int b = 0b1010; //10
        //One's complement
        int one = (~b);
        //Two's complement (java uses Two's Complement)
        //Negate then add 1
        int two = (~b) + 1;
        System.out.println("The byte b is " + Integer.toBinaryString(b) + " decimal " + b);
        System.out.println("The one's complement is " + Integer.toBinaryString(one) + " decimal " + one);
        System.out.println("The two's complement is " + Integer.toBinaryString(two) + " decimal " + two);

        // 00010011 is 19
        // -19 is
        // 11101101

        // -19 + 10

        //11101101 +
        //00001010 =
        //11110111 = -9
        //00001001 = 9
    }
}
