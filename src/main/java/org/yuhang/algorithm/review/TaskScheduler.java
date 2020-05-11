package org.yuhang.algorithm.review;

import java.util.Arrays;

/**
 * 任务调度器 LC621
 */
public class TaskScheduler {

    public int leastInterval(char[] tasks, int n) {
       int[] count = new int[26];
       for (int i = 0; i < tasks.length; i++) {
           count[tasks[i]-'A']++;
       }
       Arrays.sort(count);
       int maxCount = 0;
        for (int i = 25; i >=0 ; i--) {
            if(count[i]!=count[25]){
                break;
            }
            maxCount++; //统计最高频率的任务有多少个
        }

        return Math.max((count[25]-1)*(n+1)+maxCount, tasks.length);

    }
}
