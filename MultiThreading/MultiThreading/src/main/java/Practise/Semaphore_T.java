package Practise;

public class Semaphore_T {
	public static void main(String[] args) {
		Semaphore s = new Semaphore(1);
		
		Thread t1 = new Thread(()->{
			for (int i = 0; i < 10; i++) {			
				System.out.println("Thread - "+i+" aquire permit");
				s.aquire();
			}
		});
		Thread t2 = new Thread(()->{
			for (int i = 0; i < 10; i++) {			
				System.out.println("Thread - "+i+" relesae permit");
				s.release();
			}
		});
		t1.start();
		t2.start();
	}
}

class Semaphore{
	private int MAX_PERMIT;
	private int permits=0;
	
	public Semaphore(int MAX_PERMIT) {
		this.MAX_PERMIT = MAX_PERMIT;
	}
	
	public synchronized void aquire() {
		if (MAX_PERMIT == permits) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		permits++;
		notify();
	}
	
	public synchronized void release() {		
		if (permits == 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		permits--;
		notify();
	}
}