package Parallelization;

import java.util.Random;

public class EfficiencySequentialAndParallel {
    public static void main(String[] args) {
        Random random = new Random();
        int size = Runtime.getRuntime().availableProcessors();
        int[] num = new int[100000000];

        for (int i = 0; i < 100000000; i++) {
            num[i] = random.nextInt(100);
        }

        long start = System.currentTimeMillis();
        SequentialWay sequentialWay = new SequentialWay();
        System.out.println("Sum is: "+sequentialWay.sum(num));
        System.out.println("Sequential way Time: " + (System.currentTimeMillis() - start));

        start = System.currentTimeMillis();
        ParallelSum parallelSum = new ParallelSum(size);
        System.out.println("Sum is: "+parallelSum.sum(num));
        System.out.println("Parallel way Time: " + (System.currentTimeMillis() - start));
    }
}
