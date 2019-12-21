package org.yuhang.algorithm.leetcode.graphAndBFSDFS;


/**
 * 求岛屿的个数  200
 */
public class ProblemNumIslands {

    public int numIslands(char[][] grid) {
        if(grid==null || grid.length==0)
            return 0;
        //表格行
        int row = grid.length;
        //表格列
        int column = grid[0].length;
        boolean[][] visited = new boolean[row][column];
        int res = 0;
        //(0,0) -> (row-1,colunm-1)遍历所有为陆地且没被访问过的顶点,标记包含顶点的连通区域
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if(grid[i][j]=='1' && !visited[i][j]) {
                    DFS(grid, visited, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    private void DFS(char[][] grid,boolean[][] visited,int i,int j){
        //顶点超出边界,直接返回
        if(i<0 || j<0 || i>=grid.length ||j>=grid[0].length) return;
        //顶点被访问过或顶点不为陆地,直接返回
        if(visited[i][j] || grid[i][j] !='1') return;
        //标记(i,j)被访问了
        visited[i][j] = true;
        //分别找与(i,j)相邻的所有点
        DFS(grid,visited,i - 1,j);
        DFS(grid,visited,i,j-1);
        DFS(grid,visited,i+1,j);
        DFS(grid,visited,i,j+1);
    }
}
