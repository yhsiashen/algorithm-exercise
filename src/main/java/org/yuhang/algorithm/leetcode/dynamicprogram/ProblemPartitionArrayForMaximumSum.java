package org.yuhang.algorithm.leetcode.dynamicprogram;

/**
 * 分隔数组以得到最大和 LC1043
 */
public class ProblemPartitionArrayForMaximumSum {

    public int maxSumAfterPartitioning(int[] A, int K) {
        int[] dp = new int[A.length];//dp[i]表示0~i区间分隔数组的最大值
        dp[0] = A[0];
        for (int i = 1; i < A.length; i++) {
            int k = 1;
            int max = A[i];
            //当第i个数加入时，此时可以往前分隔1~K次，取这K次分隔的最大值
            for (; i - k +1 >= 0 && k<=K ; k++) {
                max = Math.max(max,A[i-k+1]);
                dp[i] = Math.max(dp[i],max * k + (i-k>=0?dp[i-k]:0));
            }
        }
        return dp[A.length-1];
    }

    public static void main(String[] args) {
        int[] A = {1,15,7,9,2,5,10};
        System.out.println(new ProblemPartitionArrayForMaximumSum().maxSumAfterPartitioning(A,3));
    }
}
