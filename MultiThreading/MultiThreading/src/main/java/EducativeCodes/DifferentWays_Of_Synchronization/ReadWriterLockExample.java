package EducativeCodes.DifferentWays_Of_Synchronization;

import java.util.concurrent.locks.ReentrantReadWriteLock;

class ReadWriter_sr{
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    void read(){
        lock.readLock().lock();

        try {
            System.out.println(Thread.currentThread().getName()+" reading...");
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.readLock().unlock();
        }
    }

    void write(){
        lock.writeLock().lock();

        try {
            System.out.println(Thread.currentThread().getName()+" writing...");
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.writeLock().unlock();
        }
    }
}

public class ReadWriterLockExample {
    public static void main(String[] args) {
        ReadWriter_sr rw = new ReadWriter_sr();
        Runnable readTask = rw::read;
        Runnable writeTask = rw::write;

        Thread t1 = new Thread(readTask,"Thread-1");
        Thread t2 = new Thread(readTask,"Thread-2");
        Thread t3 = new Thread(() -> rw.read(), "Thread-3");
        Thread t4 = new Thread(writeTask, "Thread-4");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
