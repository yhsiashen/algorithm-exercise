package org.yuhang.algorithm.leetcode.dynamicprogram;

/** 买卖股票的最佳时机1  121
 * Created by chinalife on 2018/12/6.
 */
public class ProblemMaxProfitII {

    public int maxProfit(int[] prices) {
         if(prices==null || prices.length == 0)
             return 0;
         int[] maxProfit = new int[prices.length];
         maxProfit[0]=0;
        for (int i = 1; i < prices.length; i++) {
            for (int j = 0; j < i; j++) {
                  int curProfit = prices[i] - prices[j];
                  if(curProfit > maxProfit[i])
                      maxProfit[i] = curProfit;
            }
            if(maxProfit[i-1] > maxProfit[i])
                maxProfit[i] = maxProfit[i-1];
        }
        return maxProfit[prices.length-1];
    }

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(new ProblemMaxProfitII().maxProfit(prices));
    }

}
