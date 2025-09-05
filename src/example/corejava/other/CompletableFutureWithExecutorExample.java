package example.corejava.other;

import java.util.concurrent.*;

public class CompletableFutureWithExecutorExample {
    public static void main(String[] args) throws Exception {

        // 1. Create a custom ExecutorService with 3 threads
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // 2. Use it in CompletableFuture
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + " - Task 1 starting...");
            sleep(1000);
            return "Result from Task 1";
        }, executor);

        // 3. Chain with thenApplyAsync using same executor
        CompletableFuture<String> chainedFuture = future.thenApplyAsync(result -> {
            System.out.println(Thread.currentThread().getName() + " - Task 2 starting...");
            return result + " + Task 2 processed";
        }, executor);

        // 4. Final step
        String finalResult = chainedFuture.get(); // Blocking call to get result
        System.out.println("Final Result: " + finalResult);

        // 5. Shutdown the executor
        executor.shutdown();
    }

    private static void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

