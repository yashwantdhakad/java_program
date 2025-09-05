package example.corejava.perci2.multithreading;

public class ThreadLocalExample {
    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        Runnable task = () -> {
            threadLocal.set(Thread.currentThread().getName());
            System.out.println("Thread local: " + Thread.currentThread().getName() + " has value:" + threadLocal.get());
        };

        new Thread(task).start();
        new Thread(task).start();
    }
}
