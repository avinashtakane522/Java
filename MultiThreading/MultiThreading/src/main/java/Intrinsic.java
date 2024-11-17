public class Intrinsic {
    public static int counter1=0;
    public static int counter2=0;

    //usually it is not good practise to use synchronized word here
    public static void incrementCounter1(){
        //class locking
        //iF WE RENOVE VOID from here then it will call objet level locking
        //rule of thum is: we synchronized block that are 100% necessary
        synchronized (Intrinsic.class){
            counter1++;
        }
    }
    public static void incrementCounter2(){
        synchronized (Intrinsic.class){
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

