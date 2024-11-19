import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Task1 implements Runnable {
    private int id;
    public Task1(int id) {
        this.id = id;
    }
    public void run() {
        System.out.println("Task with id: "+id+" is in work. And had current thread: "+Thread.currentThread().getName());
        long duration = (long) Math.random()*5;
        try {
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class SingleThreadExecutor {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
         for (int i = 0; i < 5; i++) {
             executor.execute(new Task1(i));
         }
        executor.shutdown();
    }
}
