import java.util.Scanner;
public class perfectnumber_10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = 1;
        for(int i = 2; i<=n/2; i++){
            if(n%i==0)
                sum+=i;
        }
        if(sum==n)
            System.out.println("Given number "+n+" is perfect number.");
        else
            System.out.println("Given number "+n+" is NOT perfect number.");
    }
}
