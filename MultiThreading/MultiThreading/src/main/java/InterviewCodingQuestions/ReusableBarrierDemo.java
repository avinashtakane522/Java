package InterviewCodingQuestions;

class ReusableBarrier{
	private int threadCount;
	private int waitingThread = 0;
	
	public ReusableBarrier(int threadCount) {
		this.threadCount = threadCount;
	}
	
	public synchronized void await() throws InterruptedException {
		waitingThread++;
		if (waitingThread == threadCount) {
			waitingThread=0;
			notifyAll();
		} else {
			wait();
		}
	}
}

public class ReusableBarrierDemo {
	public static void main(String[] args) {
		int threadCount = 3;
		ReusableBarrier rb = new ReusableBarrier(threadCount);
		Runnable task = () -> {		
			try {
				System.out.println(Thread.currentThread().getName()+" reached the barrier");
				rb.await();
				System.out.println(Thread.currentThread().getName()+" passed the barrier");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};
		
		for (int i = 0; i < threadCount; i++) {
			new Thread(task,"Thread "+(i+1)).start();
		}
	}
}
