class CreateRunner1 extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Runner1: " + i);
        }
    }
}

class CreateRunner2 extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Runner2: " + i);
        }
    }
}

public class CreateThreadUsingThread {
    public static void main(String[] args) {
        Thread t1 = new CreateRunner1();
        Thread t2 = new CreateRunner2();

        t1.start();
        t2.start();
    }
}
