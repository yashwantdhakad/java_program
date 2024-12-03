package example.corejava.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class InventoryService {
    // Method to process a single inventory item
    public void processInventory(String inventoryItem) {
        System.out.println("Processing inventory: " + inventoryItem + " on thread: " + Thread.currentThread().getName());
        try {
            // Simulate some processing work, e.g., updating inventory details in a database
            Thread.sleep(1000); // Simulate time-consuming task
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Inventory processing was interrupted for: " + inventoryItem);
        }
    }
}

public class MultiThread {
    public static void main(String[] args) {
        // List of inventory records to be processed
        List<String> inventoryRecords = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            inventoryRecords.add("InventoryItem" + i);
        }

        // Create an instance of the service
        InventoryService inventoryService = new InventoryService();

        // Create a fixed thread pool with 5 threads
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        // Submit inventory processing tasks to the executor service
        for (String inventoryItem : inventoryRecords) {
            executorService.submit(() -> inventoryService.processInventory(inventoryItem));
        }

        // Shut down the executor service
        executorService.shutdown();
    }
}
