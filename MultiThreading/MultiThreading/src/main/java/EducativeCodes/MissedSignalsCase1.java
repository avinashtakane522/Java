package EducativeCodes;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MissedSignalsCase1 {
    private static Lock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();
//    private static boolean isReady = false;

    public static void main(String[] args) {
        Thread signaller = new Thread(() -> {
            lock.lock();
            try {
                System.out.println("Signaller: Sending signal...");
                condition.signal();  // Signal sent before waiter starts waiting
            } finally {
                lock.unlock();
            }
        });

        Thread waiter = new Thread(() -> {
            lock.lock();
            try {
                System.out.println("Waiter: Waiting for signal...");
                condition.await();  // Waiter starts waiting AFTER the signal is sent
                System.out.println("Waiter: Signal received!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        });

        signaller.start();  // Signaller starts first
        waiter.start();     // Waiter starts after the signal is sent

    }
}
