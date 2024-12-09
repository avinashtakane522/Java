package EducativeCodes.DifferentWays_Of_Synchronization;

class SyncBlock_sr{
    private int counter=0;
    public void increment() {
        for (int i = 1; i <= 5; i++) {
            synchronized (this) {
                counter += i;
                System.out.println(Thread.currentThread().getName() + " : " + i);
                //we can call sleep here for
                //better observe thread interleaving and synchronization behavior during execution
            }
        }
        System.out.println(Thread.currentThread().getName()+" Counter final value after operation: "+counter);
    }
}

public class SynchronizationBlockExample {
    public static void main(String[] args) {
        SyncBlock_sr sr = new SyncBlock_sr();

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
