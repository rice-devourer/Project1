package dataStructures;

public class SDoublyLinkedList<E> {

    protected final Node<E> header;
    protected final Node<E> trailer;
    protected int size;

    public SDoublyLinkedList() {
        header = new Node<>(null);
        trailer = new Node<>(null);
        header.setNext(trailer);
        trailer.setPrev(header);
        size = 0;
    }

    // get
    public E get(int index) {
        Node<E> current = header.getNext();
        for(int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current.getValue();
    }
    // get (positional list)
    public E get(Node<E> p) {
        return p.getValue();
    }

    // search
    public Node<E> findFirst(E obj) {
        Node<E> current = header.getNext();
        while(!current.equals(trailer)) {
            if(obj == null) {
                if(current.getValue() == null) return current;
            } else {
                if(obj.equals(current.getValue())) return current;
            }
            current = current.getNext();
        }
        return null;
    }
    // insert
    public void insertFirst(E obj) {
        insertBetween(obj, header, header.getNext());
    }
    public void insertLast(E obj) {
        insertBetween(obj, trailer.getPrev(), trailer);
    }
    public void insertBefore(E obj, Node<E> p) {
        insertBetween(obj, p.getPrev(), p);
    }
    public void insertAfter(E obj, Node<E> p) {
        insertBetween(obj, p, p.getNext());
    }
    // Insert between two adjacent nodes
    public void insertBetween(E obj, Node<E> prev, Node<E> next) {
        Node<E> newNode = new Node<>(obj);
        newNode.setPrev(prev);
        prev.setNext(newNode);
        newNode.setNext(next);
        next.setPrev(newNode);
        size++;
    }

    public E remove(E obj) {
        return remove(findFirst(obj));
    }
    // remove
    public E remove(Node<E> p) {
        p.getPrev().setNext(p.getNext());
        p.getNext().setPrev(p.getPrev());
        size--;
        return p.getValue();
    }

    public E first() {
        if(isEmpty()) return null;
        return header.getNext().getValue();
    }

    public E last() {
        if(isEmpty()) return null;
        return trailer.getPrev().getValue();
    }

    public int size() {
        return size;
    }
    public boolean isEmpty() {
        return size == 0;
    }

    public void print() {
        Node<E> node = header.getNext();
        while(node!=trailer){
            System.out.println(node.getValue());
            node = node.getNext();
        }
    }

    private static class Node<E> {
        private E value;
        private Node<E> prev = null;
        private Node<E> next = null;

        public Node(E value) {
            this.value = value;
        }

        //getters and setters
        public E getValue() {
            return value;
        }
        public Node<E> getNext() {
            return next;
        }
        public Node<E> getPrev() {
            return prev;
        }

        public void setValue(E value) {
            this.value = value;
        }
        public void setNext(Node<E> next) {
            this.next = next;
        }
        public void setPrev(Node<E> prev) {
            this.prev = prev;
        }
    }
}
