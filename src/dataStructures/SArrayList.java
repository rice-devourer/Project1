package dataStructures;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class SArrayList<E> implements List<E> {

    private E[] arr;
    private int size;

    @SuppressWarnings("unchecked")
    public SArrayList(){
        this.size = 0;
        this.arr = (E[]) new Object[8];
    }

    //Append        O(1)
    @Override
    public boolean add(E e) {
        if(size >= arr.length) {
            grow();
        }
        arr[size] = e;
        size++;
        return true;
    }

    //Insert        O(n)
    @Override
    public void add(int index, E element) {
        if (index>size||index<0){
            throw new IndexOutOfBoundsException();
        }
        if(size >= arr.length) {
            grow();
        }
        for (int i = size;i>index;i--){
            arr[i+1] = arr[i];
        }
        arr[index] = element;
        size++;
    }

    @Override // O(n)
    public E remove(int index) {
        if (index>=size||index<0){
            throw new IndexOutOfBoundsException();
        }
        E temp = arr[index];
        for (int i = index;i<size-1;i++){
            arr[i] = arr[i+1];
        }
        size--;
        if(size <= arr.length / 4) {
            shrink();
        }
        return temp;
    }

    @Override // O(n)
    public boolean remove(Object o) {
        for (int i = 0;i<size;i++){
            if (arr[i].equals(o)) {
                remove(i);
                break;
            }
        }
        size--;
        if(size <= arr.length / 4) {
            shrink();
        }
        return true;
    }

    // O(n)
    //Call grow when the array is filled
    public void grow() {
        E[] newArr = (E[]) new Object[arr.length * 2];
        for(int i = 0; i < size; i++) {
            newArr[i] = arr[i];
        }
        arr = newArr;
    }

    // O(n)
    //Call shrink, when the capacity is 25% or less filled
    public void shrink() {
        E[] newArr = (E[]) new Object[arr.length / 2];
        for (int i = 0;i<size;i++){
            newArr[i] = arr[i];
        }
        arr = newArr;
    }

    public int capacity() {
        return arr.length;
    }

//O(1)
    @Override
    public int size() {
        return size;
    }
//O(1)
    @Override
    public boolean isEmpty() {
        return size==0;
    }
//O(1)
    @Override
    public E get(int index) {
        if (index>=size||index<0){
            throw new IndexOutOfBoundsException();
        }
        return arr[index];
    }
    //O(1)
    @Override
    public E set(int index, E element) {
        if (size>=arr.length||index>=size||index<0){
            throw new IndexOutOfBoundsException();
        }
        arr[index] = element;
        return null;
    }
//O(n)
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (int i = 0;i<size;i++){
            str.append(arr[i].toString()).append(" ");
        }

        return str.toString();
    }





    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return List.of();
    }

    //Create an array implementation of list with a fixed size n

    //Declare an integer array

    //Create a constructor to initialize the array, accept a parameter as the size of the array


    //Get

    //Search

    //Insert Before

    //Insert After

    //Remove

}
