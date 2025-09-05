package example.corejava.multithreading;

public class ThreadPriorityExample {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> System.out.println("High priority thread"));
        Thread t2 = new Thread(() -> System.out.println("Low priority thread"));
        t1.setPriority(Thread.MIN_PRIORITY);
        t2.setPriority(Thread.MAX_PRIORITY);
        t1.start();
        t2.start();
    }
}