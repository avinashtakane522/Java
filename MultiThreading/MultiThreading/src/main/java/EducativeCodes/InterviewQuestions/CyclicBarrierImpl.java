package EducativeCodes.InterviewQuestions;

public class CyclicBarrierImpl {
    private int totalThreads;
    private int count = 0;
    private int release = 0;

    public CyclicBarrierImpl(int totalThreads) {
        this.totalThreads = totalThreads;
    }

    public static void main(String[] args) throws InterruptedException {
        CyclicBarrierImpl barrier = new CyclicBarrierImpl(3);
        Thread p1 = new Thread(() -> {
            try {
                System.out.println("Thread 1");
                barrier.await();
                System.out.println("Thread 1");
                barrier.await();
                System.out.println("Thread 1");
                barrier.await();
            } catch (InterruptedException ie) {
            }
        });

        Thread p2 = new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(500);
                    System.out.println("Thread 2");
                    barrier.await();
                    Thread.sleep(500);
                    System.out.println("Thread 2");
                    barrier.await();
                    Thread.sleep(500);
                    System.out.println("Thread 2");
                    barrier.await();
                } catch (InterruptedException ie) {
                }
            }
        });

        Thread p3 = new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(1500);
                    System.out.println("Thread 3");
                    barrier.await();
                    Thread.sleep(1500);
                    System.out.println("Thread 3");
                    barrier.await();
                    Thread.sleep(1500);
                    System.out.println("Thread 3");
                    barrier.await();
                } catch (InterruptedException ie) {
                }
            }
        });

        p1.start();
        p2.start();
        p3.start();

        p1.join();
        p2.join();
        p3.join();
    }

    public synchronized void await() throws InterruptedException {
        while (count == totalThreads) {
            wait();
        }

        count++;
        if (count == totalThreads) {
            notifyAll();
            release = totalThreads;
        } else {
            while (count < totalThreads) {
                wait();
            }
        }

        release--;
        if (release == 0) {
            count = 0;
            notifyAll();
        }
    }
}
