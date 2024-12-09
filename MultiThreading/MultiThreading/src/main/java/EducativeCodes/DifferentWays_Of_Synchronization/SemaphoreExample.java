package EducativeCodes.DifferentWays_Of_Synchronization;

import java.util.concurrent.Semaphore;

public class SemaphoreExample {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(2);

        Runnable runnable = () -> {
            try {
                System.out.println(Thread.currentThread().getName()+" waiting to aquire permit.");
                semaphore.acquire();
                System.out.println(Thread.currentThread().getName()+" aquired permit.");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(Thread.currentThread().getName()+" releasing the permit");
                semaphore.release();
            }
        };

        for (int i = 1; i <= 4; i++) {
            new Thread(runnable, "Thread-"+i).start();
        }
    }
}
