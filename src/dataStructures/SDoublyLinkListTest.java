package dataStructures;

public class SDoublyLinkListTest {

    public static void main(String[] args) {

        SDoublyLinkedList<String> list = new SDoublyLinkedList<>();

        list.insertLast("Hello");
        list.insertLast("World");
        list.insertLast("One");
        list.insertFirst("First");

        list.print();
        System.out.println();

        list.remove("Hello");

        list.print();
        System.out.println();

        System.out.println(list.get(1));

    }

}
