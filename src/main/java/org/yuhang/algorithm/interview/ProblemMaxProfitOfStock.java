package org.yuhang.algorithm.interview;

/**
 * 股票的最大利润
 */
public class ProblemMaxProfitOfStock {

    public int maxProfit(int[] prices) {
        if(prices.length == 0) return 0;
        int res = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            res = Math.max(res, prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return res;
    }
}
