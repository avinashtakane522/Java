package EducativeCodes.InterviewQuestions;

public class ReadWriteLockExample {
    private boolean writeLock = false;
    private int readLock;

    public static void main(String[] args) throws InterruptedException {
        ReadWriteLockExample rw = new ReadWriteLockExample();
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                System.out.println("T1 attempt to aquire write lock");
                try {
                    rw.writeLockAquire();
                    System.out.println("T1 aquired write lock");
                    while(true)
                        Thread.sleep(500);
                } catch (InterruptedException e) {
                    System.out.println("T1 interrupted");
                    Thread.currentThread().interrupt();
                }
                System.out.println("T1 release write lock");
            }
        });

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                System.out.println("T2 attempt to aquire write lock");
                try {
                    rw.writeLockAquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("T1 release write lock");
            }
        });

        Thread t3 = new Thread(() -> {
            System.out.println("T3 attempt to aquired read lock");
            try {
                rw.readLockAquire();
                System.out.println("T3 aquired read lock");
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t4 = new Thread(() -> {
            try {
                rw.readLockRelease();
                System.out.println("T4 release read lock");
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t3.start();
        t1.start();
        Thread.sleep(3000);
        t2.start();
        Thread.sleep(2000);
        t4.start();

        t1.join();
        t2.join();
        t3.join();
        t4.join();

    }

    public synchronized void readLockAquire() throws InterruptedException {
        while (writeLock){
            wait();
        }
        readLock++;
    }

    public synchronized void readLockRelease() {
        readLock--;
        notify();
    }

    public synchronized void writeLockAquire() throws InterruptedException {
        while (writeLock || readLock == 0){
            wait();
        }
        writeLock = true;
    }

    public synchronized void writeLockRelease() {
        writeLock = false;
        notify();
    }
}
