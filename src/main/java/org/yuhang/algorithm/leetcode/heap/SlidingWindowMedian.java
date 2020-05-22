package org.yuhang.algorithm.leetcode.heap;

import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * 滑动窗口的中位数 LC480
 */
public class SlidingWindowMedian {

    public double[] medianSlidingWindow(int[] nums, int k) {
        int len = nums.length - k + 1;
        if(len <= 0) return new double[]{};
        double[] medians = new double[len];
        int cnt = 0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2-o1);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        HashMap<Integer,Integer> deleteNums = new HashMap<>();
        for (int i = 0; i < k; i++) {
            maxHeap.offer(nums[i]);
        }
        for (int i = 0; i < k/2; i++) {
            minHeap.offer(maxHeap.poll());
        }
        int i = 0;
        while (i < len){
            medians[cnt++] = (k&1)==1?maxHeap.peek():((double)minHeap.peek()+(double)maxHeap.peek())/2.0;
            if(cnt == len) break;
            int out_num = nums[i];//窗口下一个要移除的元素
            int in_num = nums[i+k];//窗口下一个要加入的元素
            int balance = 0;
            i++;
            balance += out_num <= maxHeap.peek()? -1:1; //如果要移除的元素在大顶堆中，说明较小的部分不平衡
            deleteNums.put(out_num, deleteNums.getOrDefault(out_num,0)+1);

            if(!maxHeap.isEmpty() && in_num <= maxHeap.peek()){
                balance++;
                maxHeap.offer(in_num);
            }else{
                balance--;
                minHeap.offer(in_num);
            }

            if(balance < 0){//说明较小部分(大顶堆中)有效的元素少了，不平衡，需要从小顶堆中匀一些过来
                maxHeap.offer(minHeap.poll());
                balance++;
            }

            if(balance > 0){
                minHeap.offer(maxHeap.poll());
                balance--;
            }


            while (deleteNums.containsKey(maxHeap.peek())){
                int counts = deleteNums.get(maxHeap.peek());
                if(counts == 1){
                    deleteNums.remove(maxHeap.peek());
                }else {
                    deleteNums.put(maxHeap.peek(), counts - 1);
                }
                maxHeap.poll();
            }
            while (!minHeap.isEmpty() && deleteNums.containsKey(minHeap.peek())){
                int counts = deleteNums.get(minHeap.peek());
                if(counts == 1){
                    deleteNums.remove(minHeap.peek());
                }else{
                    deleteNums.put(minHeap.peek(), counts-1);
                }
                minHeap.poll();
            }
        }
        return medians;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        // [-2147483648.0,-2147483648.0,-2147483648.0,-2147483648.0,-2147483648.0,-2147483648.0,2147483647.0,2147483647.0,-2147483648.0,-2147483648.0,-2147483648.0]
        // [-2147483648.0,-2147483648.0,-2147483648.0,-2147483648.0,-2147483648.0,2147483647.0,2147483647.0,2147483647.0,2147483647.0,2147483647.0,-2147483648.0]
        System.out.println(new SlidingWindowMedian().medianSlidingWindow(nums,3));
    }
}
