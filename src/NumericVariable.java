import java.lang.foreign.ValueLayout;

public class NumericVariable  {

    public static final double VALUE_OF_PI = 3.14;

    public static void main(String[] args) {
        int i = 3;
        //3 = i; incorrect
        i = i + 3;
        //System.out.println(i);

        i = i + 2;
        i += 2;
        i = i - 2;
        i -= 2;
        i = i * 2;
        i *= 2;
        i = i / 2;
        i /= 2;
        i = i % 2;
        i %= 2;
        i = (i + 2) * 2;
        // follows PEMDAS
        i++;
        i = i + 1;      //USE THEN INCREMENT
        i--;
        i = i - 1;
        ++i;                        //INCREMENT THEN USE
        --i;

        int x = 0;
        //System.out.println(x++);
        //System.out.println(x);

        int y = 0;
        //System.out.println(++y);
        //System.out.println(y);

        int a = 5;
        int b = 2;
        int c = a / b;
        //System.out.println(c);

        double d = 3.14;
        int e = (int) d;         //Explicit casting
        System.out.println(e);

        d = e;                  //Implicit casting
        System.out.println(d);

        d = 3.14;
        e = 180;
        double f = d / e;
        System.out.println(f);

        short g = 100;
        long h = 200;
        g = (short) h;
        h = g;

        int j = 3;
        int k = 2;
        double l = (double)j/k;

        double m = Math.pow(2, 2) * Math.PI;
    }
}
