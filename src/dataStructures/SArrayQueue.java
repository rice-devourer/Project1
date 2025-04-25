package dataStructures;

public class SArrayQueue<E> {

    E[] array;
    int size;
    int start;

    public SArrayQueue(){
        array = (E[]) new Object[10];
        size = 0;
        start = 0;
    }

    public boolean isEmpty() {
        return size==0;
    }

    public void enqueue(E element) {
        if(size < array.length) {
            int endIndex = (start + size) % array.length;
            array[endIndex] = element;
            size++;
        } else {
            //throws an exception or grow the array
        }
    }

    //Pop
    public E dequeue() {
        if(isEmpty()){return null;}
        E tempVar = peek();
        array[start] = null;
        size--;
        start = (start + 1) % array.length;
        return tempVar;
    }

    //Peek
    public E peek() {
        return array[start];
    }

    public void print() {
        StringBuilder s = new StringBuilder("[");
        for(int i = 0; i < size; i++) {
            s.append(array[(start + i) % array.length]).append(", ");
        }
        if(s.length()>1) s.delete(s.length()-2, s.length());
        s.append("]");
        System.out.println(s);
    }
}
