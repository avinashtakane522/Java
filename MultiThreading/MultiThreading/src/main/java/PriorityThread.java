class P1 implements Runnable{
    @Override
    public void run() {
        for(int i=0; i<10; i++){
            System.out.println(i);
        }
    }
}

public class PriorityThread {
    public static void main(String[] args) {
        Thread t = new Thread(new P1());
    }
}
