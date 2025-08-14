package dataStructures;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class DequeTester {

    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();
        Queue<Integer> queue = new ArrayDeque<>();

        deque.addFirst(1);
        deque.addLast(2);
        int first = deque.pollFirst();
        int last = deque.pollLast();

        queue.offer(1);
        int front = queue.poll();
    }
}
