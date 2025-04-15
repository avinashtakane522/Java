package InterviewCodingQuestions;

import java.security.PublicKey;

public class ReentrantLock {

	private int holdCount = 0;
	private Thread owner = null;
	private static ReentrantLock lock = new ReentrantLock();

	public synchronized void lock() {
		Thread currentThread = Thread.currentThread();
		if (owner != null && owner != currentThread) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		owner = currentThread;
		holdCount++;
	}

	public synchronized void unLock() {
		Thread currentThread = Thread.currentThread();
		if (Thread.currentThread() == owner) {
			holdCount--;
			if (holdCount == 0) {
				owner = null;
				notify();
			}
		}
	}

	public static void main(String[] args) {
		Runnable task = () -> {
			lock.lock();
			System.out.println(Thread.currentThread().getName()+" aquire lock");
			nestedFunction();
			System.out.println(Thread.currentThread().getName()+" released lock");
			lock.unLock();
		};
		
		new Thread(task, "Thread-1").start();
		new Thread(task, "Thread-2").start();
	}

	public static void nestedFunction() {
		lock.lock();
		System.out.println(Thread.currentThread().getName()+" re-entrant lock");
		lock.unLock();
	}
}
