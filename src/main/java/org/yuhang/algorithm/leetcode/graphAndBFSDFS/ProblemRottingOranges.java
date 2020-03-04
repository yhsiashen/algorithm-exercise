package org.yuhang.algorithm.leetcode.graphAndBFSDFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 腐烂的🍊 LC994
 */
public class ProblemRottingOranges {

    public int orangesRotting(int[][] grid) {
        if(grid.length == 0 || grid[0].length == 0) return 0;
        int row = grid.length,col = grid[0].length;
        int res = -1;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(grid[i][j] == 2){ //找到所有腐烂的橘子
                   queue.offer(new int[]{i,j});
                }
            }
        }

        while (!queue.isEmpty()){
            int size = queue.size();
            while (size>0) {
                int[] index = queue.poll();
                if (index[0] + 1 < row && grid[index[0] + 1][index[1]] == 1) {//向下找新鲜橘子
                    grid[index[0] + 1][index[1]] = 2;
                    queue.offer(new int[]{index[0] + 1, index[1]});
                }
                if (index[1] + 1 < col && grid[index[0]][index[1] + 1] == 1) {//向右找新鲜橘子
                    grid[index[0]][index[1] + 1] = 2;
                    queue.offer(new int[]{index[0], index[1] + 1});
                }
                if (index[0] - 1 >= 0 && grid[index[0] - 1][index[1]] == 1) {//向左找新鲜橘子
                    grid[index[0] - 1][index[1]] = 2;
                    queue.offer(new int[]{index[0] - 1, index[1]});
                }
                if (index[1] - 1 >= 0 && grid[index[0]][index[1] - 1] == 1) {//向上找新鲜橘子
                    grid[index[0]][index[1] - 1] = 2;
                    queue.offer(new int[]{index[0], index[1] - 1});
                }
                size--;
            }

            res++;
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(grid[i][j] == 1) return -1;
            }
        }


        return res==-1?0:res;
    }

    public static void main(String[] args) {
        //int[][] grid = {{0,2}}; 注意coner case
        int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
        System.out.println(new ProblemRottingOranges().orangesRotting(grid));
    }
}
