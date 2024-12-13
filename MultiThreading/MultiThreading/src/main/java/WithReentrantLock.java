import java.util.concurrent.locks.ReentrantLock;

public class WithReentrantLock {
    private final ReentrantLock lock = new ReentrantLock();

    public void parentMethod() {
        lock.lock(); // Acquire the lock
        try {
            System.out.println("Parent method acquired the lock.");
            childMethod(); // Calls another method needing the same lock
        } finally {
            lock.unlock(); // Release the lock
        }
    }

    public void childMethod() {
        lock.lock(); // Acquire the same lock again
        try {
            System.out.println("Child method acquired the lock.");
        } finally {
            lock.unlock(); // Release the lock
        }
    }

    public static void main(String[] args) {
        WithReentrantLock example = new WithReentrantLock();
        example.parentMethod();
    }
}
