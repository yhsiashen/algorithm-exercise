package org.yuhang.algorithm.leetcode.array;

/**
 * 搜索二维矩阵 LC74
 * @tag:二分查找
 */
public class ProblemSearch2dMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length==0) return false;
        int rows = matrix.length;
        int columns = matrix[0].length;
        int srow = 0,erow = rows-1;
        while (srow <= erow){ //确定target所在的行
            int rmid = (srow+erow)/2;
            if(matrix[rmid][0] == target){
                return true;
            }else if(target < matrix[rmid][0]){
                erow = rmid - 1;
            }else if(target > matrix[rmid][0]){
                if(target == matrix[rmid][columns-1]){
                    return true;
                }else if(target < matrix[rmid][columns-1]){
                    srow = rmid; //此时srow即为target可能在的行
                    break;
                }else{
                    srow = rmid + 1;
                }
            }
        }

        if(srow >= rows || srow < 0) return false;
        int scol = 0,ecol = columns -1;
        while (scol <= ecol){ //在srow行中找target
           int cmid = (scol+ecol)/2;
           if(matrix[srow][cmid] == target){
               return true;
           }else if(matrix[srow][cmid] < target){
               scol = cmid +1;
           }else{
               ecol = cmid -1;
           }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
        {1, 3, 5, 7},
        {10, 11, 16, 20},
        {23, 30, 34, 50}};

        System.out.println(new ProblemSearch2dMatrix().searchMatrix(matrix,60));
    }
}
