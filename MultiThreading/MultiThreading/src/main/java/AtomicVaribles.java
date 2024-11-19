import java.util.concurrent.atomic.AtomicInteger;

public class AtomicVaribles {
    private static AtomicInteger counter = new AtomicInteger(0);
    public static void main(String[] args) {
        Thread t1 = new Thread(AtomicVaribles::increment,"Thread-1");
        Thread t2 = new Thread(AtomicVaribles::increment,"Thread-2");

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final Counter : " + counter);
    }

    static void increment() {
        for (int i = 0; i < 10000; i++) {
            counter.getAndIncrement();
        }
    }
}
