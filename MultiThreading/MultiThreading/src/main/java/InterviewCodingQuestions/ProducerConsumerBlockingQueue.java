package InterviewCodingQuestions;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class Producer implements Runnable{
	private BlockingQueue<Integer> queue;
	public Producer(BlockingQueue<Integer> queue) {
		this.queue = queue;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				queue.put(i);
				System.out.println("Produce: "+i);
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
				Thread.currentThread().interrupt();
			}			
		}
	}
}

class Consumer implements Runnable{
	private BlockingQueue<Integer> queue;
	public Consumer(BlockingQueue<Integer> queue) {
		this.queue = queue;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				Integer itemInteger = queue.take();
				System.out.println("Consumer: "+itemInteger);
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
				Thread.currentThread().interrupt();
			}			
		}
	}
}

public class ProducerConsumerBlockingQueue {
	public static void main(String[] args) {
		 
		BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);
		
		Thread t1 = new Thread(new Producer(queue));
		Thread t2 = new Thread(new Consumer(queue));
		
		t1.start();
		t2.start();
	}
}
