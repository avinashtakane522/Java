package Practise;

public class ReadWriteLock_T {
	public static void main(String[] args) {
		ReadWrite rw = new ReadWrite();
		
		Runnable reader = () -> {
			try {
				rw.aquireReadLock();
				System.out.println(Thread.currentThread().getName()+" reading");
				Thread.sleep(1000);
				rw.releaseReadLock();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};
		Runnable writer = () -> {
			try {
				rw.aquireWriteLock();
				System.out.println(Thread.currentThread().getName()+" writing");
				Thread.sleep(1500);
				rw.releaseWriteLock();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};
		
		new Thread(reader,"Reader-1").start();
		new Thread(reader,"Reader-2").start();
		new Thread(writer,"Writer-1").start();
		new Thread(reader,"Reader-3").start();
		new Thread(writer,"Writer-2").start();
	}
}

class ReadWrite{
	private boolean isWrite = false;
	private int readCount = 0;
	
	public synchronized void aquireReadLock() throws InterruptedException {
		if(isWrite) {
			wait();
		}
		readCount++;
	}
	
	public synchronized void releaseReadLock() throws InterruptedException {
		readCount--;
		if(readCount == 0)
			notifyAll();
	}
	
	public synchronized void aquireWriteLock() throws InterruptedException {
		if (isWrite || readCount > 0) {
			wait();
		}
		isWrite = true;
	}
	
	public synchronized void releaseWriteLock() throws InterruptedException {		
		isWrite = false;
		notifyAll();
	}
}