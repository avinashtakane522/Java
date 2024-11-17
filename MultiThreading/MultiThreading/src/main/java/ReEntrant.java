public class ReEntrant {
    public synchronized void methodA() {
        System.out.println("methodA() is being executed by " + Thread.currentThread().getName());
        methodB();  // Calls another synchronized method
    }

    public synchronized void methodB() {
        System.out.println("methodB() is being executed by " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        ReEntrant example = new ReEntrant();
        Thread t1 = new Thread(example::methodA, "Thread-1");
        t1.start();
    }
}
