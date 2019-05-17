package org.yuhang.algorithm.leetcode.dynamicprogram;

/**
 * 编辑距离 72
 */
public class ProblemEditDistance {

    public int minDistance(String word1, String word2) {
        int l1 = word1.length();
        int l2 = word2.length();
        int[][] dp = new int[l1+1][l2+1]; // dp[i][j]表示将word1(0...i)转化为word2(0...j)所需的最少次数
        for (int i = 0; i < l1+1; i++) {
            dp[i][0] = i; //word1需删除i个元素变成word2
        }
        for (int i = 0; i < l2+1; i++) {
            dp[0][i] = i; //word2需删除i个元素变成word1
        }

        for (int i = 1; i < l1+1; i++) {
            for (int j = 1; j <l2+1 ; j++) {
                int x;
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                     x = dp[i-1][j-1]; //若i-1和j-1处的字符相等，则此步不需要做操作
                }else{
                     x = dp[i-1][j-1]+1;
                }
                int y = dp[i-1][j] + 1; //删除word1[i]
                int z = dp[i][j-1] + 1; //增加word2[j]
                dp[i][j] = Math.min(Math.min(x,y),z);
            }
        }

        return dp[l1][l2];
    }

    public static void main(String[] args) {
        String word = "";String word2 = "a";
        System.out.println(new ProblemEditDistance().minDistance(word,word2));
    }

}
