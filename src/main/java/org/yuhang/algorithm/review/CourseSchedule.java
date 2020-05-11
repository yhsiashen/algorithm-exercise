package org.yuhang.algorithm.review;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 课程表 LC207
 */
public class CourseSchedule {

    /**
     * 拓扑排序
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
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

        while (!queue.isEmpty()){
            int pre = queue.poll();
            numCourses --;
            for(int cur:adjacency.get(pre)){//遍历pre节点所指向的所有其他节点,当节点的入度为0时，加入队列
                if(--indegrees[cur] == 0) queue.offer(cur);
            }
        }

        return numCourses == 0;//所有节点都排序完毕即为一个拓扑排序
    }

    /**
     * DFS检测图中是否有环
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinish1(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjacency = new ArrayList<>();
        for (int i = 0; i < numCourses ; i++) {
            adjacency.add(new ArrayList<>());
        }

        int[] flags = new int[numCourses];
        for(int[] pre: prerequisites){
            adjacency.get(pre[1]).add(pre[0]);
        }
        for(int i=0;i<numCourses;i++){
            if(!dfs(adjacency,flags,i)){//检测到有环则返回错误
                return false;
            }
        }
        return true;
    }

    private boolean dfs(List<List<Integer>> adjacency, int[] flags, int i) {
        if(flags[i] == 1) return false;
        if(flags[i] == -1) return true;
        flags[i] = 1;//表示i节点已被i节点开始的深度优先遍历访问
        for(int j: adjacency.get(i)){
            if(!dfs(adjacency,flags,j))return false;
        }
        flags[i] = -1;//表示i节点已被其他节点开始的深度优先遍历访问
        return true;

    }
}
