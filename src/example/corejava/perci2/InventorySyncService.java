package example.corejava.perci2;

import java.util.*;
import java.util.concurrent.*;

public class InventorySyncService {

    private static final int THREAD_POOL_SIZE = 10;
    private final ExecutorService executorService;

    public InventorySyncService() {
        this.executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
    }

    // Simulated method to fetch external inventory data
    private void syncInventoryItem(String itemId) {
        // Simulate API call delay
        try {
            System.out.println("Syncing item: " + itemId + " by " + Thread.currentThread().getName());
            Thread.sleep(500); // Simulate latency
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void syncAllInventory(List<String> itemIds) {
        List<Callable<Void>> tasks = new ArrayList<>();

        for (String itemId : itemIds) {
            tasks.add(() -> {
                try {
                    syncInventoryItem(itemId);
                } catch (Exception e) {
                    System.err.println("Failed to sync item: " + itemId);
                }
                return null;
            });
        }

        try {
            // Execute all tasks and wait for completion
            List<Future<Void>> futures = executorService.invokeAll(tasks);

            for (Future<Void> future : futures) {
                future.get(); // This will rethrow any exception occurred inside the task
            }

            System.out.println("All items synced successfully.");
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
    }

    public static void main(String[] args) {
        InventorySyncService service = new InventorySyncService();
        List<String> inventoryItems = Arrays.asList("SKU1", "SKU2", "SKU3", "SKU4", "SKU5",
                "SKU6", "SKU7", "SKU8", "SKU9", "SKU10");
        service.syncAllInventory(inventoryItems);
    }
}
