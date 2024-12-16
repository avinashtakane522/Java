package EducativeCodes.InterviewQuestions;

public class ImplementingSemaphore {
    public static void main(String[] args) throws InterruptedException {
        final CountSemaphore count = new CountSemaphore(1);

        Thread t1 = new Thread(() -> {
            try {
                for (int i = 0; i < 5; i++) {
                    count.acquire();
                    System.out.println("Thread-"+i+ " is acquired");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                for (int i = 0; i < 5; i++) {
                    count.release();
                    System.out.println("Thread-"+i+ " is released");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t2.start();
        t1.start();
        t1.join();
        t2.join();
    }
}

class CountSemaphore {
    private int MAX_COUNT;
    private int usedPermits = 0;
    public CountSemaphore(int MAX_COUNT) {
        this.MAX_COUNT = MAX_COUNT;
    }

    public synchronized void acquire() throws InterruptedException {
        while (usedPermits == MAX_COUNT) {
            wait();
        }
        usedPermits++;
        Thread.sleep(100);
        notify();
    }

    public synchronized void release() throws InterruptedException {
        while (usedPermits == 0) {
            wait();
        }
        usedPermits--;
        Thread.sleep(100);
        notify();
    }
}
