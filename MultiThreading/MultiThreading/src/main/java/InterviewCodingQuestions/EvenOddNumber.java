package InterviewCodingQuestions;

import java.net.Authenticator;

public class EvenOddNumber {
	
	private int count = 1;
	private int limit;
	
	public EvenOddNumber(int limit){
		this.limit = limit;
	}
	
	public void printEven() {
		synchronized (this) {
			while (count < limit) {
				if (count%2==1) {
					try {
						wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				else {
					System.out.println(count++ +" is the Even number");
					notify();
				}
			}
		}
	}
	
	public void printOdd() {
		synchronized (this) {
			while (count < limit) {
				if (count%2==0) {
					try {
						wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				else {
					System.out.println(count++ +" is the Odd number");
					notify();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		EvenOddNumber number = new EvenOddNumber(11);
		
		Thread t1 = new Thread(number::printEven);
		Thread t2 = new Thread(number::printOdd);
		
		t1.start();
		t2.start();
	}
}
