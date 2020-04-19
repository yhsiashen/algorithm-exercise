package org.yuhang.algorithm.review;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 01矩阵 LC542
 */
public class OneTwoMatrixProblem {

    private int [][]dirs={{-1,0},{1,0},{0,-1},{0,1}};
    private int m;
    private int n;

    /**
     * DFS
     * @param matrix
     * @return
     */
    public int[][] updateMatrix(int[][] matrix) {
        m=matrix.length;
        if(m==0) return matrix;
        n=matrix[0].length;
        if(n==0) return matrix;
        /* 将周围没有0，且值为1的位置 设置为一个极大值*/
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==1&&!hasNeighbors0(matrix,i,j)){
                    matrix[i][j]=Integer.MAX_VALUE;
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==1){
                    dfs(matrix,i,j);
                }
            }
        }
        return matrix;
    }
    /* 判断周围四个方向是否有0 */
    boolean hasNeighbors0(int [][]matrix,int x,int y){
        for(int []dir:dirs){
            int new_x=x+dir[0];
            int new_y=y+dir[1];
            if(new_x>=0&&new_x<m&&new_y>=0&&new_y<n&&matrix[new_x][new_y]==0)
                return true;
        }
        return false;
    }

    void dfs(int [][]matrix,int x,int y){
        for(int []dir:dirs){
            int new_x=x+dir[0];
            int new_y=y+dir[1];
            if(new_x>=0&&new_x<m&&new_y>=0&&new_y<n&&matrix[new_x][new_y]>matrix[x][y]+1){
                matrix[new_x][new_y]=matrix[x][y]+1;
                dfs(matrix,new_x,new_y);
            }

        }
    }

    /**
     * BFS
     * @param matrix
     * @return
     */
    public int[][] updateMatrix1(int[][] matrix) {
        m=matrix.length;
        if(m==0) return matrix;
        n=matrix[0].length;
        if(n==0) return matrix;
        for(int i=0;i<m;i++) {
            for (int j = 0; j < n; j++) {
                if(matrix[i][j] == 1){
                    matrix[i][j] = bfs(matrix,i,j);
                }
            }
        }
        return matrix;
    }

    private int bfs(int[][] matrix, int i, int j) {
        int ans = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i,j});
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size > 0){
                size--;
                int[] top = queue.poll();
                if(top[0] < 0 || top[0] >= m || top[1] < 0 || top[1] >=n) continue;
                if(matrix[top[0]][top[1]] == 0) return ans;
                for(int[] dir:dirs){
                    queue.offer(new int[]{top[0]+dir[0],top[1]+dir[1]});
                }
            }
            ans++;
        }

        return ans;

    }


    public static void main(String[] args) {
        int[][] matrix = {{0,0,0},{0,1,0},{1,1,1}};
        System.out.println(new OneTwoMatrixProblem().updateMatrix1(matrix));
    }
}
