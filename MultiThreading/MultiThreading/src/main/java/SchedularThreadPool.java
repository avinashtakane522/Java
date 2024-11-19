import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

class StockMarket implements Runnable{
    @Override
    public void run(){
        System.out.println("Updating and downloading stock realated data");
    }
}
public class SchedularThreadPool {
    public static void main(String[] args) {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(new StockMarket(), 1000, 2000, TimeUnit.MILLISECONDS);

        //It directly terminate the schedular without any output so we have to use await time
        //executor.shutdown();
        try{
            if (!executor.awaitTermination(6000, TimeUnit.MILLISECONDS)) {
                executor.shutdown();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            e.printStackTrace();
        }
    }
}
