package org.yuhang.algorithm.review;

/**
 * 目标和 LC494
 */
public class TargetSum {

    public int findTargetSumWays(int[] nums, int S) {
        int maxSum = 0;
        for(int num:nums){
            maxSum += num;
        }

        if(S>maxSum || S<-maxSum) return 0;//S大于了最大整数和或者小于了最小负数和，则返回0

        int[][] dp = new int[nums.length][maxSum*2+1];//dp[i][j]表示nums[0~i]能得到目标和为j的个数

        if(nums[0] == 0){
            dp[0][maxSum] = 2;
        }else{
            dp[0][maxSum+nums[0]] = 1;
            dp[0][maxSum-nums[0]] = 1;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < maxSum*2+1; j++) {
                //可以选择nums[i]或者-nums[i]，为了防止得到负数，将其加上maxSum
                if(j-nums[i]>=0){
                    dp[i][j] += dp[i-1][j-nums[i]];
                }
                if(j+nums[i]<maxSum*2+1){
                    dp[i][j] += dp[i-1][j+nums[i]];
                }

            }
        }


       return dp[nums.length-1][maxSum+S];

    }
}
