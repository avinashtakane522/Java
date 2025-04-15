package Practise;

import java.util.LinkedList;
import java.util.Queue;

public class ImplBQ_T <T>{
	private Queue<T> queue = new LinkedList<>();
	private int limit;
	
	public ImplBQ_T(int limit) {
		this.limit = limit;
	}
	
	public synchronized void enqueue(T item) {
		if (limit == queue.size()) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		queue.add(item);
		notify();
	}
	
	public synchronized T dequeue() {
		if (queue.isEmpty()) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		T item = queue.poll();
		notify();
		return item;
	}
}