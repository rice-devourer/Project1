import java.io.*;
import java.util.*;

public class KeyboardInputs {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        //int i = sc.nextInt();
        String word = null;
        //sc.useDelimiter(".");
        //"Hello.World!"
        //String line = sc.nextLine();
        System.out.println("Please enter a number: ");
        int convert = 0;
        boolean flag = true;

        //GATHER INPUT
        while (flag){
            try{
                word = sc.next();
                convert = Integer.parseInt(word);
                flag = false;
            } catch (NumberFormatException n) {
                System.out.println("Please enter valid number");
            }
        }


        System.out.println("You have entered " + convert);
    }
}
