package InterviewCodingQuestions;

import java.util.Iterator;

class BoundedBuffer<T> {
	private final T[] buffer;
	private int head = 0;
	private int tail = 0;
	private int count = 0;

	@SuppressWarnings("unchecked")
	public BoundedBuffer(int capacity) {
		buffer = (T[]) new Object[capacity];
	}

	public synchronized void put(T item) throws InterruptedException {
		if (count == buffer.length) {
			wait();
		}
		buffer[tail] = item;
		tail = (tail + 1) % buffer.length;
		count++;
		notifyAll();
	}

	public synchronized T take() throws InterruptedException {
		if (count == 0) {
			wait();
		}
		T item = buffer[head];
		head = (head + 1) % buffer.length;
		count--;
		notifyAll();
		return item;
	}
}

public class BoundedBufferQ {
	public static void main(String[] args) {
		BoundedBuffer<Integer> buffer = new BoundedBuffer<>(5);

		Runnable producer = () -> {
			try {
				for (int i = 0; i < 10; i++) {
					buffer.put(i);
					System.out.println("Produced: " + i);
				}
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		};

		Runnable consumer = () -> {
			try {
				for (int i = 0; i < 10; i++) {
					int item = buffer.take();
					System.out.println("Consumed: " + item);
				}
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		};

		new Thread(producer).start();
		new Thread(consumer).start();
	}
}