import java.util.concurrent.atomic.*;
import java.util.concurrent.ThreadLocalRandom;

public class AtomicExamples {

    public static void main(String[] args) throws InterruptedException {
        // AtomicBoolean example: Thread-safe flag to stop threads
        AtomicBoolean isRunning = new AtomicBoolean(true);

        // AtomicIntegerArray example: Array of atomic integers
        AtomicIntegerArray atomicIntArray = new AtomicIntegerArray(5);

        // AtomicIntegerFieldUpdater example: Atomic updates to a field
        class Counter {
            volatile int count = 0;
        }
        Counter counter = new Counter();
        AtomicIntegerFieldUpdater<Counter> intFieldUpdater =
                AtomicIntegerFieldUpdater.newUpdater(Counter.class, "count");

        // AtomicLong example: Thread-safe global counter
        AtomicLong globalCounter = new AtomicLong(0);

        // AtomicLongArray example: Array of atomic long values
        AtomicLongArray atomicLongArray = new AtomicLongArray(3);

        // AtomicLongFieldUpdater example: Atomic updates to a long field
        class Transaction {
            volatile long total = 0;
        }
        Transaction transaction = new Transaction();
        AtomicLongFieldUpdater<Transaction> longFieldUpdater =
                AtomicLongFieldUpdater.newUpdater(Transaction.class, "total");

        // AtomicMarkableReference example: Marking nodes in a data structure
        AtomicMarkableReference<String> markableReference =
                new AtomicMarkableReference<>("InitialState", false);

        // AtomicReference example: Manage a shared state object
        AtomicReference<String> sharedState = new AtomicReference<>("InitialState");

        // AtomicReferenceArray example: Atomic operations on object references
        AtomicReferenceArray<String> referenceArray = new AtomicReferenceArray<>(3);
        referenceArray.set(0, "Task1");
        referenceArray.set(1, "Task2");

        // AtomicReferenceFieldUpdater example: Field-level atomic updates
        class SharedData {
            volatile String status = "Idle";
        }
        SharedData sharedData = new SharedData();
        AtomicReferenceFieldUpdater<SharedData, String> refFieldUpdater =
                AtomicReferenceFieldUpdater.newUpdater(SharedData.class, String.class, "status");

        // AtomicStampedReference example: Preventing ABA problem
        AtomicStampedReference<String> stampedRef =
                new AtomicStampedReference<>("InitialState", 1);

        // Running multiple threads
        Thread thread1 = new Thread(() -> {
            // AtomicBoolean usage: Checking flag
            while (isRunning.get()) {
                System.out.println("Thread 1 is running...");
                isRunning.set(false); // Set to false to stop thread safely
            }

            // AtomicIntegerArray: Increment array elements atomically
            for (int i = 0; i < atomicIntArray.length(); i++) {
                atomicIntArray.incrementAndGet(i);
            }

            // AtomicIntegerFieldUpdater: Increment Counter field
            intFieldUpdater.incrementAndGet(counter);
            System.out.println("Counter value: " + counter.count);
        });

        Thread thread2 = new Thread(() -> {
            // AtomicLong: Increment global counter
            long count = globalCounter.incrementAndGet();
            System.out.println("Global counter: " + count);

            // AtomicLongArray: Add to array elements atomically
            for (int i = 0; i < atomicLongArray.length(); i++) {
                atomicLongArray.addAndGet(i, 100L);
            }

            // AtomicLongFieldUpdater: Update Transaction total
            longFieldUpdater.addAndGet(transaction, 500L);
            System.out.println("Transaction total: " + transaction.total);
        });

        Thread thread3 = new Thread(() -> {
            // AtomicMarkableReference: Mark and update reference
            boolean marked = markableReference.isMarked();
            markableReference.set("UpdatedState", !marked);
            System.out.println("Markable Reference Value: " + markableReference.getReference());

            // AtomicReference: Update shared state atomically
            sharedState.set("SharedUpdatedState");
            System.out.println("Shared State: " + sharedState.get());

            // AtomicReferenceFieldUpdater: Update field atomically
            refFieldUpdater.set(sharedData, "Processing");
            System.out.println("Shared Data Status: " + sharedData.status);

            // AtomicStampedReference: Update reference with a stamp
            int[] stampHolder = new int[1];
            String value = stampedRef.get(stampHolder);
            stampedRef.compareAndSet(value, "StampedUpdatedState", stampHolder[0], stampHolder[0] + 1);
            System.out.println("Stamped Reference Value: " + stampedRef.getReference() +
                    " with stamp " + stampedRef.getStamp());
        });

        // Start threads
        thread1.start();
        thread2.start();
        thread3.start();

        // Wait for threads to finish
        thread1.join();
        thread2.join();
        thread3.join();

        // Print final results
        System.out.println("Final AtomicBoolean value: " + isRunning.get());
        System.out.println("Final AtomicIntegerArray: " + atomicIntArray);
        System.out.println("Final AtomicLongArray: " + atomicLongArray);
    }
}
