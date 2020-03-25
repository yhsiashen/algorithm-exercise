package org.yuhang.algorithm.interview;

/**
 * 礼物的最大价值
 */
public class ProblemMaxGiftValue {

    /**
     * 动态规划,时间复杂度O(n^2),空间复杂度O(n^2)
     * @param grid
     * @return
     */
    public int maxValue(int[][] grid) {
        if(grid.length == 0 || grid[0].length == 0) return 0;
        int row = grid.length;
        int col = grid[0].length;
        int[][] dp = new int[row][col];
        dp[0][0] = grid[0][0];
        for (int i = 1; i <dp.length ; i++) {
            dp[i][0] = dp[i-1][0]+grid[i][0];
        }

        for (int i = 1; i <dp[0].length; i++) {
            dp[0][i] = dp[0][i-1]+grid[0][i];
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp.length; j++) {
               dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1])+grid[i][j];
            }
        }

        return dp[row-1][col-1];
    }

    /**
     * 动态规划-滚动数组,时间复杂度O(n^2),空间复杂度O(n)
     * @param grid
     * @return
     */
    public int maxValue1(int[][] grid) {
        int row = grid.length;int col = grid[0].length;
        int[] dp = new int[col+1];//滚动数组，保存以每一行元素结尾的矩形的最大价值
        for (int i = 1; i <=row ; i++) {
            for (int j = 1; j <=col ; j++) {
                dp[j] = Math.max(dp[j],dp[j-1])+grid[i-1][j-1];
            }
        }
        return dp[col];
    }
}
