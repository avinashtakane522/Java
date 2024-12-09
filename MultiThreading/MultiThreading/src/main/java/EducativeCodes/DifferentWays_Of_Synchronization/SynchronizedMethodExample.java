package EducativeCodes.DifferentWays_Of_Synchronization;

class SyncMethod_sr{
    private int counter=0;
    public synchronized void increment() {
        for (int i = 1; i <= 5; i++) {
            counter += i;
            System.out.println(Thread.currentThread().getName()+" : "+i);
            //Called sleep of 1000 ms
            //better observe thread interleaving and synchronization behavior during execution
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName()+" Counter final value after operation: "+counter);
    }
}

public class SynchronizedMethodExample {
    public static void main(String[] args) {
        SyncMethod_sr sr = new SyncMethod_sr();

        Thread t1 = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        sr.increment();
                    }
                } , "Thread-1"
        );

        Thread t2 = new Thread(() -> sr.increment(), "Thread-2");

        t1.start();
        t2.start();
    }
}
