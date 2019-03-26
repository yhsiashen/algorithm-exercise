package org.yuhang.concurrency.forkjoinpool;

import java.util.Arrays;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**  forkJoinPool 进行归并排序
 * Created by chinalife on 2018/7/27.
 */
public class TestForkJoinPoolForMergeSort {

    static class MySortTask extends RecursiveTask<int[]>{
       private int init[];

        public MySortTask(int[] init) {
            this.init = init;
        }

        @Override
        protected int[] compute() {
            // 待排序元素超过两个，继续fork
            if(init.length>2){
                int midIndex = init.length/2;
                MySortTask subtask1= new MySortTask(Arrays.copyOf(init,midIndex));
                subtask1.fork();
                MySortTask subtask2 = new MySortTask(Arrays.copyOfRange(init,midIndex,init.length));
                subtask2.fork();
               //将两个有序数组合并成一个有序数组
                int result1[] = subtask1.join();
                int result2[] = subtask2.join();
                return(joinInts(result1,result2));
            }
            //待排序元素小于等于2个，则排序这2个元素
            else {
                if(init.length==1 || init[0] <= init[1]){
                      return init;
                }else {
                    int result[] = new int[2];
                    result[0] = init[1];
                    result[1] = init[0];
                    return result;
                }
            }
        }

         static int[] joinInts(int[] result1,int[] result2){
            return null;
        }
    }
}
