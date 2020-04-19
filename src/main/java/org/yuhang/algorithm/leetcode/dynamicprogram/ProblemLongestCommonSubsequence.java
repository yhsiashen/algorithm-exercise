package org.yuhang.algorithm.leetcode.dynamicprogram;

/**
 * 最长公共子序列 LC1143
 */
public class ProblemLongestCommonSubsequence {

    public int longestCommonSubsequence(String text1, String text2) {
       if(text1.length() == 0 || text2.length() == 0) return 0;
       int l1 = text1.length();int l2 = text2.length();
       int[][] dp = new int[l1][l2];
       dp[0][0] = text1.charAt(0) == text2.charAt(0)?1:0;
       for (int i = 1; i < l1; i++) {
           if(text1.charAt(i) == text2.charAt(0)){
               dp[i][0] = 1;
           }else{
               dp[i][0] = dp[i-1][0];
           }
       }
        for (int i = 1; i < l2 ; i++) {
           if(text1.charAt(0) == text2.charAt(i)){
               dp[0][i] = 1;
           }else{
               dp[i][0] = dp[i-1][0];
           }
        }

        for (int i = 1; i < l1; i++) {
            for (int j = 1; j < l2; j++) {
                if(text1.charAt(i)==text2.charAt(j)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
//                dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
//                dp[i][j] = Math.max(dp[i][j], text1.charAt(i)==text2.charAt(j)?dp[i-1][j-1]+1:dp[i-1][j-1]);

            }
        }

        return dp[l1-1][l2-1];

    }
}
