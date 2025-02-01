import java.util.*;
public class primenumber_6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no : ");
        int n = sc.nextInt();
        boolean isPrime = true;
        if(n==1)
            System.out.println("Prime no start from 2");

        for (int i=2; i<n; i++)
        {
            if(n%i==0)
            {
                isPrime=false;
                break;
            }
        }
        if(isPrime)
            System.out.println("Given number "+n+" is prime number.");
        else
            System.out.println("Given number "+n+" is NOT prime number.");
    }
}
