package org.yuhang.algorithm.leetcode.graphAndBFSDFS;

/**
 * 求岛屿的最大面积 LC695
 */
public class ProblemMaxareaOfIsland {



    public int maxAreaOfIsland(int[][] grid) {
       if(grid.length == 0 || grid[0].length == 0) return 0;
       int maxArea = 0;
       boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(!visited[i][j] && grid[i][j] == 1){
                    int area = dfs(grid,visited,i,j);
                    maxArea = Math.max(area,maxArea);

                }
            }
        }
        return maxArea;
    }

    private int dfs(int[][] grid, boolean[][] visited,int i, int j) {
        if( i <0 || i>= grid.length || j<0 || j>= grid[0].length) return 0;
        if(grid[i][j] == 0) return 0;
        if(!visited[i][j]){
            visited[i][j] = true;
            return dfs(grid,visited,i+1,j) + dfs(grid,visited,i-1,j)
                     + dfs(grid,visited,i,j+1) + dfs(grid,visited,i,j-1) + 1;
        }
        return 0;
    }
}
