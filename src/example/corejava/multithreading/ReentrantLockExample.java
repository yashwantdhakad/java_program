package example.corejava.multithreading;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {
    private static ReentrantLock lock = new ReentrantLock();
    private static int counter = 0;

    public static void main(String[] args) {
        Runnable task = () -> {
            lock.lock();
            try {
                counter++;
                Thread.sleep(1000);
                System.out.println("Counter: " + counter);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
        };
        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        t1.start();
        t2.start();
    }
}
