package EducativeCodes.DifferentWays_Of_Synchronization;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerExample {
    public static void main(String[] args) {
        AtomicInteger counter = new AtomicInteger(0);

        Runnable incrementTask = () -> {
            for (int i = 0; i < 1000; i++) {
                counter.incrementAndGet(); // Atomically increments the counter
            }
        };

        Thread t1 = new Thread(incrementTask, "Thread-1");
        Thread t2 = new Thread(incrementTask, "Thread-2");

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final Counter Value: " + counter.get());
    }
}

