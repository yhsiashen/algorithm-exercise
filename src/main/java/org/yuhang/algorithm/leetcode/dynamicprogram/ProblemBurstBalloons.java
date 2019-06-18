package org.yuhang.algorithm.leetcode.dynamicprogram;


/**
 * 戳气球 312
 */
public class ProblemBurstBalloons {

    public int maxCoins(int[] nums) {
          if(nums.length == 0) return 0;
          int n = nums.length;
          // dp[i][j] 代表区间为(i,j)的气球被戳破所得的最大硬币数量,则dp[0][n-1]为nums[]的气球被戳破的最大硬币数量
          int[][] dp = new int[n][n];
          for (int len = 0; len < n; len++) { //区间从小到大
            for (int i = 0; i < n-len; i++) { //区间左边
                int j = i+len; //区间右边
                for (int k = i; k <=j ; k++) {
                    if(k == 0){
                        dp[i][j] = Math.max(dp[i][j], nums[k]*nums[j+ 1] +dp[k+1][j]);
                    }else if(k == n-1){
                        dp[i][j] = Math.max(dp[i][j],nums[i-1]*nums[k]+dp[i][k-1]);
                    }else{
                        dp[i][j] = Math.max(dp[i][j],nums[i-1]*nums[k]*nums[j+1]+dp[i][k-1]+dp[k+1][j]);
                    }
                }
                
            }
        }
         return dp[0][n-1];
    }

    public static void main(String[] args) {
        int[] nums = {3,1,5,8};
        System.out.println(new ProblemBurstBalloons().maxCoins(nums));
    }
}
