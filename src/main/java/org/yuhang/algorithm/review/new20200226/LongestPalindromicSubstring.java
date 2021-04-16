package org.yuhang.algorithm.review.new20200226;

/**
 * 最长回文子串
 */
public class LongestPalindromicSubstring {


    public String longestPalindrome(String s) {
         if(s.length() == 0) return s;
         int len = s.length();
         boolean[][] dp = new boolean[len][len];//dp[i][j]表示s(i,j)是否为回文串
         for (int i = 0; i < len ; i++) {
           dp[i][i] = true;
         }
         int max=0, l = 0, r=0;
         for (int i = len-1; i >=0 ; i--) {
            for (int j = 0; j <len ; j++) {
                if((j-i == 1 || (j-i>1 && dp[i+1][j-1])) && s.charAt(i) == s.charAt(j)){
                    dp[i][j] = true;
                    if(j-i+1>max){
                        max = j-i+1;
                        l = i;
                        r = j;
                    }
                }
            }
         }
         return s.substring(l,r+1);
    }

    public static void main(String[] args) {
        String s = "cbbd";
        System.out.println(new LongestPalindromicSubstring().longestPalindrome(s));
    }
}
