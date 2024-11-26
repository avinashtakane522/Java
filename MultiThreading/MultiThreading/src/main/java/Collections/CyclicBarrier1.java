package Collections;

import java.util.concurrent.*;

class Worker2 implements Runnable {
    private int id;
    private CyclicBarrier barrier;

    public Worker2(int id, CyclicBarrier barrier) {
        this.id = id;
        this.barrier = barrier;
    }

    @Override
    public void run() {
        doWork();
    }

    public void doWork(){
        System.out.println("The current thead with "+id+" id is working now");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            barrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println("The current thead with "+id+" id is Completed");
    }
}

public class CyclicBarrier1 {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(3);

        CyclicBarrier barrier = new CyclicBarrier(3, new Runnable() {
            @Override
            public void run(){
                System.out.println("All tasks are completed...");
            }
        });

        for (int i = 0; i < 3; i++) {
           service.execute(new Worker2(i+1, barrier));
        }
        service.shutdown();
    }
}
