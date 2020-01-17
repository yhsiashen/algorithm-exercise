package org.yuhang.algorithm.leetcode.dynamicprogram;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 地图分析 LC1162
 */
public class ProblemAsfarFromLandAsPossible {


    /**
     * BFS，涉及到图中最值问题，首先考虑BFS
     * @param grid
     * @return
     */
    public int maxDistance(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        if (queue.isEmpty() || queue.size() == m * n) return -1;
        int[][] next = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
        int level = -1;
        while (!queue.isEmpty()) {
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                int[] cur = queue.poll();
                for (int[] nt: next) {
                    int nx = cur[0] - nt[0], ny = cur[1] - nt[1];
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] == 0) {
                        grid[nx][ny] = 1;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
            level++;
        }
        return level;
    }

    public static void main(String[] args) {
        int[][] grid = {{1,1,0},{0,0,0},{0,0,1}};
        System.out.println(new ProblemAsfarFromLandAsPossible().maxDistance(grid));
    }
}
