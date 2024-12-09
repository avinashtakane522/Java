package EducativeCodes.DifferentWays_Of_Synchronization;

import java.util.concurrent.locks.ReentrantLock;

class Reentrant_sr{
    private final ReentrantLock lock = new ReentrantLock();

    void display(){
        lock.lock();
        System.out.println(Thread.currentThread().getName() + " aquire the lock");
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + " " + i);
                Thread.sleep(500);
            }
        }catch(InterruptedException e){
            e.printStackTrace();
        } finally {
            System.out.println(Thread.currentThread().getName() + " release the lock");
            lock.unlock();
        }
    }
}

public class ReentrantLockExample {
    public static void main(String[] args) {
        Reentrant_sr sr = new Reentrant_sr();
        Thread t1 = new Thread(sr::display, "Thread-1");
        Thread t2 = new Thread(sr::display, "Thread-2");

        t1.start();
        t2.start();
    }
}
