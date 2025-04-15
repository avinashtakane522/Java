//Q: Your task is to implement a semaphore which takes in its constructor the maximum number of permits allowed and 
//is also initialized with the same number of permits.

package InterviewCodingQuestions;

public class ImplementSemaphore {
	public static void main(String[] args) throws InterruptedException {
		final CountSemaphore count = new CountSemaphore(1);
		
		Thread t1 = new Thread(() -> {
			for (int i = 0; i < 10; i++) {
				count.aquire();
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Thread "+i+" is aquired.");
			}
		});
		
		Thread t2 = new Thread(() -> {
			for (int i = 0; i < 10; i++) {
				count.release();
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Thread "+i+" is released.");
			}
		});
		
		t1.start();
		t2.start();
	}
}

class CountSemaphore{
	private int MAX_Count;
	private int userPermit = 0;
	
	public CountSemaphore(int MAX_Count) {
		this.MAX_Count = MAX_Count;
	}
	
	public synchronized void aquire() {
		if (userPermit == MAX_Count) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		userPermit++;
		notify();
	}
	
	public synchronized void release() {
		if (userPermit == 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		userPermit--;
		notify();
	} 
}
