package org.yuhang.concurrency.forkjoinpool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**  forkJoinPool  fork-拆分 join-合并
 * Created by chinalife on 2018/7/27.
 */
public class TestForkJoinPool {

     public static final Integer MAX = 200;

     //静态内部类，实现递归任务父类的任务类
     static class MyForkJoinTask extends RecursiveTask<Integer>{

         //子任务开始计算的值
         private Integer startValue;
         //子任务结束计算的值
         private Integer endValue;

         public MyForkJoinTask(Integer startValue, Integer endValue) {
             this.startValue = startValue;
             this.endValue = endValue;
         }

         @Override
         protected Integer compute() {
            //如果if条件成立，说明此任务所需计算的数值分足够小，可以计算了
             if(endValue-startValue <MAX){
                 System.out.println("开始计算的数为:"+startValue+",结束计算的数为:"+endValue);
                 Integer total = 0;
                 for (Integer integer = startValue; integer < this.endValue; integer++) {
                     total+=integer;
                 }
                 return total;
             }//条件不成立，则继续拆分子任务
             else {
                 MyForkJoinTask subTask1 = new MyForkJoinTask(startValue,(startValue+endValue)/2);
                 subTask1.fork();
                 MyForkJoinTask subTask2 = new MyForkJoinTask((startValue+endValue)/2,endValue);
                 subTask2.fork();
                 return subTask1.join()+subTask2.join();
             }
         }
     }

    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<Integer> taskFuture = forkJoinPool.submit(new MyForkJoinTask(1,1001));
        try {
            Integer result = taskFuture.get();
            System.out.println("result = "+result);
        }  catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
    }


}
