package org.yuhang.algorithm.leetcode.dynamicprogram;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 环形子数组的最大和 LC918
 */
public class ProblemMaximumSumCircularSubarray {

    /**
     * 动态规划
     * @param A
     * @return
     */
    public int maxSubarraySumCircular(int[] A) {
       if(A.length == 0) return 0;
       int curMax,max,curMin,min,sum;
       curMax = max = curMin = min = sum = A[0];
       for (int i = 1; i < A.length; i++) {
          sum += A[i];
          curMax = curMax>0?curMax+A[i]:A[i];
          max = Math.max(max,curMax);
          curMin = curMin<0?curMin+A[i]:A[i];
          min = Math.min(min,curMin);
       }
       if(max<0) return max;
       return Math.max(sum-min,max); //sum-min表示跨环形的子数组的最小值，max表示A的子数组的最小值

    }

    /**
     * 前缀和+队列
     * @param A
     * @return
     */
    public int maxSubarraySumCircular1(int[] A) {
        if(A.length == 0) return 0;
        int[] preSum = new int[A.length*2+1];
        for (int i = 0; i < preSum.length-1; i++) {
             preSum[i+1] = preSum[i] + A[i%A.length];
        }

        //前缀和向减即得子数组和，要得到preSum[j]-preSum[i]的最大值，
        //在遍历j的基础上，preSum[i]越小，则结果越大，
        //用一个单调递增队列保存最小值(索引值)，队头最小，在超过环形数组范围时，去掉队头
        Deque<Integer> deque = new ArrayDeque<>();
        deque.offer(0);
        int res = A[0];
        for (int j = 1; j < preSum.length; j++) {
            if(j-A.length > deque.peek()){
                deque.poll();
            }
            res = Math.max(res, preSum[j] - preSum[deque.peek()]);
            while (!deque.isEmpty() && preSum[j] <= preSum[deque.peekLast()]){
                deque.pollLast();
            }
            deque.offer(j);
        }

        return res;

    }


    public static void main(String[] args) {
        int[] A = {6,9,-3};
        System.out.println(new ProblemMaximumSumCircularSubarray().maxSubarraySumCircular(A));
    }
}
