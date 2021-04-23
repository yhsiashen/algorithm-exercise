package org.yuhang.algorithm.review.new20200226;

/**
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 300
 * grid[i][j] 的值为 '0' 或 '1'
 */
public class NumsOfIland {

    private int m;
    private int n;
    public int numIslands(char[][] grid) {
       m = grid.length;
       n = grid[0].length;
       int nums = 0;
       for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == '1'){
                    markIland(grid,i,j);
                    nums++;
                }
            }
       }
       return nums;
    }
    private void markIland(char[][] grid, int i, int j){
        if(i < 0 || i >= m || j< 0 || j>=n || grid[i][j] != '1'){
            return;
        }
        grid[i][j] = 'X';
        markIland(grid,i+1,j);
        markIland(grid,i-1,j);
        markIland(grid,i,j+1);
        markIland(grid,i,j-1);
    }
}
