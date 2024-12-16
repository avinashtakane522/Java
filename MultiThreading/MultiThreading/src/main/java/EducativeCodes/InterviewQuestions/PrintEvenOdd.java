package EducativeCodes.InterviewQuestions;

class EvenOdd {
    private int limit;
    private int count=1;

    public EvenOdd(int limit) {
        this.limit = limit;
    }

    public synchronized void printEven() throws InterruptedException {
        while (limit >= count) {
            while (count % 2 != 0) {
                wait();
            }
            if (count > limit) break; // Ensure we don't go beyond the limit
            System.out.println(count+" is Even Number");
            count++;
            notify();
        }
    }

    public synchronized void printOdd() throws InterruptedException {
        while (limit >= count) {
            while (count % 2 == 0) {
                wait();
            }
            if (count > limit) break; // Ensure we don't go beyond the limit
            System.out.println(count+" is Odd Number");
            count++;
            notify();
        }
    }
}

public class PrintEvenOdd {
    public static void main(String[] args) throws InterruptedException {
        EvenOdd evenOdd = new EvenOdd(10);

       Thread t1 = new Thread(() -> {
            try {
                evenOdd.printEven();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

       Thread t2 = new Thread(() -> {
            try {
                evenOdd.printOdd();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

       t1.start();
       t2.start();

       t1.join();
       t2.join();
    }
}
