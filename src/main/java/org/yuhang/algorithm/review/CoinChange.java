package org.yuhang.algorithm.review;

import java.util.Arrays;

/**
 * 零钱兑换 LC322
 */
public class CoinChange {

    /**
     * 二维空间DP，时间复杂度O(n^2)
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0;
        if(coins.length == 0) return -1;

        int[][] dp = new int[coins.length][amount+1];//dp[i][j]表示coins[0~i]的硬币种类能凑成j的最少硬币数
                                                     //dp[i][j] = min(dp[i-1][j-coins[i]]+1,dp[i-1][j])
//        for (int i = 0; i < coins.length; i++) {
//            dp[i][0] = Integer.MAX_VALUE;
//        }

        for (int i = 1; i < amount+1 ; i++) {
            if(i % coins[0] == 0){
                dp[0][i] = i / coins[0];
            }else{
                dp[0][i] = Integer.MAX_VALUE;
            }
        }

        for (int i = 1; i < coins.length; i++) {
            for (int j = 1; j < amount+1; j++) {
                dp[i][j] = dp[i-1][j];//不需要coins[i]时能组成j的最小硬币数
                if(j-coins[i] >= 0 && dp[i][j-coins[i]]!=Integer.MAX_VALUE){//当需要coins[i]时能组成j的最小硬币数
                    dp[i][j] = Math.min(dp[i][j], dp[i][j-coins[i]]+1);
                }
            }
        }
        return dp[coins.length-1][amount] == Integer.MAX_VALUE? -1: dp[coins.length-1][amount];
    }

    /**
     * 一维空间DP,时间复杂度O(n^2)
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange1(int[] coins, int amount) {
        if(amount == 0) return 0;
        if(coins.length == 0) return -1;
        //由于二维空间dp中dp[i][j]最多只与dp[i-1][j]有关，所以只需要用dp[j]表示状态
        int[] dp = new int[amount+1]; //dp[i]表示coins[0~n]的硬币组合能组成i的所需要的最小硬币数
        Arrays.fill(dp,Integer.MIN_VALUE);
        dp[0] = 0;
        for (int i = 0; i < dp.length; i++) {
            for(int coin:coins){
                if(i-coin < 0) continue;
                if(dp[i-coin]!=Integer.MAX_VALUE){
                    dp[i] = Math.min(dp[i],dp[i-coin]+1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE?-1:dp[amount];

    }

    public static void main(String[] args) {
        int[] coins = {2,5,10,1};
        int amount = 27;
        System.out.println(new CoinChange().coinChange(coins, amount));

    }
}
