package Practise;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class PCUsingBQ_T {
	public static void main(String[] args) {
		BlockingQueue<Integer> queue = new LinkedBlockingDeque<>(5);
		new Thread(new Producer(queue)).start();
		new Thread(new Consumer(queue)).start();
	}
}

class Producer implements Runnable{

	private BlockingQueue<Integer> queue;
	
	public Producer(BlockingQueue queue) {
		this.queue = queue;
	}
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {			
			try {
				queue.put(i);
				System.out.println("Produce "+i);
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}	
}

class Consumer implements Runnable{

	private BlockingQueue<Integer> queue;
	
	public Consumer(BlockingQueue queue) {
		this.queue = queue;
	}
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {			
			try {
				Integer itemInteger = queue.take();
				System.out.println("Consumer "+itemInteger);
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}	
}