package org.yuhang.algorithm.leetcode.graphAndBFSDFS;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 01矩阵 LC542
 */
public class Problem01Matrix {

    public int[][] updateMatrix(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0) return new int[][]{};
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(matrix[i][j] == 1){
                    res[i][j] = bfs(matrix,i,j);
                }
            }
        }

        return res;
    }


    private int bfs(int[][] matrix, int i, int j) {
        int dist = 0;
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        Deque<int[]> deque = new LinkedList<>();
        deque.offer(new int[]{i,j});
        while (!deque.isEmpty()){
            int size = deque.size();
            while (size > 0){
               size--;
               int[] top = deque.poll();
               if(matrix[top[0]][top[1]] == 0) {
                    return dist;
               }
                for (int k = 0; k < 4; k++) {
                    int x = top[0]+dx[k];
                    int y = top[1]+dy[k];
                    if(x<0 || y<0 || x>= matrix.length || y >= matrix[0].length) continue;
                    deque.offer(new int[]{x,y});
                }
            }
            dist++;
        }
        return dist;
    }
}
