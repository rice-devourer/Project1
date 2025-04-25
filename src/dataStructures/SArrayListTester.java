package dataStructures;

import java.util.ArrayList;

public class SArrayListTester {

    public static void main(String[] args) {
        SArrayList<Integer> list = new SArrayList<>();
        for(int i=0; i<=15; i++) {
            list.add(i);
        }
        System.out.println(list.toString());
        System.out.println("Capacity: " + list.capacity() + " \tSize: " + list.size());
        list.add(16);
        System.out.println(list.toString());
        System.out.println("Capacity: " + list.capacity() + " \tSize: " + list.size());
        for(int i=0; i<8; i++) {
            list.remove(0);
        }
        System.out.println(list.toString());
        System.out.println("Capacity: " + list.capacity() + " \tSize: " + list.size());
        list.remove(0);
        System.out.println(list.toString());
        System.out.println("Capacity: " + list.capacity() + " \tSize: " + list.size());
    }
}
