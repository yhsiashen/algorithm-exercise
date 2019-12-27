package org.yuhang.algorithm.leetcode.greedyalgo;

import java.util.*;

/**
 * 任务调度器 LC621
 */
public class ProblemTaskScheduler {


    /**
     * 用数组做map
     * @param tasks
     * @param n
     * @return
     */
    public int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        for (char ch: tasks){
            map[ch-'A']++;
        }
        Arrays.sort(map);
        int times = 0;
        while (map[25] > 0){
            int i = 0;
            while (i <= n){//n+1为一轮，一轮中不允许出现相同字符
                if(map[25] == 0) break;
                if(i<26 && map[25-i] > 0)map[25-i]--;
                times++;
                i++;
            }
            Arrays.sort(map);
        }
        return times;
    }

    /**
     * 用大顶堆
     * @param tasks
     * @param n
     * @return
     */
    public int leastInterval1(char[] tasks, int n) {
        int[] map = new int[26];
        for (char c: tasks)
            map[c - 'A']++;
        PriorityQueue < Integer > queue = new PriorityQueue < > (26, Collections.reverseOrder());
        for (int f: map) {
            if (f > 0)
                queue.add(f);
        }
        int time = 0;
        while (!queue.isEmpty()) {
            int i = 0;
            List < Integer > temp = new ArrayList < > ();
            while (i <= n) {
                if (!queue.isEmpty()) {
                    if (queue.peek() > 1)
                        temp.add(queue.poll() - 1);
                    else
                        queue.poll();
                }
                time++;
                if (queue.isEmpty() && temp.size() == 0)
                    break;
                i++;
            }
            for (int l: temp)
                queue.add(l);
        }
        return time;
    }

    public static void main(String[] args) {
        char[] tasks = new char[]{'A','A','A','B','B','B','C'};
        System.out.println(new ProblemTaskScheduler().leastInterval1(tasks,2));


    }
}
