package org.yuhang.algorithm.leetcode.dynamicprogram;

/** 股票买卖的最佳时机4-允许完成k笔交易 188
 * Created by chinalife on 2018/12/6.
 */
public class ProblemMaxProfitIV {

    public int maxProfit(int k, int[] prices) {
        if(prices==null || prices.length == 0 || k<=0)
            return 0;
        int[][] dp = new int[k][2]; // dp[i][0]表示第i笔交易买入的最大收益,dp[i][1]表示第i笔交易卖出的最大收益
        for (int i = 0; i < k; i++) {
            dp[i][0] = Integer.MAX_VALUE;
        }

        for (int p:prices) {
            dp[0][0] = Math.max(dp[0][0],-p);
            dp[0][1] = Math.max(dp[0][1],dp[0][0]+p);
            for (int i = 1; i < k; i++) { //动态规划，填充dp，找出第k笔交易卖出的最大收益
                dp[i][0] = Math.max(dp[i][0],dp[i-1][1]-p);
                dp[i][1] = Math.max(dp[i][1],dp[i][0]+p);
            }
        }

        return dp[k-1][1];

    }



}
