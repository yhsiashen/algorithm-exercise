package org.yuhang.algorithm.review;

import java.util.Arrays;

/**
 * 硬币问题
 */
public class CoinLcci {

    // 1,5,10,25组成n的种类
    public int waysToChange(int n) {
        if(n == 0) return 0;
        int[] coins = {1,5,10,25};
        int[] dp = new int[n+1];//dp[j]表示coins数组能组成j钱的种类
        dp[0] = 1;
        for (int coin:coins){
            for (int i = coin; i <n+1 ; i++) {
                dp[i] += dp[i-coin];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new CoinLcci().waysToChange(10));
    }
}
