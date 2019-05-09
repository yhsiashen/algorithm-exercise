package org.yuhang.algorithm.leetcode.topologicalsort;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;


/**
 * 返回课程安排的顺序 210
 */
public class ProblemCourseScheduleII {

    /**
     * BFS
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public int[] findOrderByBFS(int numCourses, int[][] prerequisites) {
        if(numCourses <= 0 ) return new int[0];
        int[] courseOrder = new int[numCourses]; //表示课程顺序的一种
        int count = 0;
        int[] inDegree = new int[numCourses]; //表课程的入度
        ArrayList<Integer>[] graph = new ArrayList[numCourses]; //课程的图

        for (int i = 0; i < numCourses; i++) { //初始化链表数组
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < prerequisites.length; i++) {
            inDegree[prerequisites[i][0]]++;
            graph[prerequisites[i][1]].add(prerequisites[i][0]); //建图
        }

        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i <numCourses ; i++) {
            if(inDegree[i] == 0) deque.offer(i); //将节点入度为0的点放入队列
        }
        while (!deque.isEmpty()){
            int cur = deque.poll();
            courseOrder[count++] = cur;
            for (int i = 0; i < graph[cur].size(); i++) { //遍历节点的出度节点
                int node = graph[cur].get(i);
                inDegree[node]--;
                if(inDegree[graph[cur].get(i)] == 0) deque.offer(node);
            }
        }
        if(count == numCourses)
            return courseOrder;
        else
            return new int[0];
    }

    /**
     * DFS
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public int[] findOrderByDFS(int numCourses, int[][] prerequisites) {
        if(numCourses <= 0 ) return new int[0];
        Deque<Integer> deque = new LinkedList<>();
        int[] inDegree = new int[numCourses]; //表课程的入度
        ArrayList<Integer>[] graph = new ArrayList[numCourses]; //课程的图
        boolean[] visited = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) { //初始化链表数组
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < prerequisites.length; i++) {
            inDegree[prerequisites[i][0]]++;
            graph[prerequisites[i][1]].add(prerequisites[i][0]); //建图
        }

        for (int i = 0; i < numCourses; i++) { //从节点0开始，找图中是否存在循环
            if(!dfs(graph,visited,i,deque)){
                return new int[0];
            }
        }

        for (int i = 0; i < numCourses; i++) {
            if(inDegree[i] == 0) { //从入度为0的点开始找拓补顺序
               dfs(graph,visited,i,deque);
               break;
            }
        }

        int[] array = new int[numCourses];
        for (int i = 0; !deque.isEmpty(); i++) {
            array[i] = deque.poll();
        }
        return array;
    }

    private boolean dfs(ArrayList[] graph,boolean[] visited,int course,Deque<Integer> deque){
        if(visited[course])
            return false; //若节点已被访问过，表示存在一个循环，则直接返回false
        else {
            visited[course] = true; //在一次节点的深度遍历中标记节点已被访问
            deque.offer(course);
        }

        for (int i = 0; i < graph[course].size(); i++) {
            if(!dfs(graph,visited, (Integer) graph[course].get(i),deque)){
                return false;
            }
        }
        visited[course] = false; //一次节点深度遍历完后将节点标记为未被访问
        return true;
    }


    public static void main(String[] args) {
        int[][] graph = {{1,0}};
        new ProblemCourseScheduleII().findOrderByBFS(2,graph);
    }
}
