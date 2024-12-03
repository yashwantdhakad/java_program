package example.corejava.collection;

// Java program to demonstrate the
// working of ArrayList
import java.io.*;
import java.util.*;

class ArrList {

    // Main Method
    public static void main(String[] args)
    {

        // Declaring the ArrayList with
        // initial size n
        ArrayList<Integer> al = new ArrayList<>();

        // Appending new elements at
        // the end of the list
        for (int i = 1; i <= 5; i++)
            al.add(i);

        // Printing elements
        System.out.println(al);

        // Remove element at index 3
        al.remove(3);

        // Displaying the ArrayList
        // after deletion
        System.out.println(al);

        // Printing elements one by one
        for (int i = 0; i < al.size(); i++)
            System.out.print(al.get(i) + " ");
    }
}
