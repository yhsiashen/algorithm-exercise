package org.yuhang.concurrency.forkjoinpool;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * 计算器，用多线程 ForkJoinPool 实现
 */
public class ForkJoinPoolCalculator {

    private ForkJoinPool forkJoinPool;

    public ForkJoinPoolCalculator(){
        this.forkJoinPool = new ForkJoinPool();
    }


    private static class SumTask extends RecursiveTask<Long> {

        private long[] numbers;
        private int from;
        private int to;

        public SumTask(long[] numbers, int from, int to) {
            this.numbers = numbers;
            this.from = from;
            this.to = to;
        }

        //对任务进行拆分，拆分的好坏决定了处理的效率
        @Override
        protected Long compute() {
            long result  = 0;
            //当任务规模小于等于6时，直接计算
            if(to-from <= 6){
                for (int i = from; i <=to ; i++) {
                    result+=numbers[i];
                }
                return result;
            }else{//当任务规模大于6时，拆分计算
                int mid = (from+to)/2;
                SumTask leftTask = new SumTask(numbers, from, mid);
                SumTask rightTask = new SumTask(numbers, mid+1, to);
                leftTask.fork();//拆分成了左任务
                rightTask.fork();//拆分成了右任务

                //拆分成两个任务后递归进行计算,具体任务分配给线程则交给了框架完成
                return leftTask.join()+rightTask.join();


            }
        }
    }

    public Long sum(long[] numbers){
        return forkJoinPool.invoke(new SumTask(numbers,0,numbers.length-1));
    }
}
