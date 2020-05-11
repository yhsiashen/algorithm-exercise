package org.yuhang.algorithm.review;

import org.yuhang.algorithm.leetcode.unionfind.UnionFind;

/**
 * 岛屿数量 LC200
 */
public class ProblemNumberOfIslands {

    private int m;

    private int n;

    private int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};

    /**
     * dfs
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        if(grid.length == 0|| grid[0].length == 0) return 0;
        m = grid.length;
        n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == '1' && !visited[i][j]){
                    dfs(grid,i,j,visited);
                    res++;
                }
            }
        }

        return res;


    }

    private void dfs(char[][] grid, int i, int j, boolean[][] visited) {
        if(i < 0 || i>= m || j < 0 || j>= n || visited[i][j] || grid[i][j] == '0') return;
        visited[i][j] = true;
        for(int[] dir:dirs){//遍历4个方向
           int x = i+ dir[0];
           int y = j+ dir[1];
           dfs(grid, x, y, visited);
        }
    }

    /**
     * 并查集
     * @param grid
     * @return
     */
    public int numIslands1(char[][] grid) {
        if(grid.length == 0|| grid[0].length == 0) return 0;
        m = grid.length;
        n = grid[0].length;
        UnionFind uf = new UnionFind(m*n+1);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1')
                    markUnion(grid,uf, i, j);
                else
                    uf.union(i*n+j,m*n);
            }
        }
        return uf.count()-1;
    }

    private void markUnion(char[][] grid,UnionFind uf, int i, int j) {
        for(int[] dir:dirs){
            int x = dir[0]+i;
            int y = dir[1]+j;
            if(x>=0 && x < m && y>=0 && y<n && grid[x][y]=='1'){
                uf.union(i*n+j,x*n+y);
            }
        }

    }


}
