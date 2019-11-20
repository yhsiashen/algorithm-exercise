package org.yuhang.algorithm.leetcode.array;


/**
 * 搜索二维矩阵中的目标值 LC240
 */
public class ProblemSearch2dMatrixII {

    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length==0) return false;
        int row = matrix.length; //矩阵行
        int col = matrix[0].length; //矩阵列
        int i=row-1,j=0;//从矩阵左下角开始
        while (i>=0 & j<col){
            if(matrix[i][j]==target) return true;
            else if(matrix[i][j] < target){
               j++;
            }else{
               i--;
            }
        }
        return false;
    }


}
