package EducativeCodes.InterviewQuestions;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class CyclicBarrierLogic {
    private int waitingThreads = 0;
    private int totalWaitingThreads;

    public CyclicBarrierLogic(int totalWaitingThreads) {
        this.totalWaitingThreads = totalWaitingThreads;
    }

    public synchronized void await() throws InterruptedException {
        waitingThreads++;
        if (waitingThreads < totalWaitingThreads) {
            wait();
        } else {
            waitingThreads = 0;
            notifyAll();
        }
    }
}

public class CyclicBarrierLogicImpl {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(5);
        CyclicBarrierLogic cyclicBarrierLogic = new CyclicBarrierLogic(5);

        for (int i = 0; i < 5; i++) {
            service.execute(() -> {
                System.out.println(Thread.currentThread().getName()+" waiting for the another threads to complete work");
                try {
                    cyclicBarrierLogic.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+" completed his work");
            });
        }
        service.shutdown();
    }
}
