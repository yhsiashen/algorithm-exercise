package org.yuhang.algorithm.leetcode.dynamicprogram;

/**
 * 回文子串 LC647
 * @tag:动态规划
 */
public class ProblemPalindromicsubstrings {

    public int countSubstrings(String s) {
        if(s.length() == 0) return 0;
        int n = s.length();
        int res = 0;
        boolean[][] dp = new boolean[n][n]; //dp[i][j]表示s.substring(i,j+1)是否为回文子串,i为起始位置,j为终点位置
        for (int i = 0; i <n ; i++) {
            dp[i][i] = true;
        }
        for (int i = n-1; i >= 0; i--) {//i表示开始位置,由于i与i+1有关,故从dp矩阵的右下角开始推
            for (int j = i; j < n; j++) {//j表示结束位置
                if(j > 0 && i<n-1) {
                    dp[i][j] = (dp[i + 1][j - 1] || j - i < 2) && s.charAt(i) == s.charAt(j);
                }
                if(dp[i][j]) res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new ProblemPalindromicsubstrings().countSubstrings("aaaaa"));
    }
}
