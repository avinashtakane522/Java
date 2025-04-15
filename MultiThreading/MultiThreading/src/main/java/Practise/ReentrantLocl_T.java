package Practise;

import java.util.concurrent.ThreadFactory;

public class ReentrantLocl_T {
	private static ReentrantLock lock = new ReentrantLock();
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

class ReentrantLock{
	private Thread ownerThread = null;
	private int holdCount=0;
	
	public synchronized void lock() {
		Thread curreThread = Thread.currentThread();
		if (ownerThread!=null && ownerThread != curreThread) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		ownerThread=curreThread;
		holdCount++;
	}
	public synchronized void unLock() {
		Thread curreThread = Thread.currentThread();
		if (holdCount > 0) {
			holdCount--;
			if (holdCount == 0) {
				ownerThread = null;
				notifyAll();
			}
		}
	}
}