package org.yuhang.algorithm.leetcode.graphAndBFSDFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 最短的桥 LC934
 */
public class ProblemShortestBridge {


    Queue<Pair> queue = new LinkedList<>();

    public int shortestBridge(int[][] A) {
//       boolean[][] visited = new boolean[A.length][A[0].length];
       boolean flag = false;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                    if (A[i][j] == 1 && !flag) {
                        dfsIsland(A, i, j);
                        flag=true;
                        break;
                    }
            }
        }

        int level = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size > 0){
                size--;
                Pair first = queue.poll();
                if(A[first.i][first.j] == 1){//找到岛
                    return level-1;
                }
                if(first.i+1 >= 0 && first.i+1 < A.length && A[first.i+1][first.j]!=2)queue.offer(new Pair(first.i+1,first.j));
                if(first.i-1 >= 0 && first.i-1 < A.length && A[first.i-1][first.j]!=2)queue.offer(new Pair(first.i-1,first.j));
                if(first.j+1 >= 0 && first.j+1 < A[0].length && A[first.i][first.j+1]!=2)queue.offer(new Pair(first.i,first.j+1));
                if(first.j-1 >= 0 && first.j-1 < A[0].length&& A[first.i][first.j-1]!=2)queue.offer(new Pair(first.i,first.j-1));
            }
            level++;
        }
       return level;
    }



    public class Pair{
        int i;
        int j;

        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }


    private void dfsIsland(int[][] A, int i, int j) {
        if(i<0 || i >= A.length || j<0 || j>= A[0].length) return;
        if(A[i][j]== 0 || A[i][j]==2) return;
        if(A[i][j]==1){
            A[i][j] = 2;
            queue.offer(new Pair(i,j));
            dfsIsland(A,i+1,j);
            dfsIsland(A,i-1,j);
            dfsIsland(A,i,j+1);
            dfsIsland(A,i,j-1);
        }
    }

    public static void main(String[] args) {
        int[][] A = {{0,1,0,0,0},{0,1,0,1,1},{0,0,0,0,1},{0,0,0,0,0},{0,0,0,0,0}};
//        int[][] A = {{0,1},{1,0}};
        System.out.println(new ProblemShortestBridge().shortestBridge(A));
    }
}
