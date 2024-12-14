package EducativeCodes;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MissedSignalsCase2 {
    private static Lock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();
    private static boolean isReady = false;

    public static void main(String[] args) {
        Thread waiter = new Thread(() -> {
            lock.lock();
            try {
                System.out.println("Waiter: Waiting for signal...");
                condition.await();  // Spurious wake-up might occur here
                if (isReady) {
                    System.out.println("Waiter: Signal received!");
                } else {
                    System.out.println("Waiter: Missed the signal!");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        });

        Thread signaller = new Thread(() -> {
            lock.lock();
            try {
                System.out.println("Signaller: Sending signal...");
                isReady = true;
                condition.signal();
            } finally {
                lock.unlock();
            }
        });

        waiter.start();
        signaller.start();

    }
}
