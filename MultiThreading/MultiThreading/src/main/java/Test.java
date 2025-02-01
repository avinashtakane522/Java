class EvenOddLogic{
    private int count=1;
    private int limit;

    public EvenOddLogic(int limit){
        this.limit = limit;
    }

    public synchronized void printEven() throws InterruptedException {
        while(count<=limit) {
        while(count%2 != 0){
            wait();
        }
        System.out.println(count+"is Even number ");
        count++;
            notify();
    }}
    public synchronized void printOdd() throws InterruptedException {
        while(count<=limit) {
        while(count%2 == 0){
            wait();
        }
        System.out.print(count+"is odd number ");
        count++;
        notify();
    }}
}

public class Test {
    public static void main(String[] args) throws InterruptedException {
        EvenOddLogic eo = new EvenOddLogic(10);
        Thread even = new Thread(new Runnable(){
            public void run(){
                try {
                    eo.printEven();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread odd = new Thread(new Runnable(){
            public void run(){
                try {
                    eo.printOdd();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        even.start();
        odd.start();

        even.join();
        odd.join();
    }
}
