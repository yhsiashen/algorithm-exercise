package org.yuhang.algorithm.leetcode.dynamicprogram;

/**
 * 连续子数组的最大和
 * @tag:动态规划
 */
public class ProblemMaximumSumSubarray {


    public int maxSubArray(int[] nums) {
       if(nums.length == 0) return 0;
       int[] dp = new int[nums.length];//dp[i]表示以nums[i]结尾的子数组的最大和
       dp[0] = nums[0];
       int res = Integer.MIN_VALUE;
       for (int i = 0; i < nums.length; i++) {
            dp[i] = nums[i]+ dp[i-1]>0?dp[i-1]:0;
            res = Math.max(res,dp[i]);
       }
       return res;
    }
}
