package org.yuhang.concurrency.forkjoinpool;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.LongStream;

/**
 * 计算器，用多线程 ExecutorService 实现
 */
public class ExecutorServiceCalcutor {

    private int parallism;
    private ExecutorService pool;

    public ExecutorServiceCalcutor() {
        //处理器的核心数
        this.parallism = Runtime.getRuntime().availableProcessors();
        System.out.println("处理器核心数为:"+parallism);
        this.pool = Executors.newFixedThreadPool(parallism);
    }

    private static class SumTask implements Callable<Long> {

        private long[] numbers;
        private int from;
        private int to;

        public SumTask(long[] numbers, int from, int to){
            this.numbers = numbers;
            this.from = from;
            this.to = to;
        }


        @Override
        public Long call() throws Exception {
            long res = 0;
            for (int i = from; i <= to; i++) {
                res += numbers[i];
            }
            return res;
        }
    }

    public long sum(long[] numbers){

        List<Future<Long>> result  =  new ArrayList<>();
        int part = numbers.length/parallism;//将要处理的数据分成parallism份,每份part个数字,然后用parallism个线程处理

        for (int i = 0; i <  parallism; i++) {
            int from = i*part;
            int to = (i==parallism-1)? numbers.length-1 :(i+1)*part-1;
            result.add(pool.submit(new SumTask(numbers, from ,to)));

        }

        long res = 0;
        for(Future<Long> future:result){
            try {
                res+=future.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        return res;
    }

    public static void main(String[] args) {
        long[] numbers = LongStream.rangeClosed(1,10000000).toArray();
        ExecutorServiceCalcutor calcutor = new ExecutorServiceCalcutor();
        long res = calcutor.sum(numbers);
        System.out.println(res);
    }
}
