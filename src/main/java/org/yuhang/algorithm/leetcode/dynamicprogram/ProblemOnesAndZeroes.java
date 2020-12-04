package org.yuhang.algorithm.leetcode.dynamicprogram;

/**
 * 一和零，LC474
 */
public class ProblemOnesAndZeroes {


    private int[] countZeroAndOne(String str) {
        int[] cnt = new int[2];
        for (char c : str.toCharArray()) {
            cnt[c - '0']++;
        }
        return cnt;
    }

    /**
     * 动态规划(0 1背包问题)
     * @param strs
     * @param m
     * @param n
     * @return
     */
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        //dp[i][j][k]表示strs[0...i]中0不超过j个，1不超过k个的最大子集大小
        int[][][] dp = new int[len+1][m+1][n+1];
        for (int i = 1; i <=len ; i++) {
            int[] cnt = countZeroAndOne(strs[i-1]);
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n ; k++) {
                    dp[i][j][k] = dp[i-1][j][k];
                    int zeros = cnt[0];
                    int ones = cnt[1];
                    if(j>=zeros && k >= ones){
                        //不选择第i个元素时,dp[i]为dp[i-1][j][k];
                        //选择第i个元素时,dp[i]为dp[i-1][j-zeros][k-ones]+1
                        dp[i][j][k] = Math.max(dp[i-1][j][k], dp[i-1][j-zeros][k-ones]+1);
                    }
                }
            }
        }
        return dp[len][m][n];
    }


    /**
     * 动态规划(0 1背包问题+状态压缩)
     * @param strs
     * @param m
     * @param n
     * @return
     */
    public int findMaxForm1(String[] strs, int m, int n){
        int len = strs.length;
        //dp[i][j]表示str中0不超过i个，1不超过j个的最大子集大小
        int[][] dp = new int[m+1][n+1];
        for(String str:strs){
            int[] cnt =  countZeroAndOne(str);
            for (int i = m; i >= 0; i++) {
                for (int j = n; j >= 0; j++) {
                    if(i>=cnt[0] && j>=cnt[1]){
                        dp[i][j] = Math.max(dp[i][j], dp[i-cnt[0]][j-cnt[1]]+1);
                    }
                }
            }
        }

        return dp[m][n];
    }
}
