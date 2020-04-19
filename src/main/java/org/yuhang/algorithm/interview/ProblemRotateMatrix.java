package org.yuhang.algorithm.interview;

/**
 * 旋转矩阵
 */
public class ProblemRotateMatrix {

    public void rotate(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0) return;
        int n = matrix.length;
        //先沿对角线交换元素
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n/2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n-j-1];
                matrix[i][n-j-1] = tmp;
            }
        }
    }
}
