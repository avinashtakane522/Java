class Car {
    int prize (int param) throws ArithmeticException{
        System.out.println("In method");
        int x = param / 0;
        return x;
    }
}

public class exception1 {
    public static void main(String[] args) {
        Car obj = new Car();
        int prize = 0;
        try {
            prize = obj.prize(100);
        } catch (ArithmeticException e) {
            System.out.println("The exception is: " + e);
        } catch (Exception e) {
            System.out.println("Print the parent exception : "+e);
        }
        System.out.println("Prize of a car: " + prize);
    }
}