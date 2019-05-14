package org.yuhang.algorithm.leetcode.dynamicprogram;


/**
 * 求字符串的最长回文子串 5
 */
public class ProblemLongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        if(s.length()==0)return "";
        int n = s.length();
        boolean[][] dp = new boolean[n][n]; // dp[i][j] = dp[i+1][j-1] && s.charAt(i) == s.charAt(j); i,j为字符串中的索引
        int maxLength = 0;//记录最长子串长度
        int left = 0; //记录最长子串的开始位置
        int right = 0; //记录最长子串的结束位置
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        for (int i = 0; i < n; i++) {//i表示结束位置,动态规划填充dp数组
            for (int j = 0; j < i; j++) {//j表示开始位置
               dp[j][i] = (dp[j+1][i-1] || i-j<2 )&& s.charAt(i) == s.charAt(j); //(j+1,i-1)是回文串或者是字符串长度为2 且s(i)==s(j)
               if(dp[j][i] && i-j+1 > maxLength){
                   left = j;
                   right = i;
                   maxLength = i-j+1;
               }
            }
        }
        return s.substring(left,right+1);
    }



    public static void main(String[] args) {
        System.out.println(new ProblemLongestPalindromicSubstring().longestPalindrome("aaaaa"));
//        System.out.println("babad".substring(0,5));
    }
}
