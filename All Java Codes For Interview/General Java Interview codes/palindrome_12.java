import java.util.Scanner;

public class palindrome_12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int rev = 0;
        int t = n;
        while (n != 0) {
            rev = rev * 10 + (n % 10);
            n = n / 10;
        }
        if (rev == t)
            System.out.println(t + " is palindrome number");
        else
            System.out.println(t + " is NOT palindrome number");

    }
}
