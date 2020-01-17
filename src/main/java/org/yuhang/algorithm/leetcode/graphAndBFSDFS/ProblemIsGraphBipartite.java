package org.yuhang.algorithm.leetcode.graphAndBFSDFS;

/**
 * 判断是否为二分图 LC785
 */
public class ProblemIsGraphBipartite {

    public boolean isBipartite(int[][] graph) {
        /**
         实际上就是一个上色问题, 依次判断每个节点(防止非连通图中有未访问的节点),
         如果未被上色则选择一种颜色对其上色并dfs的对其邻接点上相反的颜色, 如果邻
         接点已有相同的颜色说明上色失败返回false, 0: 未上色, 1: 红色, -1: 黑色
         **/
        int[] colors = new int[graph.length];
        for(int i = 0; i < graph.length; ++i)
            if(colors[i] == 0 && !coloring(graph, colors, 1, i))
                return false;
        return true;
    }

    private boolean coloring(int[][] graph, int[] colors, int color, int node) {
        // 如果已上色判断颜色是否一致, 不一致说明上色失败
        if(colors[node] != 0)
            return colors[node] == color;
        colors[node] = color;
        for(int next : graph[node])
            if(!coloring(graph, colors, -color, next))
                return false;
        return true;
    }

    public static void main(String[] args) {
        int[][] graph = {{4,1},{0,2},{1,3},{2,4},{3,0}};
        System.out.println(new ProblemIsGraphBipartite().isBipartite(graph));
    }
}
