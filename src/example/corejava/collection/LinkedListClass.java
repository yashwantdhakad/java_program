package example.corejava.collection;

// Java program to demonstrate the
// working of LinkedList

import java.util.LinkedList;
import java.util.List;

class LinkedListClass {

    // Main Method
    public static void main(String[] args)
    {

        // Declaring the LinkedList
        List<Integer> ll = new LinkedList<>();

        // Appending new elements at
        // the end of the list
        for (int i = 1; i <= 5; i++)
            ll.add(i);

        // Printing elements
        System.out.println(ll);

        // Remove element at index 3
        ll.remove(3);

        // Displaying the List
        // after deletion
        System.out.println(ll);

        // Printing elements one by one
        for (Integer integer : ll) System.out.print(integer + " ");
    }
}
