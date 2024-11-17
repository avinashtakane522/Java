public class Intrinsic2 {
    public synchronized void displayMessage() {
        System.out.println("Thread " + Thread.currentThread().getName() + " has the lock.");
        try {
            Thread.sleep(1000);  // Simulates work being done
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread " + Thread.currentThread().getName() + " releases the lock.");
    }

    public static void main(String[] args) {
        Intrinsic2 example = new Intrinsic2();
        Runnable task = example::displayMessage;

        // Creating two threads that try to execute the synchronized method
        Thread t1 = new Thread(task, "Thread-1");
        Thread t2 = new Thread(task, "Thread-2");

        t1.start();
        t2.start();
    }
}

