package org.yuhang.algorithm.leetcode.greedyalgo;

/** 股票买卖的最佳时机02  122
 * Created by chinalife on 2018/12/6.
 */
public class ProblemMaxProfitII {


    public int maxProfit(int[] prices) {
         if(prices==null || prices.length == 0)
             return 0;
         int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if(prices[i] - prices[i-1] > 0)
                maxProfit += prices[i] - prices[i-1];
        }
       return maxProfit;
    }



    public static void main(String[] args) {
        int[] pri = {3,3,5,0,0,3,1,4};
        System.out.println(new ProblemMaxProfitII().maxProfit(pri));
//        System.out.println(Arrays.toString(Arrays.copyOfRange(pri, 0, 3)));
    }
}
