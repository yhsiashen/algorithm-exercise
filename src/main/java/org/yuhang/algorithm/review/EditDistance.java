package org.yuhang.algorithm.review;

/**
 * 编辑距离 LC72
 */
public class EditDistance {

    public int minDistance(String word1, String word2) {
        int l1 = word1.length();
        int l2 = word2.length();
        int[][] dp = new int[l1+1][l2+1]; // dp[i][j]表示word1.sub(0,i)转换到word.sub(0,j)所需的最少操作数
                                          // dp[i][j] = min(dp[i-1][j],dp[i][j-1],dp[i-1][j-1])
        for (int i = 0; i < l1+1 ; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < l2+1; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i < l1+1; i++) {
            for (int j = 1; j < l2+1; j++) {
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else{
                    dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]))+1;
                }

            }
        }

        return dp[l1][l2];
    }
}
