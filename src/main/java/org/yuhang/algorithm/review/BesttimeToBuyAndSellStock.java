package org.yuhang.algorithm.review;

/**
 * 买卖股票的最佳时机 LC121
 */
public class BesttimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {
       int res = 0;
       int minPrice = prices[0];
       for (int i = 1; i <prices.length ; i++) {
           if(prices[i] > minPrice){
               res = Math.max(res, prices[i]- minPrice);
           }
           minPrice = Math.min(minPrice, prices[i]);
       }
       return res;

    }
}
