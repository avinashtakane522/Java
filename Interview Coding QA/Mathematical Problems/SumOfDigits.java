public class SumOfDigits {
    public static int sumOfDigits(int n){
        int sum=0;
        while (n!=0) {
            int rem = n%10;
            n = n/10;
            sum = sum + rem;
        }
        return sum;
    }
    public static void main(String[] args) {
        System.out.println(sumOfDigits(687));
    }
}
