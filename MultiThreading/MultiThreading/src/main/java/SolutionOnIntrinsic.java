public class SolutionOnIntrinsic {
    public static int counter1=0;
    public static int counter2=0;

    public static final Object lock1 = new Object();
    public static final Object lock2 = new Object();

    public static void incrementCounter1(){
        synchronized (lock1){
            counter1++;
        }
    }
    public static void incrementCounter2(){
        synchronized (lock2){
            counter2++;
        }
    }

    public static void process() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    incrementCounter1();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    incrementCounter2();
                }
            }
        });

        t1.start();
        t2.start();

        try{
            t1.join();
            t2.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.println(counter1);
        System.out.println(counter2);
    }
    public static void main(String[] args) {
        process();
    }
}


