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
        if(size >= array.length) {
            grow();
        }
        int endIndex = (start + size) % array.length;
        array[endIndex] = element;
        size++;
    }

    //Pop
    public E dequeue() {
        if(isEmpty()){return null;}
        E tempVar = peek();
        array[start] = null;
        size--;
        start = (start + 1) % array.length;
        if(size < array.length / 4) {
            shrink();
        }
        return tempVar;
    }

    //Peek
    public E peek() {
        return array[start];
    }

    //Grow
    public void grow() {
        E[] newArr = (E[]) new Object[array.length * 2];
        for(int i = 0; i < size; i++) {
            newArr[i] = array[(start + i) % array.length];
        }
        array = newArr;
        start = 0;
    }

    //Shrink
    public void shrink() {
        E[] newArr = (E[]) new Object[array.length / 2];
        for (int i = 0;i<size;i++){
            newArr[i] = array[(start + i) % array.length];
        }
        array = newArr;
        start = 0;
    }

    public int capacity() {
        return array.length;
    }

    public int size() {
        return size;
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
