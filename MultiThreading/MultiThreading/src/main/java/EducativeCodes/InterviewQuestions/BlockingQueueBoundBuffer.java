package EducativeCodes.InterviewQuestions;

public class BlockingQueueBoundBuffer {
    public static void main(String[] args) throws Exception{
        BlockingQueuee<Integer> queue = new BlockingQueuee<Integer>(5);

        Thread t1 = new Thread(() -> {
            try {
                for (int i = 0; i < 5; i++) {
                    System.out.println("enqueue : "+i);
                    queue.enqueue(i);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                for (int i = 0; i < 5; i++) {
                    System.out.println("Thread 2 dequeue : "+queue.dequeue());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

//        Thread t3 = new Thread(() -> {
//            try {
//                for (int i = 0; i < 25; i++) {
//                    System.out.println("Thread 3 dequeue : "+queue.dequeue());
//                }
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });

       t1.start();
       t1.join();
       t2.start();
//       t3.start();
    }
}

class BlockingQueuee<T> {
    T[] array;
    int size=0;
    int capacity;
    int head=0;
    int tail=0;
    Object lock = new Object();

    public BlockingQueuee(int capacity) {
        array = (T[]) new Object[capacity];
        this.capacity = capacity;
    }

    public void enqueue(T element) throws InterruptedException {
        synchronized (lock) {
            while(size == capacity) {
                lock.wait();
            }

            if (tail == capacity) {
                tail = 0;
            }

            array[tail] = element;
            size++;
            tail++;
            lock.notify();
        }
    }

    public T dequeue() throws InterruptedException {
        T item = null;
        synchronized (lock) {
            while (size == 0) {
                lock.wait();
            }

            if (head == capacity){
                head = 0;
            }

            item = array[head];
            head++;
            size--;
            lock.notify();
        }
        return item;
    }
}