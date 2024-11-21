import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class CallableInterface implements Callable<String> {
    private int id;
    int b;
    public CallableInterface(int id) {
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        Thread.sleep(2000);
        return "Id : "+id;
    }

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        List<Future<String>> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Future<String> e = executor.submit(new CallableInterface(i));
            list.add(e);
        }
        for (Future<String> f : list) {
            try {
                System.out.println(f.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        executor.shutdown();
    }
}
