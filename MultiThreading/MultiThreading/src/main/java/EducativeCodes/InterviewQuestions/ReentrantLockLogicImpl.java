package EducativeCodes.InterviewQuestions;

class ReentrantLogic{
    private int lockCount = 0;
    private boolean isLock = false;
    private Thread lockingThread = null;

    public synchronized void lock(){
        while(isLock && Thread.currentThread() != lockingThread){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        lockCount++;
        isLock = true;
        lockingThread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName()+" aquire lock and count is : "+lockCount);
    }

    public synchronized void unLock(){
        if (Thread.currentThread() == lockingThread){
            lockCount--;
            System.out.println(Thread.currentThread().getName()+" release lock and count is : "+lockCount);
        }
        if (lockCount == 0){
            isLock = false;
            lockingThread = null;
            notifyAll();
        }
    }
}

public class ReentrantLockLogicImpl {
    ReentrantLogic lock = new ReentrantLogic();

    public void reentrantTask(){
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + " executing reentrantTask");
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unLock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReentrantLockLogicImpl obj = new ReentrantLockLogicImpl();

        Runnable runnable = () ->{
                for(int i=0; i<5; i++){
                    obj.reentrantTask();
                }};
        new Thread(runnable,"Thread-1").start();
        Thread.sleep(1000);
        new Thread(runnable, "Thread-2").start();
    }
}
