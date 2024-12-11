package EducativeCodes;

class MyClass {
    // Synchronized static method
    public synchronized static void staticMethod() {
        System.out.println(Thread.currentThread().getName() + " executing static method");
        try {
            Thread.sleep(1000);  // Simulating some work
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class ClassLockExample {
    public static void main(String[] args) {
        // Thread 1 calling staticMethod
        Thread t1 = new Thread(() -> MyClass.staticMethod());
        // Thread 2 calling staticMethod (same class lock, no matter the instance)
        Thread t2 = new Thread(() -> MyClass.staticMethod());

        t1.start();
        t2.start();
    }
}

//Both threads t1 and t2 are calling the same static method staticMethod().
//Since it's a synchronized static method, both threads must acquire
// the class lock (MyClass.class), and they cannot execute concurrently.
//The first thread acquires the lock and executes the method, while the
// second thread waits for the first thread to finish before it can execute the method.