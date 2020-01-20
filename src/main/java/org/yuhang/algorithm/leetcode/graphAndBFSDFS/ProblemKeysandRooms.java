package org.yuhang.algorithm.leetcode.graphAndBFSDFS;

import java.util.Arrays;
import java.util.List;

/**
 * 钥匙和房间 LC841
 */
public class ProblemKeysandRooms {

    private int visitedRooms = 0;

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];//表示房间有没有被访问过
        dfs(rooms,0,visited);//从房间号为0开始访问
        return visitedRooms == n;
    }

    private void dfs(List<List<Integer>> rooms, int room, boolean[] visited) {
        if(visitedRooms == visited.length) return;
        if(!visited[room]) {
            visitedRooms++;
            visited[room] = true;
            List<Integer> keys = rooms.get(room);
            if (keys.size() > 0) {
                for (int key : keys) {
                    dfs(rooms, key, visited);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] rooms = {{1,3},{3,0,1},{2},{0}};

        System.out.println(new ProblemKeysandRooms().canVisitAllRooms(Arrays.asList()));
    }
}
