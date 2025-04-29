package example.corejava.multithreading.locking;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class SharedResourceTryLock {
    private final Lock lock = new ReentrantLock();

    public void accessResource() {
        if (lock.tryLock()) {  // Try acquiring the lock
            try {
                System.out.println(Thread.currentThread().getName() + " acquired lock.");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
                System.out.println(Thread.currentThread().getName() + " released lock.");
            }
        } else {
            System.out.println(Thread.currentThread().getName() + " could not acquire lock.");
        }
    }
}

public class TryLockExample {
    public static void main(String[] args) {
        SharedResourceTryLock resource = new SharedResourceTryLock();
        Thread t1 = new Thread(resource::accessResource, "Thread-1");
        Thread t2 = new Thread(resource::accessResource, "Thread-2");

        t1.start();
        t2.start();
    }
}
