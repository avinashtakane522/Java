package Practise;

import java.util.Iterator;

import EducativeCodes.InterviewQuestions.ThreadSafeCounter;

public class CyclicBarrier_T {
	public static void main(String[] args) {
		int threadCount = 3;
		Barrier b = new Barrier(threadCount);
		Runnable task = () ->{			
			System.out.println(Thread.currentThread().getName()+" reached at barrier.");
			b.await();
			System.out.println(Thread.currentThread().getName()+" passed the barrier.");
		};
		for (int i = 0; i < 10; i++) {
			new Thread(task,"Thread "+i).start();
		}
	}
}

class Barrier{
	private int limit;
	private int workingThead=0;
	public Barrier(int limit) {
		this.limit = limit;
	}
	
	public synchronized void await() {
		workingThead++;
		if (workingThead == limit) {
			workingThead=0;
			notifyAll();
		} else {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}		
	}
}
