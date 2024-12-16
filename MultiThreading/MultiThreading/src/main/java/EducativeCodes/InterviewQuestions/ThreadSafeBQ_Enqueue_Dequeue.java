package EducativeCodes.InterviewQuestions;

public class ThreadSafeBQ_Enqueue_Dequeue<T> {
    private T[] data;
    private int capacity;
    private int head;
    private int tail;
    private int size;

    public ThreadSafeBQ_Enqueue_Dequeue(int capacity) {
        data = (T[]) new Object[capacity];
        this.capacity = capacity;
    }

    public synchronized void enqueue(T item) throws InterruptedException {
        while (size == capacity) {
            wait();
        }

        if (tail == capacity) {
            tail = 0;
        }

        data[size] = item;
        size++;
        tail++;
        notifyAll();
    }

    public synchronized T dequeue() throws InterruptedException {
        while (size == 0) {
            wait();
        }

        if (head == capacity) {
            head = 0;
        }

        T result = data[head];
        head++;
        size--;

        notifyAll();
        return result;
    }
}
