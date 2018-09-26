package org.yuhang.algorithm.leetcode;

/**
 * 动态规划-有障碍物的路径问题
 * Created by chinalife on 2018/6/24.
 */
public class ProblemUniquePathsWithObstacles {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;  // n=2
        int m = obstacleGrid[0].length; // m=1
        int routin[][] = new int[n][m];
        int flag = 1000;
        for (int i = n-1; i >= 0; i--) {
            if (obstacleGrid[i][0] == 1) {
                flag = i;
            }
        }
        for (int i = n-1; i >= 0; i--) {
            if (i < flag)
                routin[i][0] = 1;
            else
                routin[i][0] = 0;
        }
        for (int i = m-1; i >= 0; i--) {
            if(obstacleGrid[0][i] == 1){
                flag = i;
            }
        }
        for (int i = m-1; i >= 0; i--) {
            if(i<flag)
                routin[0][i] = 1;
            else
                routin[0][i] = 0;
        }
        for(int i =1;i<n;i++){
            for(int j =1;j<m;j++){
                 if(obstacleGrid[i][j] == 1 )
                     routin[i][j] = 0;
                 else{
                     if(obstacleGrid[i-1][j] ==1 && obstacleGrid[i][j-1] == 1)
                         routin[i][j] = 0;
                     else if(obstacleGrid[i-1][j] == 1)
                         routin[i][j] = routin[i][j-1];
                     else if(obstacleGrid[i][j-1] == 1)
                         routin[i][j] = routin[i-1][j];
                     else
                         routin[i][j] = routin[i][j-1]+routin[i-1][j];
                 }
            }
        }
        return routin[n-1][m-1];
    }

    public static void main(String[] args) {
        //  [1]
        //  [0]
        int[][] obstacleGrid = {{0,0,0},{0,1,0},{0,0,0}};
        System.out.println(new ProblemUniquePathsWithObstacles().uniquePathsWithObstacles(obstacleGrid));
    }
}
