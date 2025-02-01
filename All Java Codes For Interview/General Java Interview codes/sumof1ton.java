import java.io.*;
public class sumof1ton {
    public static void main(String[] arge) throws NumberFormatException, IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        int n = Integer.parseInt(br.readLine());
        for (int i = 1; i<=n; i++)
            sum+=i;
        System.out.println("Sum is : "+sum);
    }
}
