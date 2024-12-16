package EducativeCodes.InterviewQuestions;

import java.util.HashSet;
import java.util.Set;

public class TockenBucketWithMultiThread {
    public static void main(String[] args) throws InterruptedException {
        Set<Thread> set = new HashSet<Thread>();
        final MultithreadedTockenBucketFilter bucketFilter =
                new MultithreadedTockenBucketFilter(1);

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

class MultithreadedTockenBucketFilter {
    private final int MAX_TOCKEN;
    private final int ONE_SECOND = 1000;
     private long lastRequestTime = System.currentTimeMillis();
     private long possibleTocken = 0;

     public MultithreadedTockenBucketFilter(int MAX_TOCKEN) {
         this.MAX_TOCKEN = MAX_TOCKEN;

         Thread t = new Thread(() -> {
            generateTocken();
         });
         t.setDaemon(true);
         t.start();
     }

     void generateTocken(){
         while(true){
             synchronized(this){
                 if (possibleTocken < MAX_TOCKEN){
                     possibleTocken++;
                 }
                 notify();
             }
             try {
                 Thread.sleep(ONE_SECOND);
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
         }
     }

     void getTocken() {
         synchronized (this) {
             while(possibleTocken == 0){
                 try {
                     this.wait();
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
             }
             possibleTocken--;
         }
         System.out.println("Granting " + Thread.currentThread().getName() +
                 " token at " + (System.currentTimeMillis() / 1000));
     }
}
