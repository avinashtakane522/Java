package EducativeCodes;

class ObjectLockClass {
    public synchronized void method() {
        System.out.println(Thread.currentThread().getName() + " executing instance method");
    }
}

public class ObjectLockExample {
    public static void main(String[] args) {
        ObjectLockClass obj1 = new ObjectLockClass();
        ObjectLockClass obj2 = new ObjectLockClass();

        // Thread 1 working on obj1
        Thread t1 = new Thread(() -> obj1.method());
        // Thread 2 working on obj2
        Thread t2 = new Thread(() -> obj2.method());

        t1.start();
        t2.start();
    }
}

//Thread 1 locks obj1 and Thread 2 locks obj2.
//Both threads are able to execute the synchronized method concurrently
//because they are working with different instances (obj1 and obj2),
//so each one locks its respective object.
