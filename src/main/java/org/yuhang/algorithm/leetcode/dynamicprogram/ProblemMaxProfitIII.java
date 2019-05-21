package org.yuhang.algorithm.leetcode.dynamicprogram;

import java.util.Arrays;

/** 买卖股票的最佳时机3-允许完成最多两笔交易 123
 * Created by chinalife on 2018/12/6.
 */
public class ProblemMaxProfitIII {

    /**
     * 动态规划-维护4个状态，依次动态规划
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices){
        int firstBuy = Integer.MIN_VALUE;//第一笔买入股票所获得的收益
        int secondBuy = Integer.MIN_VALUE;//第一笔卖出股票所获得的收益
        int firstSell = 0;//第二笔买入股票所获得的收益
        int secondSell = 0;//第二笔卖出股票所获得的收益
        for (int i = 0; i < prices.length; i++) {
            firstBuy = Math.max(firstBuy,-prices[i]);
            firstSell = Math.max(firstSell,prices[i] - firstBuy);
            secondBuy = Math.max(secondBuy,firstSell-prices[i]);
            secondSell = Math.max(secondSell,prices[i]-secondBuy);
        }

        return secondSell;
    }



    /**
     * 分隔数组，分别计算两笔交易的最大利润，然后计算总的最大利润
     * @param prices
     * @return
     */
    public int maxProfit1(int[] prices) {
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
        System.out.println(new ProblemMaxProfitIII().maxProfit(prices));
    }
}
