package EducativeCodes.InterviewQuestions;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.*;

class BolckingQueueProducer implements Runnable{
    private BlockingQueue<Integer> queue;

    public BolckingQueueProducer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                queue.put(i);
                System.out.println("Queue added : "+i);
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

class BolckingQueueConsumer implements Runnable{
    private BlockingQueue<Integer> queue;

    public BolckingQueueConsumer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                int j = queue.take();
                System.out.println("Queue removed : "+j);
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

public class PCUsingBQ {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);

        Thread producerThread = new Thread(new BolckingQueueProducer(queue));
        Thread consumerThread = new Thread(new BolckingQueueConsumer(queue));

        producerThread.start();
        consumerThread.start();
    }
}
