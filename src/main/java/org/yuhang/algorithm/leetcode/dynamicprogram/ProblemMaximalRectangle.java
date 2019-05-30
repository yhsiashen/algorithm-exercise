package org.yuhang.algorithm.leetcode.dynamicprogram;

/**
 * 求矩阵中的最大矩形面积 85 TODO
 */
public class ProblemMaximalRectangle {

    public int maximalRectangle(char[][] matrix) {
      if(matrix.length == 0) return 0;
      int res=0;
      int row = matrix.length;
      int column = matrix[0].length;
      int[][] dp = new int[row][column];//dp[i][j]代表到达(i,j)点的矩阵中的最大矩形面积
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if(matrix[i][j] == '0') dp[i][j] = 0;
                else{

                }
            }
        }


      return res;
    }
}
