package org.yuhang.algorithm.leetcode.hash;


import java.util.*;

/**
 * 找出整数数组中前k个高频元素 LC347
 */
public class ProblemTopKFrequEle {

    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        Map<Integer,Integer> freqMap = new HashMap<>();
        for (int i: nums){
            freqMap.put(i,freqMap.getOrDefault(i,0)+1);
        }
        //构造小顶堆,大小为k
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(freqMap::get));
        for (int i:freqMap.keySet()) {
            if(priorityQueue.size() == k){ //当堆中元素大于k个时,弹出堆顶元素(频率最小)
                if(freqMap.get(i) > freqMap.get(priorityQueue.peek())){
                    priorityQueue.poll();
                    priorityQueue.add(i);
                }
            }else {
                priorityQueue.add(i);
            }
        }
//        priorityQueue.addAll(freqMap.keySet());
        while (!priorityQueue.isEmpty()){
            res.add(priorityQueue.poll());
        }
        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {3,0,1,0};
        new ProblemTopKFrequEle().topKFrequent(nums,1);
    }
}
