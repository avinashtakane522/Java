package Parallelization;

public class ParallelSum {
    private ParallelWorkers[] workers;
    private int noOfThreads;
    public ParallelSum(int noOfThreads){
        this.workers = new ParallelWorkers[noOfThreads];
        this.noOfThreads = noOfThreads;
    }

    public int sum(int[] nums){
        int size = (int) Math.ceil(nums.length*1.0/noOfThreads);
        for(int i=0; i<noOfThreads; i++){
            workers[i] = new ParallelWorkers(nums, i*size, (i+1)*size);
            workers[i].start();
        }
        try {
            for(ParallelWorkers w : this.workers){
                w.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int totalSum=0;

            for(ParallelWorkers w : this.workers)
               totalSum += w.getSum();
        return totalSum;
    }
}
