package example.persistent;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

// Request class to represent a request with details
class Request {
    private final String detail;

    public Request(String detail) {
        this.detail = detail;
    }

    public String getDetail() {
        return detail;
    }

    public void process() {
        // Simulate processing
        System.out.println("Processing: " + detail);
        try {
            Thread.sleep(500); // Simulate work
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

// RequestProcessor class to process requests from the queue
class RequestProcessor implements Runnable {
    private final BlockingQueue<Request> queue;
    private final AtomicBoolean running;

    public RequestProcessor(BlockingQueue<Request> queue, AtomicBoolean running) {
        this.queue = queue;
        this.running = running;
    }

    @Override
    public void run() {
        try {
            while (running.get()) {
                Request request = queue.take(); // Blocking call
                try {
                    request.process(); // Process the request
                } catch (Exception e) {
                    System.err.println("Error processing request: " + e.getMessage());
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("RequestProcessor interrupted");
        }
    }
}

public class A7SingleRequestQueue {
    private final BlockingQueue<Request> queue;
    private final Thread processorThread;
    private final AtomicBoolean running;

    public A7SingleRequestQueue(int capacity) {
        if (capacity <= 0) throw new IllegalArgumentException("Capacity must be positive");
        queue = new LinkedBlockingQueue<>(capacity); // Bounded queue
        running = new AtomicBoolean(true);
        processorThread = new Thread(new RequestProcessor(queue, running), "RequestProcessorThread");
    }

    public void start() {
        processorThread.start();
        System.out.println("Request processor started");
    }

    public void addRequest(Request request) throws InterruptedException {
        if (request == null) throw new IllegalArgumentException("Request cannot be null");
        if (!running.get()) throw new IllegalStateException("Queue is shut down");
        queue.put(request); // Add request to the queue (blocking if full)
        System.out.println("Request added: " + request.getDetail());
    }

    public void shutdown() {
        running.set(false);
        processorThread.interrupt(); // Interrupt the thread to stop blocking take()
        System.out.println("Request processor shut down");
    }

    public static void main(String[] args) throws InterruptedException {
        A7SingleRequestQueue queue = new A7SingleRequestQueue(2); // Bounded queue with capacity 2
        queue.start();

        // Adding requests
        queue.addRequest(new Request("Request 1"));
        queue.addRequest(new Request("Request 2"));
        queue.addRequest(new Request("Request 3")); // Blocks if queue is full (capacity 2)

        // Simulating adding requests after a delay
        Thread.sleep(2000);
        queue.addRequest(new Request("Request 4"));

        // Shutdown after a delay
        Thread.sleep(2000);
        queue.shutdown();
    }
}