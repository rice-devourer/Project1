package dataStructures;

public class SingleLinkedList<T> {

    private T object;
    private SingleLinkedList<T> next = null;

    public SingleLinkedList(T obj) {
        this.object = obj;
    }

    public SingleLinkedList setNext(T obj) {
        next = new SingleLinkedList<T>(obj);
        return next;
    }

    public T value() {
        return object;
    }

    public SingleLinkedList<T> next() {
        return next;
    }

    //Add and remove from the same end of the list, makes it a stack
    public void remove() {
        next = null;
    }
}
