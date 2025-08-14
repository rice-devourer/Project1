package dataStructures;

import java.util.Comparator;

public class SHeap<E> {

    Comparator<E> comparator;
    SArrayList<E> heap = new SArrayList<>();
    public SHeap(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    public int left(int index) {
        return index*2+1;
    }

    public int right(int index) {
        return index*2+2;
    }

    public int parent(int index){
        return (index-1)/2;
    }

    public boolean haschild(int index){
        return !(left(index) > heap.size());
    }

    public void swap(int bottom){
        E temp = heap.get(bottom);
        heap.set(bottom,heap.get(parent(bottom)));
        heap.set(parent(bottom),temp);
    }


    public void insert(E element) {
        heap.add(element);
        int currentIndex = heap.size()-1;
        while (currentIndex!=0 && comparator.compare(heap.get(parent(currentIndex)),element)>0){
            swap(currentIndex);
            currentIndex = parent(currentIndex);
        }

    }

    public E removeMin() {
        E lastElement = heap.get(heap.size()-1);
        E firstElement = heap.get(0);
        int currentIndex = 0;
        heap.set(0,lastElement);
        heap.remove(heap.size()-1);
        System.out.println(haschild(currentIndex));
        System.out.println(comparator.compare(heap.get(right(currentIndex)),heap.get(currentIndex)));
        System.out.println(comparator.compare(heap.get(left(currentIndex)),heap.get(currentIndex)));
        while (haschild(currentIndex)){
            System.out.println(heap.toString());

            if (comparator.compare(heap.get(right(currentIndex)),heap.get(left(currentIndex)))>0 && comparator.compare(heap.get(right(currentIndex)),heap.get(currentIndex)) < 0 ){
                swap(left(currentIndex));
                currentIndex = left(currentIndex);
            } else if (comparator.compare(heap.get(left(currentIndex)),heap.get(currentIndex)) < 0){
                swap(right(currentIndex));
                currentIndex = right(currentIndex);
            }
        }
        System.out.println(heap.toString());
        return firstElement;
    }

    public E min() {
        return heap.get(0);
    }

    public void tostring(){
        System.out.println(heap.toString());
    }

    public static void main(String[] args){
        SHeap<Integer> heap = new SHeap<>(Comparator.comparingInt(n -> n));
        heap.tostring();
        heap.insert(4);
        heap.insert(2);
        heap.insert(7);
        heap.insert(9);
        heap.tostring();
        heap.removeMin();
        heap.tostring();
    }


}
