import java.io.File;

public class StringOperations {
    public static void main(String[] args) {
        String a = "hello world";
        String b = "goodbye world";
        String c;
        c = a+" "+b;
        //System.out.println(c);
        int newInt = a.length();
        boolean bool = true;
        System.out.println(newInt);
        String substring1 = a.substring(6); // return a string with everything starting at index 6
        String substring2 = a.substring(6, 9); // return a string with everything starting at index 6, up to but not including index 9
        //System.out.println(substring1 + " " + substring2);
        //System.out.println(a.toUpperCase());
        //System.out.println(a.toLowerCase());
        //System.out.println("The string " + a + " has a length of " + newInt + " " + bool);
        char chr = a.charAt(0);
        char[] chrArr = a.toCharArray();

        String d = "Hi,\nThis is a new line";
        String e = " \"Hello World\" \n\t- some random computer guy ";
        String path = "C:\\folder";
        char separator = File.separatorChar;
        String path2 = "C:" + File.separator + "folder";
        System.out.println(e);
    }
}
