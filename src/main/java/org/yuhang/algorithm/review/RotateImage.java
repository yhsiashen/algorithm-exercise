package org.yuhang.algorithm.review;

/**
 * 旋转图像 LC48
 */
public class RotateImage {

    public void rotate(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < i ; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n/2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] =  matrix[i][n-j-1];
                matrix[i][n-j-1] = tmp;
            }
        }




    }
}
