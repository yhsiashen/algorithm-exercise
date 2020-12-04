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

        int[][] dp = new int[coins.length+1][amount+1];//dp[i][j]表示coins[0~i]的硬币种类能凑成j的最少硬币数；dp[0][j]为边界值处理
        for (int[] n:dp) {
            Arrays.fill(n,amount+1);
        }

        //初始化边界值，coins能组成0钱的最少硬币数都为0
        for (int i = 0; i <=coins.length; i++) {
            dp[i][0]=0;
        }

        for (int i = 1; i < coins.length+1; i++) {
            for (int j = 1; j < amount+1; j++) {
                dp[i][j] = dp[i-1][j];
                //不选coins[i-1],dp=dp[i-1][j];
                //选择coins[i-1],dp=dp[i][j-coins[i-1]+1;
                // 选取两者较小值
                if(j-coins[i-1] >=0)
                   dp[i][j] = Math.min(dp[i][j], dp[i][j-coins[i-1]]+1);
            }
        }
        return dp[coins.length][amount] == amount+1? -1: dp[coins.length][amount];
    }


    /**
     * 一维空间DP,时间复杂度O(amount*n),空间复杂度O(amount)
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange1(int[] coins, int amount) {
        if(amount == 0) return 0;
        if(coins.length == 0) return -1;
        //由于二维空间dp中dp[i][j]最多只与dp[i-1][j]有关，所以只需要用dp[j]表示状态
        int[] dp = new int[amount+1]; //dp[i]表示coins[0~n]的硬币组合能组成i的所需要的最小硬币数
        Arrays.fill(dp,amount+1);
        dp[0] = 0;
        for (int i = 0; i < dp.length; i++) {
            for(int coin:coins){
                if(i-coin < 0) continue;
                dp[i] = Math.min(dp[i],dp[i-coin]+1);//对于每个dp[i],遍历coins数组选取coins[index],看选哪个coins所需的硬币数最少
            }
        }
        return dp[amount] == amount+1?-1:dp[amount];
    }



    public int coinChange2(int[] coins, int amount) {
        if(amount == 0) return 0;
        if(coins.length == 0) return -1;
        //由于二维空间dp中dp[i][j]最多只与dp[i-1][j]有关，所以只需要用dp[j]表示状态
        int[] dp = new int[amount+1]; //dp[i]表示coins[0~n]的硬币组合能组成i的所需要的最小硬币数
        Arrays.fill(dp,amount+1);
        dp[0] = 0;
        for(int coin:coins){
            for (int i = coin; i < dp.length; i++) {
               dp[i] = Math.min(dp[i],dp[i-coin]+1);
            }
        }
        return dp[amount] == amount+1?-1:dp[amount];

    }

    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int amount = 11;
        System.out.println(new CoinChange().coinChange(coins, amount));

    }
}
