package test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(()-> "hello");

        System.out.println("Future result:" + future.get());
        future = future.thenApply(result-> result + " world");
        future.thenAccept(System.out::println);

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i=0; i< 10; i++) {
            int j =i;
            executorService.submit(() -> {
                System.out.println("Print the thread: " + Thread.currentThread().getName() + " count " + j);
            });
        }
        executorService.shutdown();

    }
}
