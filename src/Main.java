public class Main {
    public static void main(String[] args) {
        /*
        This is a block comment
         */
        //Declaration
        int a;
        //Initialization
        a = 1;
        //Declare and initialize
        String str = "hello";

        boolean bool = true; //1 bit
        //00 01 10 11                       2 bits, 2^2 = 4 possibilities
        //000 001 010 011 100 101 110 111   3 bits, 2^3 = 8 possibilities

        byte b = -128; //1 Byte / 8 bits        2^8 possibilities = 256 (-128 to 127)
        short num1 = 123; //2 Bytes / 16 bits   2^16 possibilities = 65536 (-32768 to 32767)
        int num2 = 2147483647; //4 Bytes / 32 bits     2^32 possibilities = 4294967296 (-2147483648 to 2147483647)
        int max = Integer.MAX_VALUE;
        Integer wrappedInt = 0;
        long num3 = 922337203; //8 Bytes / 64 bits            2^64 possibilities = (-9223372036854775808 to 9223372036854775807)

        float num4 = 1.0f; //4Bytes / 32 bits
        double num5 = Double.MAX_VALUE; //8 Bytes / 64 bits

        char chr = 'a'; //1 Byte / 8 bits  https://www.asciitable.com/
        char chr2 = 97;
        char chr3 = (char)(chr+1);

        String str2 = ", " + max + " is the maximum value of an int";

        /*
        Naming Conventions
        methods & variables
            lowerCamelCase
        classes
            UpperCamelCase

        must begin with a letter (but can contain numbers)
            num1 - LEGAL
            1num - ILLEGAL, starts with a number
            num 1 - ILLEGAL, contains a space
            int - ILLEGAL, reserved name (int, char, true, false, class, etc)
            number_one - LEGAL, not preferred

        CONSTANTS
        public static int MAX_VALUE;
            UPPER_SNAKE_CASE
            public static indicates a constant
         */


        System.out.println("Hello world");
        System.out.println(str2);
    }
}
