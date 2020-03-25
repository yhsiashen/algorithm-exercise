package org.yuhang.algorithm.interview;

/**
 * 剪绳子I
 */
public class ProblemCuttingRope {

    public int cuttingRope(int n){
       if(n == 2) return 1;
       int[] dp = new int[n+1];// dp[i]表示数字i能拆分的最大乘积
       dp[2] = 1;
       for (int i = 3; i < n+1; i++) {
           for (int j = i-1; j > 0 ; j--) {
               dp[i] = Math.max(dp[i], Math.max(dp[j]*(i-j),j*(i-j)));
           }
       }
       return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new ProblemCuttingRope().cuttingRope(8));
    }
}
