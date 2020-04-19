package org.yuhang.algorithm.leetcode.dynamicprogram;

import java.util.ArrayList;
import java.util.List;

/**
 * 编辑距离 LC72
 */
public class ProblemEditDist {

    /**
     * 动态规划
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        int l1 = word1.length();
        int l2 = word2.length();
        int[][] dp = new int[l1+1][l2+1];//dp[i][j]表示word1.subStr(0,i)变换到word2.subStr(0,j)需要的步数，则dp[l1][l2]表示word1转换到word2的步数
        for (int i = 0; i < l1+1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < l2+1; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i < l1+1; i++) {
            for (int j = 1; j < l2+1; j++) {
                int steps1 = dp[i-1][j-1] + (word1.charAt(i-1) == word2.charAt(j-1)?0:1);
                int steps2 = dp[i-1][j]+1;
                int steps3 = dp[i][j-1]+1;
                dp[i][j] = Math.min(Math.min(steps1,steps2),steps3);
            }
        }
        return dp[l1][l2];

    }

    public static void main(String[] args) {
        System.out.println(new ProblemEditDist().minDistance("horse","ros"));
    }
}
