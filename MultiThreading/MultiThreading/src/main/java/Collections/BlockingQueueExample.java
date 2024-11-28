package Collections;
import java.util.concurrent.*;

class FirstWorker implements Runnable {
    private BlockingQueue<Integer> querue;

    public FirstWorker(BlockingQueue<Integer> queue) {
        this.querue = queue;
    }

    @Override
    public void run() {
        int count = 0;
        while (true) {
            try {
                querue.put(count);
                System.out.println("Adding data into queue "+count);
                count++;
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class SecondWorker implements Runnable {
    private BlockingQueue<Integer> querue;

    public SecondWorker(BlockingQueue<Integer> queue) {
        this.querue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                int counter = querue.take();
                System.out.println("Fetching data from queue "+counter);
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class BlockingQueueExample {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);

        FirstWorker firstWorker = new FirstWorker(queue);
        SecondWorker secondWorker = new SecondWorker(queue);

        new Thread(firstWorker).start();
        new Thread(secondWorker).start();
    }
}
