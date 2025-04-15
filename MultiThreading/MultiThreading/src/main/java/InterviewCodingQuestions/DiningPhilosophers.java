//2. Implement a deadlock-free solution for the Dining Philosophers problem.

//This implementation uses ReentrantLock and tries to acquire locks in a consistent order to prevent deadlocks.
//These questions and solutions should provide a solid foundation for understanding multithreading concepts and demonstrate the ability to write 
//thread-safe code.

package InterviewCodingQuestions;

import java.util.Iterator;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Philosophers implements Runnable {
	private final Lock leftChopstick;
	private final Lock rightChopstick;

	public Philosophers(Lock leftChpostick, Lock rightChopstick) {
		this.leftChopstick = leftChpostick;
		this.rightChopstick = rightChopstick;
	}

	public void doAction(String action) throws InterruptedException {
		System.out.println(Thread.currentThread().getName() + " " + action);
		Thread.sleep((int) Math.random() * 100);
	}

	@Override
	public void run() {
		try {
			while(true) {
				doAction("Thinking!!!");
				if (leftChopstick.tryLock()) {
					try {
						if (rightChopstick.tryLock()) {
							try {
								doAction("Eating...");
							} finally {
								// TODO: handle finally clause
								rightChopstick.unlock();
							}
						}
					} finally {
						// TODO: handle finally clause
						leftChopstick.unlock();
					}
				}
			}
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
			}
	}
}

public class DiningPhilosophers {
	public static void main(String[] args) {
		Lock chopsticks[] = new ReentrantLock[5];
		for (int i = 0; i < chopsticks.length; i++) {
			chopsticks[i] = new ReentrantLock();
		}
		Philosophers philosophers[] = new Philosophers[5];
		Thread thread[] = new Thread[5];
		
		for(int i=0; i<philosophers.length; i++) {
			Lock leftChopstickLock = chopsticks[i];
			Lock rightChopstickLock = chopsticks[(i+1)%chopsticks.length];
			
			if (i%2==0) {
				philosophers[i] = new Philosophers(leftChopstickLock, rightChopstickLock);
			}
			else {
				philosophers[i] = new Philosophers(rightChopstickLock, leftChopstickLock);
			}
			thread[i] = new Thread(philosophers[i], "Philosopher" + (i+1));
			thread[i].start();
		}
	}
}
