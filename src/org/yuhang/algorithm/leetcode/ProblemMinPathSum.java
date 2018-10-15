package org.yuhang.algorithm.leetcode;

/** 矩阵的最小路径和
 * Created by chinalife on 2018/10/15.
 */
public class ProblemMinPathSum {
    public int minPathSum(int[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }
        //矩阵行
        int m = grid.length;
        //矩阵列
        int n = grid[0].length;
        //二维数组表示m*n矩阵的最小路径和
        int[][] minPathSum = new int[m][n];
        //初始化边界条件
        minPathSum[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            minPathSum[i][0] = minPathSum[i-1][0]+grid[i][0];
        }
        for (int i = 1; i < n; i++) {
            minPathSum[0][i] = minPathSum[0][i-1]+grid[0][i];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n ; j++) {
                minPathSum[i][j] = Math.min(minPathSum[i-1][j]+grid[i][j],minPathSum[i][j-1]+grid[i][j]);
            }
        }
       return minPathSum[m-1][n-1];
    }

    public static void main(String[] args) {
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(new ProblemMinPathSum().minPathSum(grid));
    }
}
