package example.persistent;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

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
        System.out.println("Processing: " + detail);
    }
}

// RequestProcessor class to process requests from the queue
class RequestProcessor implements Runnable {
    private final BlockingQueue<Request> queue;

    public RequestProcessor(BlockingQueue<Request> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Request request = queue.take(); // Blocking call
                request.process(); // Process the request
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Gracefully exit
        }
    }
}

public class SingleRequestQueue {
    private final BlockingQueue<Request> queue;
    private final Thread processorThread;

    public SingleRequestQueue() {
        queue = new LinkedBlockingQueue<>(); // Thread-safe queue
        processorThread = new Thread(new RequestProcessor(queue));
        processorThread.start(); // Start worker thread
    }

    public void addRequest(Request request) throws InterruptedException {
        queue.put(request); // Add request to the queue (blocking if full)
        System.out.println("Request added: " + request.getDetail());
    }

    public static void main(String[] args) throws InterruptedException {
        SingleRequestQueue queue = new SingleRequestQueue();

        // Adding requests
        queue.addRequest(new Request("Request 1"));
        queue.addRequest(new Request("Request 2"));
        queue.addRequest(new Request("Request 3"));

        // Simulating adding requests after a delay
        Thread.sleep(1000);
        queue.addRequest(new Request("Request 4"));
    }
}
