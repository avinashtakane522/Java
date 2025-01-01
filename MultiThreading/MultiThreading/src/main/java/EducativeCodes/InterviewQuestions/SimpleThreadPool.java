package EducativeCodes.InterviewQuestions;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class SimpleThreadPool {
    private BlockingQueue<Runnable> taskQueue;
    private PoolWorkers[] workers;
    private int poolSize;

    public SimpleThreadPool(int poolSize) {
        this.poolSize = poolSize;
        taskQueue = new LinkedBlockingQueue<>();
        workers = new PoolWorkers[poolSize];

        for (int i = 0; i < poolSize; i++) {
            workers[i] = new PoolWorkers();
            workers[i].setName("Worker-" + i);
            workers[i].start();
        }
    }

    public void submit(Runnable task) {
        try {
            taskQueue.put(task);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private class PoolWorkers extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    Runnable task = taskQueue.take();
                    task.run();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public static void main(String[] args) {
        SimpleThreadPool pool = new SimpleThreadPool(3);

        Runnable task = () -> {
            System.out.println(Thread.currentThread().getName()+" executing the task");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+" finished the task");
        };

        for (int i = 0; i < 10; i++) {
            pool.submit(task);
        }
    }
}
