class Pt1 implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.print(i+" ");
        }
        System.out.println();
    }
}

class Pt2 implements Runnable {
    @Override
    public void run() {
        for (int i = 11; i <= 20; i++) {
            System.out.print(i+" ");
        }
        System.out.println();
    }
}

public class Test {
    public static void main(String[] args) {
        Thread p1 = new Thread(new Pt1());
        Thread p2 = new Thread(new Pt2());
        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.currentThread().getPriority());

        p1.setPriority(Thread.MAX_PRIORITY);
        System.out.println(p1.getName());
        System.out.println(p1.getPriority());
        p2.setPriority(Thread.MIN_PRIORITY);
        System.out.println(p2.getName());
        System.out.println(p2.getPriority());

        p2.start();
        p1.start();
    }
}