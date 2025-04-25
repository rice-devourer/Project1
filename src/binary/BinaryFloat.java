package binary;

public class BinaryFloat {

    public static void main(String[] args) {
        //Integer has 4 bytes, goes up to +-2.14 * 10^9
        //Float has 4 bytes, goes up to +-3.4 * 10^34
        //Float/double can contain decimal places, and store higher numbers, but sacrifices precision

        //Integer is represented in binary with Two's Complement
        //Float/double are represented in binary with IEEE 754

        /*Float
        32s bit in total
          1 sign
          8 exponent
          23 mantissa
         */

        /*Double
        64 bits in total
            1 sign
            11 exponent
            52 mantissa
         */

        //sign * mantissa * 2 ^ exponent
    }
}
