package example.corejava.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorFrameworkExample {
    public static void inventoryMethod(int i) {
        System.out.println("Inventory method calling: " + i + " : " + Thread.currentThread().getName());
    }
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(4);
        for(int i = 0; i < 10; i++) {
            int finalI = i;
            executor.submit(()-> inventoryMethod(finalI));
        }

        executor.shutdown();
    }
}
