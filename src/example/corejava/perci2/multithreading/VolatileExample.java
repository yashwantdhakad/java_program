package example.corejava.perci2.multithreading;

import java.util.concurrent.atomic.AtomicInteger;

public class VolatileExample {
    private volatile int counter = 0;
    AtomicInteger integer = new AtomicInteger();

    class CustomThread implements Runnable {
        @Override
        public void run() {
            for (int i =0; i < 1000; i++) {
                counter++;
                integer.incrementAndGet();
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        VolatileExample example = new VolatileExample();
        Thread t1 = new Thread(example.new CustomThread());
        Thread t2 = new Thread(example.new CustomThread());
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Final counter: " + example.counter);
        System.out.println("Final atomic integer: " + example.integer.get());
    }
}
