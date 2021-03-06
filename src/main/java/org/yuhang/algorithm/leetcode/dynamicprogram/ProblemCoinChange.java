package org.yuhang.algorithm.leetcode.dynamicprogram;

import java.util.Arrays;

/**
 * 换钱的最少货币数 322
 * Created by chinalife on 2018/10/27.
 */
public class ProblemCoinChange {

    public int getMinMoney(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0)
            return -1;
        int n = arr.length;
        int max = Integer.MAX_VALUE;
        // 用二维数组dp[n][aim] 代表 arr[n]中组成aim的最少货币数
        int[][] dp = new int[n][aim + 1];

        for (int i = 1; i < aim+1; i++) {
            if (i % arr[0] == 0) {
                dp[0][i] = i / arr[0];
            } else {
                dp[0][i] = max;
            }
        }
        int left;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < aim + 1; j++) {
                left = max;
                if (j - arr[i] >= 0 && dp[i][j - arr[i]] != max) {
                    left = dp[i][j - arr[i]] + 1;
                   }
                dp[i][j] = Math.min(left,dp[i-1][j]);
            }
        }

        return dp[n-1][aim]!=max?dp[n-1][aim]:-1;
    }

    public int coinChange1(int[] coins, int amount) {
        if(coins.length == 0) return -1;
        int[] dp = new int[amount+1];//dp[i]表示凑够i钱需要的硬币数量
        Arrays.fill(dp,0,amount+1,Integer.MAX_VALUE);//初始状态填充为MAX_VALUE
        dp[0] = 0;
        for (int i = 0; i < dp.length ; i++) {
            for(int coin:coins){
                if(i-coin < 0) continue;
                dp[i] = Math.min(dp[i],dp[i-coin]+1);
            }
        }
        return dp[amount] == Integer.MAX_VALUE?-1:dp[amount];
    }

    public static void main(String[] args) {
        //[186,419,83,408]
        //6249
        int[] coins = {186,419,83,408};
        int aim = 6249;
        System.out.println(new ProblemCoinChange().getMinMoney(coins,aim));


    }
}
