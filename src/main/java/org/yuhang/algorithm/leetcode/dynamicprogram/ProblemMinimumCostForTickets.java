package org.yuhang.algorithm.leetcode.dynamicprogram;

/**
 * 最低票价 LC983
 * @tag:动态规划
 */
public class ProblemMinimumCostForTickets {

    public int mincostTickets(int[] days, int[] costs) {
        int len  = days.length;
        int maxDay = days[len-1];
        int minDay = days[0];
        int[] minCost = new int[maxDay+31];//minCost[i]表示i~365天出行花费的最少钱
        for (int i = len-1,d = maxDay; d >= minDay ; d--) {
            if(d == days[i]){//第d天要出行，则有三种买票方案，选最小的一种
                minCost[d] = Math.min(minCost[d+1]+costs[0],minCost[d+7]+costs[1]);
                minCost[d] = Math.min(minCost[d], minCost[d+30]+costs[2]);
                i--;
            }else{
                minCost[d] = minCost[d+1];//不出行，则不买票
            }
        }

        return minCost[minDay];
    }


    public static void main(String[] args) {
        int[] days = {1,4,6,7,8,20};
        int[] costs = {2,7,15};
        System.out.println(new ProblemMinimumCostForTickets().mincostTickets(days,costs));

    }
}
