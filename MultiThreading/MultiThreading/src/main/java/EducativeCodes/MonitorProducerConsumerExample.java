package EducativeCodes;

class SharedResource {
    private int data;
    private boolean isDataAvailable = false; // Monitor condition

    // Producer produces data
    public synchronized void produce(int value) {
        while (isDataAvailable) { // Wait if data is already available
            try {
                wait(); // Release the lock and wait
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        data = value;
        isDataAvailable = true; // Mark data as available
        System.out.println("Produced: " + data);
        notify(); // Notify waiting threads
    }

    // Consumer consumes data
    public synchronized void consume() {
        while (!isDataAvailable) { // Wait if no data is available
            try {
                wait(); // Release the lock and wait
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("Consumed: " + data);
        isDataAvailable = false; // Mark data as consumed
        notify(); // Notify waiting threads
    }
}

public class MonitorProducerConsumerExample {
    public static void main(String[] args) {
        SharedResource shared = new SharedResource();

        // Producer thread
        Thread producer = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                shared.produce(i);
            }
        });

        // Consumer thread
        Thread consumer = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                shared.consume();
            }
        });

        producer.start();
        consumer.start();
    }
}

