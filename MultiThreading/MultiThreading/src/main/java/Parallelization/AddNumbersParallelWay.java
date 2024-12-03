package Parallelization;

public class AddNumbersParallelWay {
    public static void main(String[] args) {
        int nums[] = {1,2,3,4,5,6,7,8,9,10};

        int threads = Runtime.getRuntime().availableProcessors();
        System.out.println(new ParallelSum(threads).sum(nums));
    }
}
