package org.yuhang.algorithm.leetcode.dynamicprogram;

/**
 * 动态规划-有障碍物的路径问题
 * Created by chinalife on 2018/6/24.
 */
public class ProblemUniquePathsWithObstacles {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0) {
            return 0;
        }
        int m = obstacleGrid.length; // m行
        int n = obstacleGrid[0].length; // n列
        int routins[][] = new int[m][n]; //m行n列的数据代表总共的路径

        // 边界情况- 1行的情况下，若中间有一个障碍物，则障碍物之后的路径不可达
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] ==1){
                // 障碍物之前的路径有1条
                for (int j = 0; j < i ; j++) {
                    routins[0][j] = 1;
                }
                //障碍物之后的路径没有
                for (int j = i; j < n ; j++) {
                    routins[0][j] = 0;
                }
                break;
            }else{
                for (int j = 0; j <n; j++) {
                    routins[0][j] = 1;
                }
            }

        }

        //边界情况- 1列的情况下，若中间有一个障碍物，则障碍物之后的路径不可达
        for (int i = 0; i < m; i++) {
            if(obstacleGrid[i][0] == 1){
                for (int j = 0; j < i; j++) {
                    routins[j][0] = 1;
                }
                for(int j = i;j<m;j++){
                    routins[j][0] = 0;
                }
                break;
            }else{
                for (int j = 0; j <n; j++) {
                    routins[j][0] = 1;
                }
            }

        }

        //若最右下角为障碍物，则没有可达路径
        if(obstacleGrid[m-1][n-1] == 1){
            routins[m-1][n-1] = 0;
        }
        //动态规划- m*n网格的路径由m-1*n + m*n-1的路径决定
        for (int i = 1; i < m ; i++) {
            for (int j = 1; j < n; j++) {
                if(obstacleGrid[i][j] == 1){
                    routins[i][j] = 0;
                }else {
                    routins[i][j] = routins[i - 1][j] + routins[i][j - 1];
                }
            }
        }
        return routins[m-1][n-1];
    }

    public static void main(String[] args) {
        //  [1]
        //  [0]
        int[][] obstacleGrid = {{0,0,0},{0,1,0},{0,0,0}};
        System.out.println(new ProblemUniquePathsWithObstacles().uniquePathsWithObstacles(obstacleGrid));
    }
}
