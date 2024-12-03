package Parallelization;

public class ParallelWorkers extends Thread{
    private int low;
    private int high;
    private int[] nums;
    private int sum;

    public ParallelWorkers(int[] nums, int low, int high) {
        super();
        this.nums = nums;
        this.low = low;
        this.high = Math.min(nums.length, high);
    }


    @Override
    public void run() {
        sum=0;
        for(int i = low; i < high; i++){
            sum += nums[i];
        }
    }

    public int getSum() {
        return sum;
    }
}
