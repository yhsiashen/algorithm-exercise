package org.yuhang.algorithm.review;

/**
 * 最大子数组的和 LC53
 */
public class MaximumSubarray {

    /**
     * 前缀和
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        if(nums.length == 0) return 0;
        int[] preSum = new int[nums.length+1];
        for(int i = 1; i < preSum.length ;i++){
            preSum[i] = preSum[i-1] + nums[i-1];
        }
        int minSum = Integer.MAX_VALUE;
        int res = Integer.MIN_VALUE;
        for(int i=1; i< preSum.length;i++){
            minSum = Math.min(minSum, preSum[i-1]);
            res = Math.max(res, preSum[i]-minSum);
        }
        return res;

    }

    /**
     * 动态规划
     * @param nums
     * @return
     */
    public int maxSubArray2(int[] nums){
        if(nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int res = dp[0];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Math.max(nums[i], dp[i-1]+nums[i]);
            res = Math.max(res, dp[i]);

        }
        return res;
    }



    public static void main(String[] args) {
        int[] nums = {-2,-1};
        System.out.println(new MaximumSubarray().maxSubArray(nums));
    }
}
