package InterviewCodingQuestions;

class ReadWriteLock{
	private boolean isWriter = false;
	private int reader = 0;
	
	public synchronized void aquireReadLock() throws InterruptedException {
		if (isWriter) {
			wait();
		}
		reader++;
	}
	
	public synchronized void releaseReadLock() throws InterruptedException {		
		reader--;
		if (reader == 0) {
			notifyAll();
		}
	}
	
	public synchronized void aquireWriterLock() throws InterruptedException {
		if (isWriter || reader > 0) {
			wait();
		}
		isWriter = true;
	}
	
	public synchronized void releaseWriterLock() throws InterruptedException {
		isWriter = false;
		notifyAll();
	}
}

public class ImplementReadWriteLock {
	public static void main(String[] args) {
		ReadWriteLock rw = new ReadWriteLock();
		
		Runnable writer = () -> {
			try {
				rw.aquireWriterLock();
				System.out.println(Thread.currentThread().getName()+" is writing...");
				Thread.sleep(1500);
				rw.releaseWriterLock();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};
		
		Runnable reader = () -> {
			try {
				rw.aquireReadLock();
				System.out.println(Thread.currentThread().getName()+" is reading...");
				Thread.sleep(1000);
				rw.releaseReadLock();
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
