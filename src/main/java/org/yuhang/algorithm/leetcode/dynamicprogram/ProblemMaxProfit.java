package org.yuhang.algorithm.leetcode.dynamicprogram;

/** 买卖股票的最佳时机01-允许完成一笔交易  121
 * Created by chinalife on 2018/10/12.
 */
public class ProblemMaxProfit {

    /**
     * 暴力法
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
       int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i+1; j < prices.length; j++)
                if (prices[j] - prices[i] > maxProfit) {
                    maxProfit = prices[j] - prices[i];
                }
        }
        return maxProfit;
    }


    /**
     * 一次遍历，维护两个变量，找到最大利润
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices){
        int min = Integer.MAX_VALUE;//维护最小价格
        int maxProfit = Integer.MIN_VALUE;//维护最大利润
        for (int i = 0; i < prices.length; i++) {
            if(prices[i] < min) min = prices[i];
            else if(prices[i] - min > maxProfit) maxProfit = prices[i] - min;
        }
        return maxProfit;
    }
}
