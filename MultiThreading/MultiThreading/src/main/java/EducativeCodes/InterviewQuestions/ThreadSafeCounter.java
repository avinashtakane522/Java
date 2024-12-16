package EducativeCodes.InterviewQuestions;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadSafeCounter {
    private AtomicInteger count = new AtomicInteger(0);

    public void increment() {
        count.incrementAndGet();
    }
    public int get() {
        return count.get();
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadSafeCounter counter = new ThreadSafeCounter();
        Runnable task = new Runnable() {
            public void run() {
                for (int i = 0; i < 10; i++) {
                    counter.increment();
                }
            }
        };
        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
        System.out.println("Final counter value is: "+counter.get());
    }
}
