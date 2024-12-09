package EducativeCodes.DifferentWays_Of_Synchronization;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, () -> System.out.println("All threads reached the barrier. Proceeding..."));

        Runnable runnable = () -> {
            try {
                System.out.println(Thread.currentThread().getName()+" reached the barrier.");
                cyclicBarrier.await();
                System.out.println(Thread.currentThread().getName()+" proceeding...");
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        };

        new Thread(runnable, "Thread-1").start();
        new Thread(runnable, "Thread-2").start();
        new Thread(runnable, "Thread-3").start();
    }
}
