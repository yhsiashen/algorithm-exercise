package org.yuhang.algorithm.review;

/**
 * 回文子串的个数 LC647
 */
public class PalindromicSubstrings {

    public int countSubstrings(String s) {
        int len = s.length();
        if(len == 0) return 0;
        boolean[][] dp = new boolean[len][len];//dp[i][j]为s.sub(i,j+1)是否为回文子串，故i<j
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;//单个字母的字符串为回文子串
        }
        int res=0;
        for (int i = len-1; i >= 0; i--) {
            for (int j = i+1; j < len; j++) {
              dp[i][j] =(j - i <= 1 || dp[i + 1][j - 1]) && (s.charAt(i) == s.charAt(j));
              if(dp[i][j]) res++;
            }
        }
        return res;
    }
}
