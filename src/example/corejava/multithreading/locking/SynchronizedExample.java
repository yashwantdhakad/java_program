package example.corejava.multithreading.locking;

class SharedResource {
    public void accessResource() {
        synchronized (this) {  // Lock on this object
            System.out.println(Thread.currentThread().getName() + " acquired lock.");
            try {
                Thread.sleep(1000); // Simulating work
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " released lock.");
        }
    }
}

public class SynchronizedExample {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();
        Thread t1 = new Thread(() -> resource.accessResource(), "Thread-1");
        Thread t2 = new Thread(() -> resource.accessResource(), "Thread-2");

        t1.start();
        t2.start();
    }
}

