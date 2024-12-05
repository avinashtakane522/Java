package StreamAPI;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Parallelization2 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        long numOfPrimes = IntStream.rangeClosed(2, Integer.MAX_VALUE/100)
                .filter(Parallelization2::isPrime).count();
        System.out.println(numOfPrimes);
        System.out.println(System.currentTimeMillis() - start);

        start = System.currentTimeMillis();
        numOfPrimes = IntStream.rangeClosed(2, Integer.MAX_VALUE/100).parallel()
                .filter(Parallelization2::isPrime).count();
        System.out.println(numOfPrimes);
        System.out.println(System.currentTimeMillis() - start);
    }

    private static boolean isPrime(int n){
        if (n <= 1) return false;
        if (n == 2) return true;
        if (n%2 == 0) return false;

        long range = (long) Math.sqrt(n);

        for (int i = 3; i < range; i++)
            if (n % i == 0) return false;
        return true;
    }
}
