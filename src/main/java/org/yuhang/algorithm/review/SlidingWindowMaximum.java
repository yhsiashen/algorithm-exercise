package org.yuhang.algorithm.review;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 滑动窗口的最大值 LC239
 */
public class SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if(k < 0) return null;
        int[] res = new int[nums.length-k+1];
        int cnt = 0;
        Deque<Integer> queue = new LinkedList<>();
        int l = 0,r = 0;
        while (r < k) {//初始化窗口
            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[r]) {
                queue.pollLast();
            }
            queue.offer(r);
            r++;
        }
        res[cnt++] = nums[queue.peek()];
        r--;

        while (r < nums.length-1){
            if(queue.peek() == l){
                queue.poll();
            }
            l++;
            r++;
            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[r]){
                queue.pollLast();
            }
            queue.offer(r);
            res[cnt++] = nums[queue.peek()];//最大值
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int[] res = new SlidingWindowMaximum().maxSlidingWindow(nums,3);
        for(int i:res){
            System.out.print(i+" ");
        }
    }
}
