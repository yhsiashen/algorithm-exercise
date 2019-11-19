package org.yuhang.algorithm.leetcode.array;


import java.util.PriorityQueue;

/**
 * 找到数组中第K大的元素 LC215
 * @tag:堆
 *
 */
public class ProblemFindTopK {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();//创建一个小顶堆优先队列
        for (int i:nums){
            priorityQueue.add(i);
            if(priorityQueue.size() > k){
                priorityQueue.poll();//当优先队列中的元素数目大于k，则删除堆顶元素(最小值)
            }
        }
        return priorityQueue.poll(); //返回堆顶元素即为第k大的元素
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        System.out.println(new ProblemFindTopK().findKthLargest(nums,2));

    }


}
