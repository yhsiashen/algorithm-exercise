package org.yuhang.algorithm.interview;

/**
 * 按摩师
 */
public class ProblemtheMasseuseLcci {


    public int massage(int[] nums) {
       if(nums.length == 0) return 0;
       if(nums.length == 1) return nums[0];
       int res;
       int[] dp = new int[nums.length];//dp[i]表示以nums[i]结尾的最长预约时间
       dp[0] = nums[0];
       dp[1] = nums[1];
       res = Math.max(dp[0],dp[1]);
       for (int i = 2; i < dp.length; i++) {
           for (int j = i-2; j >=0 ; j--) {
               dp[i] = Math.max(dp[i],dp[j]+nums[i]);
           }

           res = Math.max(res, dp[i]);
       }
       return res;
    }

    public int massage1(int[] nums){
        if(nums.length == 0) return 0;
        int[] dp = new int[nums.length]; //dp[i]表示区间0~i的最长预约时间
        dp[0] = nums[0];
        for (int i = 1; i <dp.length ; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i]);//今天不预约或者今天预约的最大值
        }
        return dp[nums.length-1];

    }
}
