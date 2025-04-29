package example.corejava;

public class ThreadUsingRunnable {
    static class MyThread implements Runnable {

        @Override
        public void run() {
            System.out.println("My Thread is running");
        }
    }
    public static void main(String[] args) {
        Thread thread = new Thread(new MyThread());
        thread.start();
    }
}

