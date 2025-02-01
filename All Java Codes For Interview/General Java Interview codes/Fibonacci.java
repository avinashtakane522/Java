
// Write a program to display FIBONACCI series of a number?
import java.util.InputMismatchException;
import java.util.Scanner;
import com.customexception.*;

class Fibonacci {
    static int fib(int n) {
        if (n <= 1)
            return n;
        else
            return fib(n - 1) + fib(n - 2);
    }

    static int fibb(int n) {
        if (n <= 1) {
            return n;
        }
        int pn = 1;
        int fibn = 1;
        for (int i = 2; i <= n; i++) {
            int temp = fibn;
            fibn += pn;
            pn = temp;
        }
        return fibn;
    }

    public static void main(String[] args) {
        try {
            work();
        } catch (CustomException e) {
            System.out.println(e);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input type entered. Please enter a valid number.");
        }
    }

    static void work() throws CustomException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number : ");
        int n = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the fib choice 'fib' or 'fibb' : ");
        String choice = sc.nextLine(), str = null;
        int num = 0;
        switch (choice) {
            case "fib":
                num = fib(n);
                break;
            case "fibb":
                num = fibb(n);
                break;
            default:
                throw new CustomException("Selected wrong choice");
        }
        System.out.println(num != 0 ? num : str);
    }
}