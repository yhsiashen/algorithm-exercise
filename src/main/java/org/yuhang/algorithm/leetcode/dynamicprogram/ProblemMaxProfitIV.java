package org.yuhang.algorithm.leetcode.dynamicprogram;

/** 股票买卖的最佳时机4  188  TODO
 * Created by chinalife on 2018/12/6.
 */
public class ProblemMaxProfitIV {

    public int maxProfit(int k, int[] prices) {
        if(prices==null || prices.length == 0 || k<=0)
            return 0;
        //二维数组dp[i][j]表示可以进行j次交易的情况下，长度为i的数组的最大利润
        int[][] dp = new int[prices.length][k+1];
        //初始边界
        for (int i = 0; i < prices.length; i++) {
            //只进行一次交易的情况下,求出各数组的最大利润
            dp[i][1] = maxOneProfit(prices);
        }

        //动态规划
        for (int i = 1; i < prices.length; i++) {
            for (int j = 2; j <= k; j++) {

            }
        }

        return dp[prices.length-1][k];
    }


    public int maxOneProfit(int[] prices) {
        if(prices==null || prices.length == 0)
            return 0;
        int minPrices = Integer.MAX_VALUE;
        int maxProfit =0;
        for (int i = 0; i <prices.length ; i++) {
            if(prices[i] < minPrices){
                minPrices = prices[i];
            }else if(maxProfit < prices[i] - minPrices){
                maxProfit = prices[i] - minPrices;
            }
        }
        return maxProfit;
    }
}
