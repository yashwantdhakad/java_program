package example.corejava.multithreading;

class Thread1 extends Thread {
    public void run() {
        System.out.println("Thread 1 is running-" + Thread.currentThread().getName());
    }
}
public class CustomThread {
    public static void main(String[] args) {
        Thread1 thread1 = new Thread1();
        thread1.run();
        thread1.start();
    }
}

