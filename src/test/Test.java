package test;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class Test {
    public static void main(String[] args) {
        Queue<String> pqueue = new PriorityQueue<>();
        pqueue.add("test");
        pqueue.add("foo");
        pqueue.add("demo");
        pqueue.add("another");
        for(String test : pqueue) {
            System.out.println("Test item: " + test);
        }
        System.out.println("\n");
        Queue<String> queue = new ArrayDeque<>();
        queue.add("test");
        queue.add("foo");
        queue.add("demo");
        for(String test : queue) {
            System.out.println("Test item: " + test);
        }
    }
}
