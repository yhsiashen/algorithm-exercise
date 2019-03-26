package org.yuhang.algorithm.leetcode.queue;

import java.util.Arrays;

/**
 * 滑动窗口的最大值,O(k*n) 239
 */
public class ProblemMaxSlidingWindow {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0)
            return new int[0];
        int max = Integer.MIN_VALUE;
        int[] result = new int[nums.length-k+1];
        for (int i = 0; i < nums.length-k+1; i++) {
            for (int j = i; j < i+k; j++) {
                if(nums[j] > max)
                    max = nums[j];
            }
            result[i] = max;
            max = Integer.MIN_VALUE;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int[] result = new ProblemMaxSlidingWindow().maxSlidingWindow(nums,3);
        System.out.println(Arrays.toString(result));
    }
}
