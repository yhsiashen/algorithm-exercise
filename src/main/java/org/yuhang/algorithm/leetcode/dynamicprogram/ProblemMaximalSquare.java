package org.yuhang.algorithm.leetcode.dynamicprogram;

/**
 * 求矩阵中最大正方形的面积 221
 */
public class ProblemMaximalSquare {


    /**
     * 动态规划
     * @param matrix
     * @return
     */
    public int maximalSquare(char[][] matrix) {
        if(matrix.length == 0) return 0;
        int res = 0;
        int row = matrix.length;
        int column = matrix[0].length;
        int[][] maxSide = new int[row][column]; //maxSide[i][j]代表到达(i,j)点所能组成的最大正方形的边长,若该点为'0',则必不能组成正方形
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column ; j++) {
                if(i == 0 || j == 0) {
                    maxSide[i][j] = matrix[i][j] == '0'?0:1;
                }else if(matrix[i][j] == '1'){
                    maxSide[i][j] = Math.min(maxSide[i-1][j-1],Math.min(maxSide[i-1][j],maxSide[i][j-1]))+1;
                }

                res = Math.max(res,maxSide[i][j]); //在动态规划的过程中记录正方形的最大边长

            }
        }
        return res*res;
    }

    public static void main(String[] args) {
        char[][] ch = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        System.out.println(new ProblemMaximalSquare().maximalSquare(ch));
    }
}
