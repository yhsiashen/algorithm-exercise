package org.yuhang.algorithm.leetcode.graphAndBFSDFS;

/**
 * 矩阵中的最长递增路径 LC329
 */
public class ProblemLongestIncreasingPathInMatrix {

    private static final int[][] dirs = {{0,1},{1,0},{-1,0},{0,-1}};
    private int m,n;

    public int longestIncreasingPath(int[][] matrix) {
        if(matrix.length == 0) return 0;
        m = matrix.length;
        n = matrix[0].length;
        int ans = 0;
        int[][] cache = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans = Math.max(ans, dfs(matrix,i,j,cache));
            }
        }
        return ans;
    }

    private int dfs(int[][] matrix, int i, int j, int[][] cache) {
        if(cache[i][j] != 0) return cache[i][j];
        for(int[] dir: dirs){
            int x = i+dir[0];
            int y = j+dir[1];
            if(x >=0 && x<m && y>=0 && y<n && matrix[x][y] > matrix[i][j]){
                 cache[i][j] = Math.max(cache[i][j], dfs(matrix,x,y,cache));
            }
        }
        return ++cache[i][j];
    }



    public static void main(String[] args) {
        int[][] matrix = {{3,4,5},
                {3,2,6},
                {2,2,1}};

        System.out.println(new ProblemLongestIncreasingPathInMatrix().longestIncreasingPath(matrix));
    }
}
