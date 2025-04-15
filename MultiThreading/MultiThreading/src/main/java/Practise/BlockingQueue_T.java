package Practise;

import java.util.LinkedList;
import java.util.Queue;

public class BlockingQueue_T<T> {
	private Queue<T> queue = new LinkedList<T>();
	private int limit;
	
	public BlockingQueue_T(int limit) {
		this.limit = limit;
	}
	
	public synchronized void enqueue(T item) {
		if (limit == queue.size()) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		queue.add(item);
		notifyAll();
	}
	
	public synchronized T dequeue() {
		if (queue.isEmpty()) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		T itemT = queue.poll();
		notifyAll();
		return itemT;
	}
}
