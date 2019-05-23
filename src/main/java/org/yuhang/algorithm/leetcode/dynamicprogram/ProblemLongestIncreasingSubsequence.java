package org.yuhang.algorithm.leetcode.dynamicprogram;

/**
 * 最长的上升子序列 300
 */
public class ProblemLongestIncreasingSubsequence {

    /**
     * 动态规划-时间复杂度 O(n^2)
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length ==0) return 0;
        int[] dp = new int[nums.length]; //dp[i]表示以nums[i]结尾的最长上升子序列
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;//最小为1,只包含当前元素
            for (int j = 0; j < i; j++) {
                if(nums[i] > nums[j]) dp[i] = Math.max(dp[i],dp[j]+1);
            }
            res = Math.max(res,dp[i]);
        }
        return res;
    }


    public static void main(String[] args) {
        int[] nums = {4,10,4,3,8,9};
        System.out.println(new ProblemLongestIncreasingSubsequence().lengthOfLIS(nums));
    }
}
