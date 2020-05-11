package org.yuhang.algorithm.review;

/**
 * 搜索二维矩阵II LC240
 */
public class Search2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if(m == 0) return false;
        int n = matrix[0].length;
        if(n == 0) return false;
        int i = m-1;
        int j = 0;
        while (i >= 0 && j< n){
            if(matrix[i][j] == target){
                return true;
            }else if(matrix[i][j] < target){
                j++;
            }else{
                i--;
            }
        }

        return false;
    }
}
