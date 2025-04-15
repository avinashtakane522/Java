import java.util.*;

class Process1{

    private List<Integer> list = new ArrayList<>();
    private static final int UPPER_LIMIT = 5;
    private static final int LOWER_LIMIT = 0;
    private final Object lock = new Object();
    private int value = 0;

    public void produce() throws InterruptedException {
        synchronized (lock) {
            while (true){
                if (list.size() == UPPER_LIMIT){
                    System.out.println("Waiting to remove operation to complete...");
                    //lock.notify(); i have added here
                    lock.wait();
                }
                else {
                    list.add(++value);
                    System.out.println("Adding: "+value);      
                    lock.notify();
                }
                Thread.sleep(500);
            }
        }
    }
    public void consumer() throws InterruptedException {
        //Thread.sleep(1000);
        synchronized (lock) {
            while (true){
                if (list.size() == LOWER_LIMIT){
                    System.out.println("Waiting to adding operation to complete...");
                    value=0;
                  //lock.notify(); i have added here
                    lock.wait();
                }
                else {
                    System.out.println("Removing: "+ list.remove(list.size()-1));
                    lock.notify();
                }
                Thread.sleep(500);
            }
        }
    }
}

public class ProducerConsumer {
    public static void main(String[] args) {
        Process1 p = new Process1();

        Thread t1 = new Thread(
                new Runnable() {
                    public void run() {
                        try {
                            p.produce();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
        );
        Thread t2 = new Thread(
                new Runnable() {
                    public void run() {
                        try {
                            p.consumer();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
        );
        t1.start();
        t2.start();
    }
}
