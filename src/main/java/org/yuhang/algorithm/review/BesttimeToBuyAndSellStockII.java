package org.yuhang.algorithm.review;

/**
 * 买卖股票的最佳时机II LC122
 */
public class BesttimeToBuyAndSellStockII {

    public int maxProfit(int[] prices) {
       if(prices.length == 0) return 0;
       int res = 0;
       int preminPrice = prices[0];
       for (int i = 1; i < prices.length; i++) {
           if(prices[i] > preminPrice) {
               res += prices[i] - preminPrice;
           }
           preminPrice = prices[i];
       }

       return res;


    }
}
