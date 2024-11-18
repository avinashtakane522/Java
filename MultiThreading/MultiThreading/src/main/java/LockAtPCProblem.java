import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class PCP{
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    public void produce() throws InterruptedException {
        lock.lock();
        System.out.println("Producer method...");
        condition.await();
        System.out.println("Again producer method");
        lock.unlock();
    }
    public void consume() throws InterruptedException {
        lock.lock();
        Thread.sleep(1000);
        System.out.println("Consumer method...");
        Thread.sleep(1000);
        condition.signal();
        lock.unlock();
    }
}

public class LockAtPCProblem {
    public static void main(String[] args) {
        PCP pcp = new PCP();

        Thread t1 = new Thread(
                new Runnable() {
                    public void run() {
                        try {
                            pcp.produce();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
        );
        Thread t2 = new Thread(
                new Runnable() {
                    public void run() {
                        try {
                            pcp.consume();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
        );
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
