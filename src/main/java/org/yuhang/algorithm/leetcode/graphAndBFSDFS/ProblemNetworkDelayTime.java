package org.yuhang.algorithm.leetcode.graphAndBFSDFS;

import java.util.*;

/**
 * 网络延迟时间 LC743
 * @tag:最短路径算法
 */
public class ProblemNetworkDelayTime {


    public int networkDelayTime(int[][] times, int N, int K) {
        Map<Integer, List<int[]>> graph = new HashMap();
        for (int[] edge: times) {
            if (!graph.containsKey(edge[0]))
                graph.put(edge[0], new ArrayList<>());
            graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }
        PriorityQueue<int[]> heap = new PriorityQueue<>(
                (info1, info2) -> info1[0] - info2[0]);
        heap.offer(new int[]{0, K});

        Map<Integer, Integer> dist = new HashMap();

        while (!heap.isEmpty()) {
            int[] info = heap.poll();
            int d = info[0], node = info[1];
            if (dist.containsKey(node)) continue;
            dist.put(node, d);
            if (graph.containsKey(node))
                for (int[] edge: graph.get(node)) {
                    int nei = edge[0], d2 = edge[1];
                    if (!dist.containsKey(nei))
                        heap.offer(new int[]{d+d2, nei});
                }
        }

        if (dist.size() != N) return -1;
        int ans = 0;
        for (int cand: dist.values())
            ans = Math.max(ans, cand);//遍历距离的结果集，找到一个最大的距离，即为遍历全节点需要的最短时间
        return ans;
    }


    public static void main(String[] args) {
        int[][] times = {{1,2,1},{2,3,7},{1,3,4},{2,1,2}};
        System.out.println(new ProblemNetworkDelayTime().networkDelayTime(times,3,1));
    }
}
