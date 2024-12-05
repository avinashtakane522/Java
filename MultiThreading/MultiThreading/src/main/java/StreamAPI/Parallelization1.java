package StreamAPI;

import java.util.stream.LongStream;

public class Parallelization1 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(sum(1000000000));
        System.out.println(System.currentTimeMillis() - start);

        start = System.currentTimeMillis();
        System.out.println(parallelSum(1000000000));
        System.out.println(System.currentTimeMillis() - start);
    }

    private static long sum(long num){
        return LongStream.rangeClosed(1, num).reduce(0L, Long::sum);
    }

    private static long parallelSum(long num){
        return LongStream.rangeClosed(1, num).parallel().reduce(0L, Long::sum);
    }
}
