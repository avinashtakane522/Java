import java.util.*;

public class NumberPattern {
    public ArrayList<Integer> printPat(int n) {
        // write code here
        ArrayList<Integer> result = new ArrayList<>();
        for (int row = n; row >= 1; row--) {
            for (int num = n; num >=1; num--) {
                for(int repeat=row; repeat>0; repeat--){
                    result.add(num);
                }
            }
            result.add(-1);
        }
        return result;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);        
        System.out.println("Enter the range : ");
        int n = sc.nextInt();        
        System.err.println(new NumberPattern().printPat(n));
    }
}