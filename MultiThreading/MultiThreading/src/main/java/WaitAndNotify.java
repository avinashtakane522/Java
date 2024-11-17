class Process{
    public void produce() throws InterruptedException {
        synchronized (this) {
            System.out.println("Running the producer method...");
            wait();
            System.out.println("Again in the producer method...");
        }
    }
    public void consumer() throws InterruptedException {
        //Thread.sleep(1000);
        synchronized (this) {
            System.out.println("Consumer block executed...");
            notify();
            Thread.sleep(2000);       }
    }
}

public class WaitAndNotify {
    public static void main(String[] args) {
        Process p = new Process();

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
