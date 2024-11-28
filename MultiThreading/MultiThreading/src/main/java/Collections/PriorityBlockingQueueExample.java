package Collections;

import java.util.PriorityQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

class PriorityFirstQueue implements Runnable{
    private BlockingQueue<Integer> queue;

    public PriorityFirstQueue(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }
    @Override
    public void run() {
        try {
            queue.put(10);
            queue.put(2);
            Thread.sleep(2000);
            queue.put(5);
            Thread.sleep(1000);
            queue.put(1);
            queue.put(8);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class PrioritySecondQueue implements Runnable{
    private BlockingQueue<Integer> queue;

    public PrioritySecondQueue(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }
    @Override
    public void run() {
        try {
            Thread.sleep(5000);
            System.out.println(queue.take());
            Thread.sleep(1000);
            System.out.println(queue.take());
            Thread.sleep(2000);
            System.out.println(queue.take());
            System.out.println(queue.take());
            System.out.println(queue.take());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class PriorityBlockingQueueExample {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new PriorityBlockingQueue<>();

        PriorityFirstQueue firstQueue = new PriorityFirstQueue(queue);
        PrioritySecondQueue secondQueue = new PrioritySecondQueue(queue);

        new Thread(firstQueue).start();
        new Thread(secondQueue).start();
    }
}

//import java.util.concurrent.PriorityBlockingQueue;
//
//class Task implements Comparable<Task> {
//    private final int priority;
//    private final String taskName;
//
//    public Task(int priority, String taskName) {
//        this.priority = priority;
//        this.taskName = taskName;
//    }
//
//    public int getPriority() {
//        return priority;
//    }
//
//    public String getTaskName() {
//        return taskName;
//    }
//
//    @Override
//    public int compareTo(Task other) {
//        // Lower priority value means higher priority
//        return Integer.compare(this.priority, other.priority);
//    }
//
//    @Override
//    public String toString() {
//        return "Task{name='" + taskName + "', priority=" + priority + "}";
//    }
//}
//
//public class PriorityBlockingQueueExample {
//    public static void main(String[] args) throws InterruptedException {
//        PriorityBlockingQueue<Task> queue = new PriorityBlockingQueue<>();
//
//        // Add tasks to the queue
//        queue.put(new Task(3, "Low Priority Task"));
//        queue.put(new Task(1, "High Priority Task"));
//        queue.put(new Task(2, "Medium Priority Task"));
//
//        System.out.println("Tasks added to the queue.");
//
//        // Retrieve tasks based on priority
//        while (!queue.isEmpty()) {
//            System.out.println("Processing: " + queue.take()); // Blocks if the queue is empty
//        }
//
//        System.out.println("All tasks processed.");
//    }
//}
