package dataStructures;

public class ListTester {

    public static void main(String[] args) {

        SArrayList<Integer> sArrayList = new SArrayList<>();
        System.out.println("1: " + sArrayList.toString());
        sArrayList.add(1);
        System.out.println("2: " + sArrayList.toString());
        sArrayList.add(2);
        sArrayList.add(3);
        sArrayList.add(4);
        sArrayList.add(5);
        sArrayList.add(6);
        sArrayList.add(7);
        sArrayList.add(8);
        System.out.println("3: " + sArrayList.toString());
        sArrayList.remove(0);
        System.out.println("4: " + sArrayList.toString());
        sArrayList.remove(3);
        System.out.println("5: " + sArrayList.toString());
        sArrayList.add(5, 11);
        System.out.println("6: " + sArrayList.toString());
        System.out.println("The item at index 4 is " + sArrayList.get(4));
    }
}
