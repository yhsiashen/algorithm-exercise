package org.yuhang.algorithm.review;

/**
 * 最大正方形 LC221
 */
public class MaximalSquare {

    public int maximalSquare(char[][] matrix) {
       if(matrix.length == 0 || matrix[0].length == 0) return 0;
       int m = matrix.length;
       int n = matrix[0].length;
       int[][] maxSide = new int[m][n];//maxside[i][j]表示以(i,j)为右下角的矩阵的最长正方形边长
       int res = 0;
       for (int i = 0; i < m; i++) {
            maxSide[i][0] = matrix[i][0] - '0';
       }

        for (int i = 0; i < n; i++) {
            maxSide[0][i] = matrix[0][i] - '0';
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if(matrix[i][j] == '0'){
                    maxSide[i][j] = 0;
                }else {
                    maxSide[i][j] = Math.min(maxSide[i-1][j-1],Math.min(maxSide[i-1][j],maxSide[i][j-1]))+1;

                    res = Math.max(res, maxSide[i][j]);
                }

            }
        }

        return res*res;

    }
}
