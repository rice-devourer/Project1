package dataStructures;

public class SArrayStackTester {

    public static void main(String[] args) {
        SArrayStack<String> stack = new SArrayStack<>();
        System.out.println(stack.pop());
        stack.push("One");
        stack.push("Two");
        stack.push("Three");
        stack.push("Four");
        stack.print();
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        stack.print();
    }

}
