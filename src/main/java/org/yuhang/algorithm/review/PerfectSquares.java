package org.yuhang.algorithm.review;

/**
 * 完全平方数 LC279
 */
public class PerfectSquares {

    public int numSquares(int n) {
        if(n == 0) return 0;
        int[] dp = new int[n+1];
        for (int i = 1; i < n+1 ; i++) {
            int j = 2;
            dp[i] = dp[i-1]+1;
            while (i-j*j >=0){
                dp[i] = Math.min(dp[i-j*j]+1,dp[i]);
                j++;
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new PerfectSquares().numSquares(13));
        System.out.println(Math.pow(9,0.5));
    }
}
