package org.yuhang.algorithm.interview;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 把数组排成最小的数
 */
public class ProblemMinNumber {

    public String minNumber(int[] nums) {
        Queue<String> queue = new PriorityQueue<>((o1, o2) -> (o1+o2).compareTo(o2+o1));
        for (int num:nums){
            queue.offer(String.valueOf(num));
        }

        StringBuilder res = new StringBuilder();
        while (!queue.isEmpty()){
            res.append(queue.poll());
        }
        return res.toString();
    }
}
