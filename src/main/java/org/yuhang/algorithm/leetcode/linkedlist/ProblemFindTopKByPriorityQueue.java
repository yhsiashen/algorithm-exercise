package org.yuhang.algorithm.leetcode.linkedlist;


import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 找到一组数据中最大top k，大顶堆优先队列
 */
public class ProblemFindTopKByPriorityQueue {

    public int[] findTopK(int[] a,int k){
        if(a==null || a.length==0 || k<=0)
            return null;

        int[] topK = new int[k];
        //大顶堆优先队列
        Queue<Integer> queue = new PriorityQueue<>((o1, o2) -> o1 >= o2 ? -1 : 1);
        //把数组中的元素加入堆
        for (int i1 : a) {
            queue.add(i1);
        }
        //取堆顶元素，取K次
        for (int i = 0; i < k; i++) {
            if(!queue.isEmpty()) {
                topK[i] = queue.poll();
            }
        }
        return topK;
    }

    public static void main(String[] args) {
        int[] a = {1,3,2,0,4,5,-1,2};
        int[] b = new ProblemFindTopKByPriorityQueue().findTopK(a,4);
        for (int i:b) {
            System.out.println(i);
        }
    }
}
