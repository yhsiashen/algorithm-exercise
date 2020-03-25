package org.yuhang.algorithm.interview;

/**
 * 求丑数
 */
public class ProblemUglyNumber {

    /**
     * 动态规划+三指针
     * @param n
     * @return
     */
    public int nthUglyNumber(int n) {
        if(n<=0) return 0;
        int[] dp = new int[n];
        dp[0] = 1;
        int u2=0,u3=0,u5=0;
        for (int i = 1; i < n; i++) {
           dp[i] = Math.max(dp[u2]*2,Math.max(dp[u3]*3,dp[u5]*5));
           if(dp[i] == dp[u2]*2) u2++;
           if(dp[i] == dp[u3]*3) u3++;
           if(dp[i] == dp[u5]*5) u5++;
        }
        return dp[n-1];
    }
}
