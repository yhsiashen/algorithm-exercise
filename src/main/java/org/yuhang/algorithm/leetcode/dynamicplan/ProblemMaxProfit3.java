package org.yuhang.algorithm.leetcode.dynamicplan;

import java.util.Arrays;

/** 买卖股票的最佳时机3 123
 * Created by chinalife on 2018/12/6.
 */
public class ProblemMaxProfit3 {

    public int maxProfit(int[] prices) {
        if(prices==null || prices.length == 0)
            return 0;
        int maxProfit = 0;
        for (int i = 1; i <=  prices.length ; i++) {
             int curProfit = maxOneProfit(Arrays.copyOfRange(prices,0,i))
                             + maxOneProfit(Arrays.copyOfRange(prices,i,prices.length));
             if(maxProfit < curProfit)
                 maxProfit = curProfit;
        }
        return maxProfit;
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


    public static void main(String[] args) {
        int[] prices = {3,3,5,0,0,3,1,4};
        System.out.println(new ProblemMaxProfit3().maxProfit(prices));
    }
}
