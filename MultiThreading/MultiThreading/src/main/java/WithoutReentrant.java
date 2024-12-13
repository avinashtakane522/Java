public class WithoutReentrant {
    public synchronized void parentMethod() {
        System.out.println("Parent method acquired the lock.");
        childMethod(); // This will try to acquire the same lock
    }

    public synchronized void childMethod() {
        System.out.println("Child method acquired the lock.");
    }

    public static void main(String[] args) {
        WithoutReentrant example = new WithoutReentrant();
        example.parentMethod();
    }
}
