package EducativeCodes.InterviewQuestions;

class CodeThread {
    private int count=0;

    public synchronized void increment() {
        count++;
    }

    public synchronized int getCount() {
        return count;
    }
}

public class CodeThreadClass extends Thread{
    private CodeThread codeThread;
    @Override
    public void run(){
        for (int i = 0; i < 10; i++) {
            codeThread.increment();
        }
    }

    public CodeThreadClass(CodeThread codeThread) {
        this.codeThread = codeThread;
    }
    public static void main(String[] args) {
        CodeThread codeThread = new CodeThread();

        Thread t1 = new CodeThreadClass(codeThread);
        Thread t2 = new CodeThreadClass(codeThread);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final count value: "+codeThread.getCount());
    }
}
