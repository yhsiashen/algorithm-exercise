package org.yuhang.algorithm.leetcode.dynamicprogram;


/**
 * 计算各个位数不同的数字个数 LC357
 * @tag:动态规划
 */
public class ProblemCountNumbersWithUniqueDigits {


    public int countNumbersWithUniqueDigits(int n) {
        if(n == 0) return 1;
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 10;
        for (int i = 0; i < dp.length; i++) {
            dp[i] = dp[i-1] + (dp[i-1]-dp[i-2]) * (10-(i-1));
        }
        return dp[n];
    }
}
