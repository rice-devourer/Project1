package dataStructures;

import dataStructures.comparator.StringComparator;

import java.util.Arrays;

public class StringSort {

    public static void main(String[] args) {
        String[] arr = {"giraffe", "computer", "painting", "river", "galaxy", "notebook", "bicycle", "wizard",
                "pineapple", "thunder", "mountain", "umbrella", "echo", "cactus", "balloon", "rainbow", "library",
                "spaceship", "telescope", "piano", "ocean"};
        System.out.println(Arrays.toString(arr));
        //sort(arr);
        //Arrays.sort(arr, new StringComparator());

        //lambda
        Arrays.sort(arr, ((o1, o2) -> {
            //if comparison takes more than one line
            return o1.substring(o1.length()-1).compareTo(o2.substring(o2.length()-1));
        }));
        System.out.println(Arrays.toString(arr));
        //System.out.println(validateLengthSort(arr) ? "The sort is correct" : "The sort is incorrect");
    }

    public static boolean compare(String str1, String str2){
        if (str1.substring(str1.length()-1).compareTo(str2.substring(str2.length()-1)) > 0){
            return true;
        }return false;
    }

    public static String[] sort(String[] strings){
        int size = strings.length;
        boolean switched;
        for (int i = 0; i<size-1;i++){
            switched = false;
            for (int j = 0; j<size-i-1;j++){
                if(compare(strings[j],strings[j+1])) {
                    String temp = strings[j];
                    strings[j] = strings[j+1];
                    strings[j+1] = temp;
                    switched = true;
                }
            } if (!switched){
                break;
            }
        }


        return strings;
    }

    public static boolean validateLengthSort(String[] arr) {
        for(int i=0; i<arr.length-1; i++) {
            if(false) return false;
        }
        return true;
    }
}
