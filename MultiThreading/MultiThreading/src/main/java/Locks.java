import java.util.concurrent.locks.*;

public class Locks {
    private final Lock lock = new ReentrantLock();
    private static int counter = 0;

    void increment() {
        lock.lock();
        try{
            for (int i=0; i<10000; i++) {
                counter++;
            }
            System.out.println(Thread.currentThread().getName()+" increment counter to : "+counter);
        }
        finally {
            lock.unlock();
        }
    }
    public static void main(String[] args) {
        Locks locks = new Locks();

        //First way to pass runnable obj without written anonymous function
        Runnable runnable = locks::increment;
        Thread t1 = new Thread(runnable, "Thread-1");

        //Second way to pass runnable obj without written anonymous function and without use runnable obj
        Thread t2 = new Thread(locks::increment,"Thread-2");
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final count is : "+counter);
        //The Thread class has an overloaded constructor that accepts a Runnable as a
        // parameter: Thread(Runnable target, String name).
        //When you pass locks::increment directly to new Thread(), it is treated as a Runnable
        // because method references are compatible with functional interfaces
        // (and Runnable is a functional interface with a single run() method).
    }
}
