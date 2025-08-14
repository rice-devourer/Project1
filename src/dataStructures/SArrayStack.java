package dataStructures;

public class SArrayStack<E> {
    E[] array;
    int size;

    //Create a stack using an array with a size of 10
    public SArrayStack(){
        array = (E[]) new Object[10];
        size = 0;
    }

    //Array declaration

    //Constructor

    //Push
    public void push(E element) {
        if (size >= 10) {
            grow();
        }
        array[size] = element;
        size++;
    }

    //Pop
    public E pop() {
        if(size==0){
            return null;
        }
        E tempVar = array[size-1];
        array[size-1] = null;
        size--;
        if (array.length/4>size){
            shrink();
        }
        return tempVar;
    }

    //Peek
    public E peek() {
        if (size!=0){
            return array[size-1];
        }
        return null;
    }

    //Grow
    public void grow() {
        E[] newArr = (E[]) new Object[array.length * 2];
        for(int i = 0; i < size; i++) {
            newArr[i] = array[i];
        }
        array = newArr;
    }

    //Shrink
    public void shrink() {
        E[] newArr = (E[]) new Object[array.length / 2];
        for (int i = 0;i<size;i++){
            newArr[i] = array[i];
        }
        array = newArr;
    }

    public int capacity() {
        return array.length;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public int size() {
        return size;
    }

    public void print() {
        StringBuilder s = new StringBuilder("[");
        for(int i = 0; i<size; i++) {
            s.append(array[i]).append(", ");
        }
        if(s.length()>1) s.delete(s.length()-2, s.length());
        s.append("]");
        System.out.println(s);
    }
}
