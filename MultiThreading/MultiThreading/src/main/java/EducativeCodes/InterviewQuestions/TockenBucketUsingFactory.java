package EducativeCodes.InterviewQuestions;

import java.util.*;

public class TockenBucketUsingFactory {
    public static void main(String[] args) throws InterruptedException {
        Set<Thread> set = new HashSet<Thread>();
        final TockenFilterClass task = UsingFactoryMethod.makeTockenFactory(1);

        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> task.getTocken(), "Thread-"+i);
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

abstract class TockenFilterClass{
    void getTocken(){};
}

class UsingFactoryMethod extends TockenFilterClass{
    public UsingFactoryMethod(){}

    public static TockenFilterClass makeTockenFactory(int MAX_TOCKEN){
        MultiThreadedTocken task = new MultiThreadedTocken(MAX_TOCKEN);
        task.initializer();
        return task;
    }

    public static class MultiThreadedTocken extends TockenFilterClass{
        private int MAX_TOCKEN;
        private final long ONE_SECOND = 1000;
        private long lastRequest = System.currentTimeMillis();
        private long availableTocken = 0;

        public MultiThreadedTocken(int max_tocken){
            this.MAX_TOCKEN = max_tocken;
        }

        void initializer(){
            Thread t = new Thread(() -> {
                generateTocken();
            });
            t.setDaemon(true);
            t.start();
        }

        void generateTocken(){
            while(true){
                synchronized(this){
                    if(availableTocken < MAX_TOCKEN){
                        availableTocken++;
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

        void getTocken(){
            synchronized(this){
                while(availableTocken == 0){
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                availableTocken--;
            }
            System.out.println("Granting " + Thread.currentThread().getName() +
                    " token at " + (System.currentTimeMillis() / 1000));
        }
    }
}