import java.util.*;

public class numtable_8and9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 1; i <= 10; i++) {
            System.out.println(n + " * " + i + " = " + (n * i));
        }
        System.out.println("now try with multiple table format, Enter the no : ");
        tables();
        sc.close();
    }

    public static void tables() {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    for (int k = 1; k <= 10; k++) {
    System.err.println();
    for (int i = 1; i <= n; i += 1) {
    System.out.printf("%2d * %2d = %3d ", i, k, i * k);
    }
    }}
}
