package org.yuhang.algorithm.leetcode.queue;

import java.util.ArrayDeque;
import java.util.Arrays;


/**
 * 滑动窗口的最大值,队列辅助实现,复杂度为O(n)  239
 */
public class ProblemMaxSlidingWindowByQueue {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length==0)
            return new int[0];
        //结果集合
        int l = nums.length-k+1;
        int[] result = new int[l];
        int count =0;
        //一个辅助队列帮助找到窗口的最大值,队列中放数组下标index
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        //遍历数组
        for (int i = 0; i < nums.length; i++) {
            if(!deque.isEmpty()){
                //若队列元素不在滑动窗口中了，则删除头元素
                if(deque.peek() <= i-k){
                    deque.pop();
                }

                //若当前数字大于队列尾，则删除队列尾，直到当前数字小于等于队列尾，或者队列为空
                while (!deque.isEmpty() && nums[i] >= nums[deque.getLast()] ){
                    deque.removeLast();
                }
            }

            deque.offer(i);
            //判断此时的索引位是否大于窗口
            if(i+1>=k){
                result[count++] = nums[deque.peek()];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int[] result = new ProblemMaxSlidingWindowByQueue().maxSlidingWindow(nums,3);
        System.out.println(Arrays.toString(result));
    }
}
