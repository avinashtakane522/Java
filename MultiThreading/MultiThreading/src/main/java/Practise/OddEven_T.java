package Practise;

import java.security.interfaces.RSAMultiPrimePrivateCrtKey;

public class OddEven_T {
	public static void main(String[] args) {
		EvenOdd_T eo = new EvenOdd_T(10);
		
		Thread even = new Thread(eo::printEven);
		Thread odd = new Thread(eo::printOdd);
		
		even.start();
		odd.start();
	}
}

class EvenOdd_T{
	private int limit;
	private int count=1;
	
	public EvenOdd_T(int limit) {
		this.limit = limit;
	}
	
	public void printEven() {
		while (true) {
			synchronized (this) {
				if (count < limit) {
					if (count%2 != 0) {
						try {
							wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					System.out.println(count++ +" is Even number");
					notify();
				}
			}
		}
	}
	
	public void printOdd() {
		while (true) {
			synchronized (this) {
				if (count < limit) {
					if (count%2 == 0) {
						try {
							wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					System.out.println(count++ +" is Odd number");
					notify();
				}
			}
		}
		}
}
