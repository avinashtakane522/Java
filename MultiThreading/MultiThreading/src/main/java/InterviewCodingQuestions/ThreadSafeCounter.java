//Question: Implement a thread-safe counter that can be incremented by multiple threads.

package InterviewCodingQuestions;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadSafeCounter {
	private final AtomicInteger count = new AtomicInteger(0);

	public void increment() {
		for(int i=0; i<10; i++) {
			count.incrementAndGet();
		}
	}
	
	public int getCount() {
		return count.get();
	}

	public static void main(String[] args) {
		ThreadSafeCounter threadSafeCounter = new ThreadSafeCounter();
		Thread t1 = new Thread(threadSafeCounter::increment);
		Thread t2 = new Thread(threadSafeCounter::increment);
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("After operation value is : "+threadSafeCounter.getCount());
	}
}
