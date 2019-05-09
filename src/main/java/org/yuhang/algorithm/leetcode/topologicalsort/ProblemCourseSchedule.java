package org.yuhang.algorithm.leetcode.topologicalsort;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个课程表及先决条件，判断是否可以完成所有课程的学习
 */
public class ProblemCourseSchedule {


    /**
     * BFS
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinishByBFS(int numCourses, int[][] prerequisites) {
        ArrayList[] graph = new ArrayList[numCourses]; //图的表示
        int[] degree = new int[numCourses]; //表节点的入度
        Queue queue = new LinkedList();

        for(int i=0;i<numCourses;i++)
            graph[i] = new ArrayList();

        for(int i=0; i<prerequisites.length;i++){
            degree[prerequisites[i][0]]++;
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        for(int i=0; i<degree.length;i++){
            if(degree[i] == 0){
                queue.add(i);
            }
        }

        while(queue.size() != 0){
            int course = (int)queue.poll();
            for(int i=0; i<graph[course].size();i++){//从入度为0的节点开始，遍历所有与此节点相连的节点，将他们的入度-1
                int pointer = (int)graph[course].get(i);
                degree[pointer]--;
                if(degree[pointer] == 0){
                    queue.add(pointer);
                }
            }
        }
        for (int indegree:degree) {
            if(indegree != 0) return false;
        }
        return true;
    }

    /**
     * DFS
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinishByDFS(int numCourses, int[][] prerequisites) {
        ArrayList[] graph = new ArrayList[numCourses]; //图的表示

        for (int i = 0; i < numCourses; i++)
            graph[i] = new ArrayList();

        boolean[] visited = new boolean[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            graph[prerequisites[i][1]].add(prerequisites[i][0]); //建图，数组下标表示节点，邻接的链表表示所有出度的节点
        }
        for (int i = 0; i < numCourses; i++) { //从节点0开始，找图中是否存在循环
            if(!dfs(graph,visited,i)){
                return false;
            }
        }
        return true;
    }

    private boolean dfs(ArrayList[] graph,boolean[] visited,int course){
         if(visited[course])
             return false; //若节点已被访问过，表示存在一个循环，则直接返回false
         else
             visited[course] = true; //在一次节点的深度遍历中标记节点已被访问

        for (int i = 0; i < graph[course].size(); i++) {
            if(!dfs(graph,visited, (Integer) graph[course].get(i))){
                return false;
            }
        }
        visited[course] = false; //一次节点深度遍历完后将节点标记为未被访问
        return true;
    }

    public static void main(String[] args) {
        int[][] graph = {{1,0}}; //表示要完成课程1，需先修课程0
        new ProblemCourseSchedule().canFinishByBFS(2,graph);
    }
}
