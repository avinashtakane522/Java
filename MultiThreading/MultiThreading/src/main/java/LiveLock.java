import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LiveLock {
    private Lock lock1 = new ReentrantLock(true);
    private Lock lock2 = new ReentrantLock(true);
    public static void main(String[] args) {
        LiveLock deadLock = new LiveLock();
        new Thread(deadLock::worker1).start();
        new Thread(deadLock::worker2).start();
    }

    public void worker1(){
        while(true){
            try {
                lock1.tryLock(50, TimeUnit.MILLISECONDS);
                System.out.println("worker1 acquired lock1...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("worker1 tries to acquire lock2...");
            if (lock2.tryLock()) {
                System.out.println("worker1 acquired lock2...");
            }else {
                System.out.println("worker1 not acquired lock2...");
                continue;
            }
            break;
        }
    }

    public void worker2(){
        while(true){
            try {
                lock2.tryLock(50, TimeUnit.MILLISECONDS);
                System.out.println("worker2 acquired lock2...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("worker2 tries to acquire lock1...");
            if (lock1.tryLock()) {
                System.out.println("worker2 acquired lock1...");
            }else {
                System.out.println("worker2 not acquired lock1...");
                continue;
            }
            break;
        }
    }
}

