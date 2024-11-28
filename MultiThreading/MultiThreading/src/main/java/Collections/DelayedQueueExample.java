package Collections;

import java.util.concurrent.*;

public class DelayedQueueExample {
    public static void main(String[] args) {
        BlockingQueue<DelayedQueueWorker> delayedQueue = new DelayQueue<>();

        try {
            delayedQueue.put(new DelayedQueueWorker(2000, "This is first message"));
            delayedQueue.put(new DelayedQueueWorker(10000, "This is second message"));
            delayedQueue.put(new DelayedQueueWorker(4500, "This is third message"));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        while(!delayedQueue.isEmpty()){
            try {
                System.out.println(delayedQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class DelayedQueueWorker implements Delayed {
    private long duration;
    private String message;

    public DelayedQueueWorker(long duration, String message) {
        this.duration = System.currentTimeMillis() + duration;
        this.message = message;
    }

    @Override
    public int compareTo(Delayed other) {
        if(duration < ((DelayedQueueWorker) other).getDuration())
            return -1;
        if(duration > ((DelayedQueueWorker) other).getDuration())
            return +1;
        return 0;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(duration-System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    public long getDuration() {
        return duration;
    }
    public String getMessage() {
        return message;
    }
    public void setDuration(long duration) {
        this.duration = duration;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    @Override
    public String toString() {
        return "Message : "+message;
    }
}

//import java.util.concurrent.DelayQueue;
//import java.util.concurrent.Delayed;
//import java.util.concurrent.TimeUnit;
//
//// Task class implementing Delayed
//class DelayedTask implements Delayed {
//    private final String taskName;
//    private final long startTime; // Time when the task becomes eligible for execution
//
//    public DelayedTask(String taskName, long delayInMillis) {
//        this.taskName = taskName;
//        this.startTime = System.currentTimeMillis() + delayInMillis;
//    }
//
//    @Override
//    public long getDelay(TimeUnit unit) {
//        long remainingDelay = startTime - System.currentTimeMillis();
//        return unit.convert(remainingDelay, TimeUnit.MILLISECONDS);
//    }
//
//    @Override
//    public int compareTo(Delayed other) {
//        if (this.getDelay(TimeUnit.MILLISECONDS) < other.getDelay(TimeUnit.MILLISECONDS)) {
//            return -1;
//        }
//        if (this.getDelay(TimeUnit.MILLISECONDS) > other.getDelay(TimeUnit.MILLISECONDS)) {
//            return 1;
//        }
//        return 0;
//    }
//
//    @Override
//    public String toString() {
//        return "Task: " + taskName;
//    }
//}
//
//// Main class demonstrating DelayQueue usage
//public class DelayedQueueExample {
//    public static void main(String[] args) throws InterruptedException {
//        DelayQueue<DelayedTask> delayQueue = new DelayQueue<>();
//
//        // Add tasks to the delay queue
//        delayQueue.put(new DelayedTask("Task 1", 2000)); // 2 seconds delay
//        delayQueue.put(new DelayedTask("Task 2", 1000)); // 1 second delay
//        delayQueue.put(new DelayedTask("Task 3", 3000)); // 3 seconds delay
//
//        System.out.println("Processing tasks...");
//
//        // Process tasks
//        while (!delayQueue.isEmpty()) {
//            DelayedTask task = delayQueue.take(); // Blocks until the task's delay expires
//            System.out.println("Processing " + task);
//        }
//
//        System.out.println("All tasks processed!");
//    }
//}

