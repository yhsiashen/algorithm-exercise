package org.yuhang.algorithm.leetcode.dynamicprogram;

/**
 * 检索矩阵 LC304
 * @tag:动态规划
 */
public class NumMatrix {

        int[][] dp;

        public NumMatrix(int[][] matrix) {
            if (matrix.length == 0 || matrix[0].length == 0) return;
                int row = matrix.length;
                int col = matrix[0].length;
                dp = new int[row+1][col+1];
                for (int i = 0; i < row; i++) {
                    for (int j = 0; j < col ; j++) {
                        dp[i+1][j+1] = dp[i][j+1] + dp[i+1][j] - dp[i][j] + matrix[i][j];
                    }
                }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            if(dp!=null){ //dp被正确初始化
                return dp[row2+1][col2+1] - dp[row1][col2+1] -dp[row2+1][col1] + dp[row1][col1];
            }
            return -1;
        }


}
