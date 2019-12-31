package org.yuhang.algorithm.leetcode.heap;

import java.util.PriorityQueue;

public class KthLargest {

    final PriorityQueue<Integer> q ;
    final int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        q = new PriorityQueue<>(k);
        for(int i: nums) {
             add(i);
        }
    }

    public int add(int val) {
        if(q.size() < k) {
            q.offer(val);

        }
        else if(q.peek() < val) {
            q.poll();
            q.offer(val);
        }
        return q.peek();
    }

    public static void main(String[] args) {
        int[] nums = {1,2,4,5,8};
        KthLargest kthLargest = new KthLargest(3,nums);
        System.out.println(kthLargest.add(3));
        System.out.println(kthLargest.add(5));
        System.out.println(kthLargest.add(10));
        System.out.println(kthLargest.add(9));
        System.out.println(kthLargest.add(4));

    }
}
