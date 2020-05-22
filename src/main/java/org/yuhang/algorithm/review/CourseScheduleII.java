package org.yuhang.algorithm.review;

import java.util.*;

/**
 * 课程表II LC210
 */
public class CourseScheduleII {


    public int[] findOrder(int numCourses, int[][] prerequisites) {
       List<List<Integer>> graph = new ArrayList<>();
       for (int i = 0; i < numCourses ; i++) {
            graph.add(new ArrayList<>());
       }

       //生成图
       for(int[] prerequisite:prerequisites){

           graph.get(prerequisite[1]).add(prerequisite[0]);
       }
       int[] visited = new int[numCourses];
       Stack<Integer> stack = new Stack<>();
       for (int i = 0; i < numCourses ; i++) {
           if(!dfs(graph, visited, i,stack)){
               return new int[]{};
           }
       }
       int[] res = new int[numCourses];
       int cnt = 0;
       while (!stack.isEmpty()){
          res[cnt++] = stack.pop();
       }

       return res;

    }

    private boolean dfs(List<List<Integer>> graph, int[] visited, int i, Stack<Integer> stack) {
        if(visited[i] == 1) return false;
        if(visited[i] == -1) return true;
        visited[i] = 1;//节点被自己(i)访问过
        List<Integer> next =  graph.get(i);
        for(int course:next){
            if(!dfs(graph, visited, course,stack)){
                return false;
            }
        }
        visited[i] = -1;//节点被其他节点访问过
        stack.add(i);//在节点没有后序节点时，将其压入栈，这样从栈顶弹出元素后能得到一个拓补排序
        return true;
    }

    public int[] findOrder1(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];//节点的入度数组
        List<List<Integer>> adjacency = new ArrayList<>();//图的邻接链表表示,1->0
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            adjacency.add(new ArrayList<>());
        }
        for(int[] nums : prerequisites){
            indegrees[nums[0]]++;
            adjacency.get(nums[1]).add(nums[0]);
        }

        for (int i = 0; i < numCourses; i++) {
            if(indegrees[i] == 0) {//找到入度为0的起点，加入队列，从他们开始遍历图,此为拓扑排序
                queue.offer(i);
            }
        }
        int[] res= new int[numCourses];
        int cnt  =  0;

        while (!queue.isEmpty()){
            int pre = queue.poll();
            res[cnt++] = pre;
            numCourses --;
            for(int cur:adjacency.get(pre)){//遍历pre节点所指向的所有其他节点,当节点的入度为0时，加入队列
                if(--indegrees[cur] == 0) queue.offer(cur);
            }
        }

        return numCourses == 0? res:new int[]{};//所有节点都排序完毕即为一个拓扑排序
    }

    public static void main(String[] args) {
        int[][] p = {{0,1}};
        new CourseScheduleII().findOrder(2,p);
    }

}
