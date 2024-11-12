class Daemon implements Runnable {

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Daemon thread...");
        }
    }
}

class NormalThread implements Runnable {
    public void run() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Normal thread...");
    }
}

public class DaemonThread {
    public static void main(String srgs[]) {
        Thread t1 = new Thread(new Daemon());
        Thread t2 = new Thread(new NormalThread());

        t1.setDaemon(true);
        t1.start();
        t2.start();
    }
}
