package org.yuhang.algorithm.leetcode.dynamicprogram;

/** 股票买卖最大利润问题  121
 * Created by chinalife on 2018/10/12.
 */
public class ProblemMaxProfit {


    /**
     * 暴力法
     * @param prices
     * @return
     */
    public int maxProfit1(int[] prices) {
       int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i+1; j < prices.length; j++)
                if (prices[j] - prices[i] > maxProfit) {
                    maxProfit = prices[j] - prices[i];
                }
        }
        return maxProfit;
    }
}
