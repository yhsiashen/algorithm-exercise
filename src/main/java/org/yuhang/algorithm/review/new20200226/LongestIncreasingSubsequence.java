package org.yuhang.algorithm.review.new20200226;

/**
 * 最长上升子序列
 *
 * 输入：nums = [10,9,2,5,3,7,101,18]
 * 输出：4
 * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
 *
 * 1 <= nums.length <= 2500
 * -104 <= nums[i] <= 104
 */
public class LongestIncreasingSubsequence {

    /**
     * O(n^2)
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 1) return 1;
        int len = nums.length;
        int max = 1;
        int[] dp = new int[len];//dp[i]表示以nums[i]结尾的数组的最长递增子序列
        for (int i = 0; i < len; i++) {
            dp[i] = 1;
            for (int j = i-1; j >=0 ; j--) {
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                    max = Math.max(max, dp[i]);
                }
            }
        }
        return max;
    }

}
