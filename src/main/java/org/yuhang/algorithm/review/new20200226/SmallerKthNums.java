package org.yuhang.algorithm.review.new20200226;

import java.util.PriorityQueue;

/**
 * 输入： arr = [1,3,5,7,2,4,6,8], k = 4
 * 输出： [1,2,3,4]
 *
 * 0 <= len(arr) <= 100000
 * 0 <= k <= min(100000, len(arr))
 */
public class SmallerKthNums {

    public int[] smallestK(int[] arr, int k) {
        if(arr.length == 0 || k == 0) return new int[]{};
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1,o2)->o2-o1);//大小为k的大顶堆
        for(int n:arr){
            queue.offer(n);
            if(queue.size() > k){
                queue.poll();//当队列大小大于k时，弹出堆顶元素
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll();
        }
        return res;
    }
}
