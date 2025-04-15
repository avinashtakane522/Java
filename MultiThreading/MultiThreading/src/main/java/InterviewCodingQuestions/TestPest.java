package InterviewCodingQuestions;

class EvenOddTest{
	private int num = 1;
	private int limit;
	
	public EvenOddTest(int limit) {
		this.limit = limit;
	}
	
	public synchronized void testEven() throws InterruptedException {
		while (num<limit) {
			if (num%2==1) {
				wait();
			}
			System.out.println(num++ +" is Even number.");
			notify();
		}
	}
	
	public synchronized void testOdd() throws InterruptedException {
		while (num<limit) {
			if (num%2==0) {
				wait();
			}
			System.out.println(num++ +" is Odd number.");
			notify();
		}
	}
}

public class TestPest {
public static void main(String[] args) {
	EvenOddTest eo = new EvenOddTest(10);
	
	new Thread(()->{
		try {
			eo.testEven();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}, "Thread-1").start();
	
	new Thread(()->{
		try {
			eo.testOdd();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}, "Thread-2").start();
}
}
