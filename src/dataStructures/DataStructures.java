package dataStructures;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class DataStructures {

    public static void main(String[] args) {
        /*
        SingleLinkedList<String> root = new SingleLinkedList<>("First Object");
        SingleLinkedList<String> obj2 = root.setNext("Second Object");
        obj2.setNext("Third object");

        SingleLinkedList<String> node = root;

        while(node.next()!=null) {
            System.out.println(node.value());
            node = node.next();
        }
        */

        Map<String, String> idMap = new HashMap<String, String>();
        idMap.put("123", "John");
        idMap.put("321", "Joe");
        idMap.put("345", "Jay");
        idMap.put("123", "John2");

        Set<String> keys = idMap.keySet();
        for(String key : idMap.keySet()) {
            System.out.println("The name corresponding to " + key + " is " + idMap.get(key));
        }

        idMap.remove("123");

        Iterator<String> iterator = idMap.keySet().iterator();
        while(iterator.hasNext()) {
            String key = iterator.next();
            System.out.println("The name corresponding to " + key + " is " + idMap.get(key));
        }
    }

    //Linear vs Non-Linear
    //Static vs Dynamic
        //Static fixed size
        //Dynamic can be resized

    //Arrays are linear and static
    //ArrayList is linear dynamic

    //Linear
    //List
        //Sequential list of objects
        //Each object has an index
        //ArrayList

    //Linked List
        //Every object contains a reference to the next object
    //Doubly Linked List
        //Every object contains references to the previous and next object
        //LinkedList

    //Queue
        //First in, First out (FIFO)
        //Add at one end of the queue, remove from the other end of the queue

    //Stack
        //Last in, First out (LIFO)
        //Add at one end of the stack, remove from the same end

    //Deque
        //Double Ended queue
        //Add or remove from either end of the Deque
        //ArrayDeque

    //Set
        //Non ordered list of objects
        //Cannot contain duplicate objects
        //Cannot be accessed with an index
        //HashSet

    //Map
        //A list of key-value pairs
        //HashMap


    //Nonlinear
        //Tree
            //TreeMap
        //Graph
}
