package org.yuhang.algorithm.leetcode.dynamicplan;

/**
 * 换钱的最少货币数
 * Created by chinalife on 2018/10/27.
 */
public class ProblemMinMoney {

    public int getMinMoney(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0)
            return -1;
        if (aim == 0)
            return 0;
        // 用二维数组dp[n][aim] 代表 arr[n]中组成aim的最少货币数
        int[][] dp = new int[arr.length][aim + 1];
        int left;
        for (int i = 0; i < arr.length; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < aim; i++) {
            if (i % arr[0] == 0) {
                dp[0][i] = i / arr[0];
            } else {
                dp[0][i] = Integer.MAX_VALUE;
            }
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = arr[i]; j < aim + 1; j++) {
                left = Integer.MAX_VALUE;
                if (j - arr[i] >= 0 && dp[i][j - arr[i]] != Integer.MAX_VALUE) {
                    left = dp[i][j - arr[i]] + 1;
                }
                dp[i][j] = Math.min(left,dp[i-1][j]);
            }
        }

        return dp[arr.length-1][aim]!=Integer.MAX_VALUE?dp[arr.length-1][aim]:-1;
    }
}
