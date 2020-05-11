package org.yuhang.algorithm.review;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * 前K个高频元素 LC347
 */
public class TopKFrequentElements {

    /**
     * 时间复杂度O(nlongk)
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent(int[] nums, int k) {
      int[] topK = new int[k];
      HashMap<Integer,Integer> freqs = new HashMap<>();
      for(int num:nums){
          freqs.put(num, freqs.getOrDefault(num,0)+1);
      }

      PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(freqs::get));

      for(int key:freqs.keySet()){
          queue.offer(key);
          if(queue.size() > k){
              queue.poll();
          }
      }

      int cnt = 0;
      for(int element:queue){
          topK[cnt++] = element;
      }

      return topK;

    }
}
