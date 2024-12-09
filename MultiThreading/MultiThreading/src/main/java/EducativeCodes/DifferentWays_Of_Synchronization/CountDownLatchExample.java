package EducativeCodes.DifferentWays_Of_Synchronization;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {
    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(3);

        Runnable runnable = () -> {
            try{
                Thread.sleep(500);
                System.out.println(Thread.currentThread().getName()+" completed the task.");
                latch.countDown();
            } catch (Exception e) {
                e.printStackTrace();
            }
        };
        new Thread(runnable,"Thread-1").start();
        new Thread(runnable,"Thread-2").start();
        new Thread(runnable,"Thread-3").start();

        // Main thread waits for workers to complete
        System.out.println("Main thread waiting for workers...");
        try {
            latch.await(); // Blocks until count reaches zero
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("All workers completed. Main thread proceeding.");
    }
}
