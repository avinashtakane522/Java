import java.util.concurrent.Semaphore;

public class SemaphoreExample {
    private static Semaphore semaphore = new Semaphore(2); // Allows up to 2 threads

    public static void main(String[] args) {
        Runnable task = () -> {
            try {
                semaphore.acquire();
                System.out.println(Thread.currentThread().getName() + " acquired the semaphore.");
                Thread.sleep(1000); // Simulate work
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(Thread.currentThread().getName() + " released the semaphore.");
                semaphore.release();
            }
        };

        // Start multiple threads
        new Thread(task).start();
        new Thread(task).start();
        new Thread(task).start();
    }
}
