package org.yuhang.algorithm.leetcode.array;


/**
 * 旋转图像 LC48
 */
public class ProblemRotateImage {

    public void rotate(int[][] matrix) {
        if(matrix.length == 0) return;
        int n = matrix.length;
        //转置矩阵
        for (int i = 0; i < n ; i++) {
            for (int j = i; j < n; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }

        //反转每一行
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n/2 ; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n-1-j];
                matrix[i][n-1-j] = tmp;
            }
        }
    }


    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6,},{7,8,9}};
        new ProblemRotateImage().rotate(matrix);
    }


}
