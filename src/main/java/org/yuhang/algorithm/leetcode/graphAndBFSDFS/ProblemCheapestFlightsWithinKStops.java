package org.yuhang.algorithm.leetcode.graphAndBFSDFS;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * K站中转内最便宜的航班 LC787
 */
public class ProblemCheapestFlightsWithinKStops {

    int res = Integer.MAX_VALUE;

    /**
     * DFS
     */
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        Map<Integer,Map<Integer,Integer>> graph = new HashMap<>();
        for (int i = 0; i < flights.length ; i++) {
            Map<Integer,Integer> nearCity = graph.getOrDefault(flights[i][0],new HashMap<>());
            nearCity.put(flights[i][1],flights[i][2]);
            graph.put(flights[i][0],nearCity);
        }
//        PriorityQueue<Integer> queue = new PriorityQueue<>();
//        queue.offer(-1);
//        int res = Integer.MAX_VALUE;
        boolean[] visited = new boolean[n];
        dfs(graph,src,dst,K,0,0,visited);
        return res == Integer.MAX_VALUE?-1:res;
    }

    private void dfs(Map<Integer, Map<Integer, Integer>> graph, int src, int dst, int k, int count,int cost,boolean[] visited) {
             if (count > k + 1 || cost > res) {//经过的中转次数超过k次或花费超标
                 return;
             }
             if (src == dst) {
                 res = Math.min(cost,res);
                 return;
             }
             Map<Integer, Integer> nearCitys = graph.get(src);
             if(nearCitys !=null) {//若有航班则遍历航班
                 for (Map.Entry<Integer, Integer> entry : nearCitys.entrySet()) {
                     int nearCity = entry.getKey();
                     int preCost = cost + entry.getValue();//之前的路费加上此次的路费
                     if(!visited[nearCity]) {
                         visited[nearCity] = true;
                         dfs(graph, nearCity, dst, k, count + 1, preCost, visited);
                         visited[nearCity] = false;//回溯
                     }
                 }
             }
         }


    /**
     * Dijkstra最短路径算法(小顶堆+BFS)
     */
    public int findCheapestPrice1(int n, int[][] flights, int src, int dst, int K) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for(int[] flight : flights) {
            if(!map.containsKey(flight[0]))
                map.put(flight[0], new HashMap<>(0));
            map.get(flight[0]).put(flight[1], flight[2]);
        }

        // 数组内元素依次为: 到达站的最低费用(fee)、到达站(tar)和经过中转的站数(k)
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> (a[0]-b[0])
        );
        pq.offer(new int[]{0, src, 0});

        while(!pq.isEmpty()) {
            int[] temp = pq.poll();//每次从优先队列中取出堆顶元素(目前的最小花费)，是一种贪心策略
            int fee = temp[0];
            int tar = temp[1];
            int k = temp[2];
            if(tar == dst) return fee;
            if(k <= K) {
                // 防止下一站城市不在map中
                Map<Integer, Integer> nextHops = map.getOrDefault(tar, new HashMap<>());
                for(Map.Entry<Integer, Integer> entry : nextHops.entrySet())
                pq.offer(new int[]{fee + entry.getValue(), entry.getKey(), k+1});
            }
        }

        return -1;

    }

    public static void main(String[] args) {
        int[][] flights = {{0,1,100},{1,2,100},{0,2,500}};
        System.out.println(new ProblemCheapestFlightsWithinKStops().findCheapestPrice(3,flights,0,2,1));
    }


}
