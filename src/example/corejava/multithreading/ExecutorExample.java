package example.corejava.multithreading;
import java.util.concurrent.*;

public class ExecutorExample {

    // Method 1
    public static String method1() {
        return "Method 1 executed by " + Thread.currentThread().getName();
    }

    // Method 2
    public static String method2() {
        return "Method 2 executed by " + Thread.currentThread().getName();
    }

    // Method 3
    public static String method3() {
        return "Method 3 executed by " + Thread.currentThread().getName();
    }

    public static void main(String[] args) {
        // Create a fixed thread pool with 3 threads
        ExecutorService executor = Executors.newFixedThreadPool(3);

        try {
            // Submit tasks
            Future<String> future1 = executor.submit(() -> method1());
            Future<String> future2 = executor.submit(() -> method2());
            Future<String> future3 = executor.submit(() -> method3());

            // Get results
            System.out.println(future1.get());
            System.out.println(future2.get());
            System.out.println(future3.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            // Shutdown executor
            executor.shutdown();
        }
    }
}
