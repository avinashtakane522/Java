package EducativeCodes;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class MutexExample {
    private final Lock lock = new ReentrantLock();

    public void criticalSection() {
        lock.lock(); // Acquire the lock (like a mutex)
        try {
            System.out.println(Thread.currentThread().getName() + " is in critical section");
        } finally {
            lock.unlock(); // Release the lock
        }
    }
}

public class MutexDemo {
    public static void main(String[] args) {
        MutexExample mutexExample = new MutexExample();

        Runnable task = () -> mutexExample.criticalSection();

        Thread t1 = new Thread(task, "Thread 1");
        Thread t2 = new Thread(task, "Thread 2");

        t1.start();
        t2.start();
    }
}

