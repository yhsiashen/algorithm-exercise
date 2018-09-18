package com.chinalife.springmvc.test;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int map[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = scanner.nextInt();
                if (map[i][j] == -1) {
                    map[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            SFPA(map, n, start - 1, end - 1);
        }
    }

    public static void SFPA(int[][] graph, int n, int start, int end) {//假设从0开始遍历
        int[] lowcost = new int[n];
        Arrays.fill(lowcost, Integer.MAX_VALUE);
        /**
         * 将flag数组改为 队列用于记录待遍历节点
         */
        int[] queue = new int[n];
        int[] mst = new int[n];
        for (int i = 0; i < n; i++) {
            mst[i] = i;
        }
        int j, q, min, minid, sum = 0;
        queue[start] = 1;
        lowcost[start] = 0;
        while (true) {
            q = 0;
            while (q < n && queue[q] == 0) {
                q++;
            }
            if (q == n) break;
            for (j = 0; j < n; j++) {
                if (graph[q][j] < Integer.MAX_VALUE && graph[q][j] + lowcost[q] < lowcost[j]) {
                    lowcost[j] = graph[q][j] + lowcost[q];
                    queue[j] = 1;
                    mst[j] = q;
                }
            }
            queue[q] = 0;
        }
        int path = end;
        int path_num = 0;
        while (mst[path] != start) {
            path = mst[path];
            path_num++;
        }
        System.out.println(path_num + " " + lowcost[end]);
    }
}


