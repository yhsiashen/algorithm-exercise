package org.yuhang.algorithm.leetcode.array;


import java.util.ArrayList;
import java.util.List;

/**
 * 按顺时针螺旋顺序返回矩阵中的所有元素 LC54
 */
public class ProblemSpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if(matrix.length == 0) return  res;
        int row = matrix.length; //行
        int column = matrix[0].length; //列
        if(row == 1){
            for (int i = 0; i < column ; i++) {
                res.add(matrix[0][i]);
            }
            return res;
        }

        if(column == 1){
            for (int i = 0; i < row; i++) {
                res.add(matrix[i][0]);
            }
            return res;
        }
        int count = 0;
        int total = row * column;
        while (count < Math.min(row,column) - 1){
            for (int i = count; i <= column-count-1; i++) {
                if(res.size()>=total) break;
                 res.add(matrix[count][i]); //添加第count行
            }

            for (int i = count+1; i <= row-count-1; i++) {
                if(res.size()>=total) break;
                res.add(matrix[i][column-count-1]); //添加第column-count-1列
            }

            for (int i = column-count-2; i >=count; i--) {
                if(res.size()>=total) break;
                res.add(matrix[row-count-1][i]); //添加第row-count-1行
            }

            for (int i = row-count-2; i > count; i--) {
                if(res.size()>=total) break;
                res.add(matrix[i][count]); //添加第count列

            }
            count++;
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4},{5, 6, 7, 8},{9,10,11,12}};
        new ProblemSpiralMatrix().spiralOrder(matrix);
    }
}
