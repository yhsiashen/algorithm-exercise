package org.yuhang.algorithm.leetcode.dynamicplan;

/**  动态规划-最长回文子串
 * Created by chinalife on 2018/6/5.
 */
public class ProblemLongestPalindrome {

    public String longestPalindrome(String s) {
         if(s == null)
             return null;
         int n = s.length();
         boolean dp[][] = new boolean[n][n];
         int max_len = 0;
         int left = 0;
         int right = 0;
        for (int j = 0; j < s.length(); j++) {
            dp[j][j] = true;
            for (int i = 0; i < j; i++) {
                dp[i][j] = (s.substring(i,i+1).equals(s.substring(j,j+1)) && (j-i<2 || dp[i+1][j-1]));
                if(dp[i][j] && (j-i+1 > max_len)){
                    left = i;
                    right = j;
                    max_len = j-i+1;
                }
            }
        }
        return s.substring(left,right-left+1);
    }

    public static void main(String[] args) {
        String s = "abb";
        System.out.println(new ProblemLongestPalindrome().longestPalindrome(s));

    }
}
