package example.corejava.multithreading.locking;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class SharedResourceManualLock {
    private final Lock lock = new ReentrantLock();

    public void accessResource() {
        lock.lock(); // Acquire lock
        try {
            System.out.println(Thread.currentThread().getName() + " acquired lock.");
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + " released lock.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock(); // Release lock
        }
    }
}

public class ReentrantLockExample {
    public static void main(String[] args) {
        SharedResourceManualLock resource = new SharedResourceManualLock();
        Thread t1 = new Thread(() -> resource.accessResource(), "Thread-1");
        Thread t2 = new Thread(() -> resource.accessResource(), "Thread-2");

        t1.start();
        t2.start();
    }
}

