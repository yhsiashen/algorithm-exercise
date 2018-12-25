package org.yuhang.algorithm.leetcode.dfs;

import java.util.Scanner;

/**
 * Created by chinalife on 2018/11/19.
 */
public class ProblemDFS {

    public static int[][] graph;
    public static int height = 0;
    public static int width = 0;
    public static int res = 0;

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while(true){
            String str = cin.nextLine();
            //矩阵行
            int N = Integer.parseInt(str.split(" ")[0]);
            //矩阵列
            int M = Integer.parseInt(str.split(" ")[1]);
            graph = new int[N][M];
            width = M;
            height = N;
            res = 0;
            dfs(0, 0, 1);
            System.out.println(res % 10000);
        }
    }

    private static void dfs(int i, int j, int curStep) {
        if (i < 0 || i >= height || j < 0 || j >= width) {
            return;
        }
        if (graph[i][j] == 1) {
            return;
        }
        graph[i][j] = 1;//标记已走过
        if (curStep == height * width) {
            if (i == height - 1 && j == 0) {
                res = (res + 1) % 10000;
            }
        }
        dfs(i - 1, j, curStep + 1);
        dfs(i + 1, j, curStep + 1);
        dfs(i, j - 1, curStep + 1);
        dfs(i, j + 1, curStep + 1);
        graph[i][j] = 0;
    }
}
