import java.util.Scanner;
public class rangeperfectnum_11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int num=2; num<=n; num++){
            int sum = 1;
            for(int i=2; i<=num/2; i++){
                if(num%i==0)
                    sum+=i;
            }
            if(sum==num)
                System.out.print(num+" ");
        }
    }
}
