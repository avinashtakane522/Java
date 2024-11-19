class Worker implements Runnable{
    private volatile boolean terminated = false;
    static int counter=1;

    @Override
    public void run(){
        while (!terminated){
            System.out.println(counter+" Working class running...");
            try{
                Thread.sleep(300);
                counter++;
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public boolean isTerminated(){
        return terminated;
    }

    public void setTerminated(boolean terminated){
        this.terminated = terminated;
    }
}

public class Volatile {
    public static void main(String[] args) {
        Worker w = new Worker();
        Thread t1 = new Thread(w, "Thread-1");
        t1.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            w.counter = 1;
        }
        w.setTerminated(true);
        System.out.println("Operation terminated... "+Worker.counter);
    }
}
