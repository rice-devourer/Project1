package dataStructures;

public class SArrayQueueTester {
    public static void main(String[] args){
        SArrayQueue<String> queue = new SArrayQueue<>();
        queue.enqueue("Hello");
        System.out.println(queue.peek());
        queue.enqueue("World");
        queue.enqueue("Ski");
        queue.print();
        queue.dequeue();
        queue.print();
        queue.enqueue("It works");
        queue.print();
        queue.dequeue();
        queue.print();
        queue.dequeue();
        queue.print();
        queue.dequeue();
    }

}
