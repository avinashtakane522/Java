package EducativeCodes.InterviewQuestions;

import java.util.*;

public class TockenBucketExample {
    public static void main(String[] args) throws InterruptedException{
        TockenBucketFilter.runTockenTestMethod();
    }
}

class TockenBucketFilter{
    private int MAX_TOCKENS;
    private long lastRequestTime = System.currentTimeMillis();
    private long possibleTockens = 0;

    public TockenBucketFilter(int MAX_TOCKENS) {
        this.MAX_TOCKENS = MAX_TOCKENS;
    }

    public synchronized void getTocken(){

        possibleTockens += (System.currentTimeMillis() - lastRequestTime)/1000;
        if (possibleTockens > MAX_TOCKENS) {
            possibleTockens = MAX_TOCKENS;
        }
        if (possibleTockens == 0) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            possibleTockens--;
        }
        lastRequestTime = System.currentTimeMillis();
        System.out.println("Granting " + Thread.currentThread().getName() +
                " token at " + (System.currentTimeMillis() / 1000));
    }

    static void runTockenTestMethod() throws InterruptedException{
        Set<Thread> set = new HashSet<Thread>();
        TockenBucketFilter bucketFilter = new TockenBucketFilter(2);

        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> bucketFilter.getTocken(), "Thread-"+i);
            set.add(thread);
        }
        for (Thread thread : set) {
            thread.start();
        }
        for (Thread thread : set) {
            thread.join();
        }
    }
}