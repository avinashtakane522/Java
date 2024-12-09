package EducativeCodes;

public class MesaMonitorExample {
    public static void main(String[] args) {
        Object lock = new Object(); // Shared resource

        Thread producer = new Thread(() -> {
            synchronized (lock) {
                System.out.println("Producer is producing...");
                lock.notify(); // Notify waiting threads
                System.out.println("Producer notified!");
            }
        });

        Thread consumer = new Thread(() -> {
            synchronized (lock) {
                try {
                    System.out.println("Consumer is waiting...");
                    lock.wait(); // Wait for a signal
                    System.out.println("Consumer resumed!");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        consumer.start();
        try { Thread.sleep(100); } catch (InterruptedException e) {}
        producer.start();
    }
}

