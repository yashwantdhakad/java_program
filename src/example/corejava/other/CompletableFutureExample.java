package example.corejava.other;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;

public class CompletableFutureExample {
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        // 1. Async task
        CompletableFuture<String> greetFuture = CompletableFuture.supplyAsync(() -> {
            sleep(500);
            return "Hello";
        });

        // 2. Transform result
        CompletableFuture<String> upperCaseFuture = greetFuture.thenApply(greeting -> {
            return greeting.toUpperCase();  // transforms to "HELLO"
        });

        // 3. Chain tasks
        CompletableFuture<String> fullMessageFuture = upperCaseFuture.thenCompose(upper -> {
            return CompletableFuture.supplyAsync(() -> {
                return upper + ", CompletableFuture!";
            });
        });

        // 4. Run side-effect
        fullMessageFuture.thenAccept(System.out::println);  // prints "HELLO, CompletableFuture!"

        // 5. Combine two futures
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> 10);
        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> 20);

        CompletableFuture<Integer> combined = future1.thenCombine(future2, (a, b) -> a + b);
        combined.thenAccept(sum -> System.out.println("Sum: " + sum));  // prints "Sum: 30"

        // 6. Run something after both complete
        CompletableFuture<Void> bothDone = CompletableFuture.allOf(fullMessageFuture, combined);
        bothDone.thenRun(() -> System.out.println("Both tasks completed."));

        // 7. Exception handling
        CompletableFuture<String> errorHandled = CompletableFuture.supplyAsync(() -> {
            if (true) throw new RuntimeException("Oops!");
            return "Won't happen";
        }).exceptionally(ex -> {
            System.out.println("Handled error: " + ex.getMessage());
            return "Fallback result";
        });

        System.out.println("Error handled result: " + errorHandled.get()); // prints fallback

        // Wait for all to finish
        Thread.sleep(2000);
    }

    private static void sleep(long millis) {
        try { Thread.sleep(millis); } catch (InterruptedException e) {}
    }
}
