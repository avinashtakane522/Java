package Collections;

import java.util.concurrent.*;

class Worker1 implements Runnable {

    private String worker;
    private CountDownLatch latch;

    public Worker1(String worker, CountDownLatch latch) {
        this.worker = worker;
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            System.out.println(worker+" is performing the task.");
            Thread.sleep(2000);
            System.out.println(worker+" ends the task.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally{
            latch.countDown();
        }
    }
}

public class Latch {
    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(3);
        ExecutorService service = Executors.newFixedThreadPool(3);

        for (int i = 1; i < 4; i++) {
            service.execute(new Worker1("Worker-"+i,latch));
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("All tasks executed...");
        service.shutdown();
    }
}
