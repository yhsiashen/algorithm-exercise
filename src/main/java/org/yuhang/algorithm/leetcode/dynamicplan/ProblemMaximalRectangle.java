package org.yuhang.algorithm.leetcode.dynamicplan;

/** 最大矩阵的面积 //TODO
 * Created by chinalife on 2018/10/24.
 */
public class ProblemMaximalRectangle {

    public int maximalRectangle(char[][] matrix) {
        if(matrix==null || matrix.length == 0)
            return 0;
        // 矩阵行
        int m = matrix.length;
        // 矩阵列
        int n = matrix[0].length;
        // m*n矩阵的最大面积
        int[][] maximalRectangle = new int[m][n];
        for (int i = 0; i < m ; i++) {
            for (int j = 0; j < n; j++) {
                if(matrix[i][j] == 0) {
                    maximalRectangle[i][j] = Math.max(maximalRectangle[i-1][j],maximalRectangle[i][j-1]);
                }else {

                }
            }
        }



        return 0;
    }
}
