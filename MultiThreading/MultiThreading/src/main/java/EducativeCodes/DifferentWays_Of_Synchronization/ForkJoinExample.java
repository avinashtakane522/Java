package EducativeCodes.DifferentWays_Of_Synchronization;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

class SumArray extends RecursiveTask<Integer> {
    private int start;
    private int end;
    private int[] arr;

    public SumArray(int[] arr, int start, int end){
        this.start = start;
        this.end = end;
        this.arr = arr;
    }

    @Override
    protected Integer compute() {
        if (end - start <= 5){
            int sum = 0;
            for (int i = start; i < end; i++){
                sum += arr[i];
            }
            return sum;
        } else {
            int mid = (start + end) / 2;

            SumArray left = new SumArray(arr, start, mid);
            SumArray right = new SumArray(arr, mid, end);

            left.fork();
            int rightSum = right.compute();
            int leftSum = left.join();

            return leftSum + rightSum;
        }
    }
}

public class ForkJoinExample {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        ForkJoinPool pool = new ForkJoinPool();
        int sum = pool.invoke(new SumArray(arr, 0, arr.length));
        System.out.println("Sum : "+sum);
    }
}
