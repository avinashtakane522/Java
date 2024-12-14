package EducativeCodes;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MissedSignalsCorrectWithWhileLoop {
    private static final Lock lock = new ReentrantLock();
    private static final Condition condition = lock.newCondition();
    private static boolean isReady = false;

    public static void main(String[] args) {
        Thread waiter = new Thread(() -> {
            lock.lock();
            try {
                while (!isReady) {  // Check condition in a while loop
                    System.out.println("Waiter: Waiting for signal...");
                    condition.await();
                }
                System.out.println("Waiter: Signal received!");
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
