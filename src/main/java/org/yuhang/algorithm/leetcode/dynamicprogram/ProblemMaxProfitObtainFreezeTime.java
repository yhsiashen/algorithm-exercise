package org.yuhang.algorithm.leetcode.dynamicprogram;

/**
 * 股票的最佳买卖时期含1天冷冻期 309
 * Created by chinalife on 2018/12/6.
 */
public class ProblemMaxProfitObtainFreezeTime {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;
        //定义3个状态(买入,卖出和冻结)下的最大收益
        int[] sell = new int[prices.length];
        int[] buy = new int[prices.length];
        int[] cooldown = new int[prices.length];
        //第一天不卖
        sell[0] = 0;
        //第一天可以买
        buy[0] = -prices[0];
        //第一天不为冷冻期
        cooldown[0] = 0;
        for (int i = 1; i < prices.length; i++) {
            //第i天是冷冻期,则收益为第i-1天的卖股票收益
            cooldown[i] = sell[i - 1];
            //第i天卖股票的收益为:若第i天不卖股票,则就是i-1天的收益或者是若第i天卖股票,则为i-1天的收入+i天的股票价格.取两者的大值
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
            //第i天买股票的收益为:若第i天不买股票,则就是i-1天的买股票价格或者若是第i天买股票,则是i-1的冷冻期收益-i天的股票价格.取两者的大值
            buy[i] = Math.max(buy[i - 1], cooldown[i - 1] - prices[i]);
        }

        return Math.max(sell[prices.length - 1], cooldown[prices.length - 1]);

    }
}
