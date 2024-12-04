package Parallelization;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

class MergeSort extends RecursiveTask<int[]> {
    private int[] arr;
    public MergeSort(int[] arr) {
        this.arr = arr;
    }

    @Override
    protected int[] compute() {
        if (arr.length < 2) {
            return arr;
        }

        int mid = arr.length / 2;
        int[] left = new int[mid];
        int[] right = new int[arr.length - mid];

        System.arraycopy(arr, 0, left, 0, mid);
        System.arraycopy(arr, mid, right, 0, arr.length-mid);

        MergeSort lefttask = new MergeSort(left);
        MergeSort righttask = new MergeSort(right);

        invokeAll(lefttask, righttask);

        return merge(lefttask.join(), righttask.join());
    }

    public int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int i=0, j=0, k=0;
        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                result[k++] = left[i++];
            }else {
                result[k++] = right[j++];
            }
        }

        //add remaining element
        while(i< left.length){
            result[k++] = left[i++];
        }

        while(j< right.length){
            result[k++] = right[j++];
        }
        return result;
    }
}

public class MergeSortParallelExample {
    public static void main(String[] args) {
        int[] arr = { 5, 4, 3, 2, 1 };

        MergeSort task = new MergeSort(arr);
        ForkJoinPool pool = new ForkJoinPool();
        int[] result = pool.invoke(task);

        System.out.println(Arrays.toString(result));
    }
}
