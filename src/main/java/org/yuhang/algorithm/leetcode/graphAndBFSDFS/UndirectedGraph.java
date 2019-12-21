package org.yuhang.algorithm.leetcode.graphAndBFSDFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 图(无向图)的表示,广度优先搜索和深度优先搜索
 */
public class UndirectedGraph {

    /**
     * 图的顶点的个数
     */
    private int vertex;

    /**
     * 链表数组存储顶点和边
     */
    private LinkedList<Integer>[] adj;

    public UndirectedGraph(int vertex) {
        this.vertex = vertex;
        adj = new LinkedList[vertex];
        for (int i = 0; i < vertex; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    /**
     * 将顶点s,t的关系加入到链表中，无向图需加两次
     *
     * @param s
     * @param t
     */
    public void addEdge(int s, int t) {
        adj[s].add(t);
        adj[t].add(s);
    }


    /**
     * BFS，在图中找到一条从s到t的最短路径，从s开始依次遍历s的邻接点，遍历完后在遍历邻接点的邻接点
     *
     * @param s
     * @param t
     */
    public void BFS(int s, int t) {
        if (s == t)
            return;
        //用布尔数组表示顶点是否被访问过
        boolean[] visited = new boolean[vertex];
        visited[s] = true;
        //用队列表示
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        //prev数组记录路径
        int[] prev = new int[vertex];
        for (int i = 0; i < vertex; i++) {
            prev[i] = -1;
        }
        while (!queue.isEmpty()) {
            //取出队列的tail元素
            int w = queue.poll();
            //遍历与w顶点的邻接点
            for (int i = 0; i < adj[w].size(); i++) {
                int q = adj[w].get(i);
                if (!visited[q]) {
                    //记录路径
                    prev[q] = w;
                    //找到终点
                    if (q == t) {
                        print(prev, s, t);
                        return;
                    }
                    //记录q节点已被访问
                    visited[q] = true;
                    //将q节点加入队列
                    queue.add(q);
                }
            }
        }
    }
    /**全局变量表示t点是否被找到 */
    private boolean found = false;
    /**
     * DFS实现
     * @param s
     * @param t
     */
    public void DFS(int s,int t){
        boolean[] visited = new boolean[vertex];
        int[] prev = new int[vertex];
        for (int i = 0; i < vertex; i++) {
            prev[i] = -1;
        }

        recureDFS(s,t,visited,prev);
        print(prev,s,t);

    }

    public void recureDFS(int s,int t,boolean[] visited,int[] prev){
        if(found) return;
        visited[s] = true;
        //找到顶点，将found置为true，表明t已找到
        if(s==t){
            found = true;
            return;
        }
        //递归遍历s的邻接点
        for (int i = 0; i < adj[s].size(); i++) {
            int w = adj[s].get(i);
            if(!visited[w]){
                prev[w] = s;
                //以w为顶点递归遍历
                recureDFS(w,t,visited,prev);
            }
        }
    }

    //打印出prev数组记录的路径
    private void print(int[] prev, int s, int t) {
        if(prev[t] != -1 && t!=s){
            print(prev,s,prev[t]);
        }
        System.out.println(t+"->");
    }
}
