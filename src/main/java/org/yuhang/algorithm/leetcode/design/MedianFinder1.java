package org.yuhang.algorithm.leetcode.design;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 数据流的中位数 LC295
 */
public class MedianFinder1 {

    int count;//数据流中的总个数
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    /** initialize your data structure here. */
    public MedianFinder1() {
       this.count = 0;
       this.maxHeap = new PriorityQueue<>(((o1, o2) -> o2-o1));
       this.minHeap = new PriorityQueue<>();
    }

    /**
     * 大顶堆代表数据流中的前半部分,小顶堆代表数据流中的后半部分,两个堆的堆顶元素代表数据流的中位数
     * @param num
     */
    public void addNum(int num) {
       count++;
       maxHeap.offer(num);
       minHeap.offer(maxHeap.poll());
       if((count & 1) == 1){
           maxHeap.offer(minHeap.poll());
       }
    }

    public double findMedian() {
       if(count == 0) return 0.0;
       if((count & 1) == 0){
           return (double)(maxHeap.peek() + minHeap.peek()) /2;
       }else{
           return (double) maxHeap.peek();
       }
    }

    public static void main(String[] args) {

        //[,6.0,8.0,6.0,6.0,6.0,5.5,6.0,5.5,5.0,4.0,3.0]
        MedianFinder1 mf = new MedianFinder1();
        mf.addNum(6);
//        mf.addNum(2);
        System.out.println(mf.findMedian());
        mf.addNum(10);
        System.out.println(mf.findMedian());
        mf.addNum(2);
        System.out.println(mf.findMedian());
        mf.addNum(6);
        System.out.println(mf.findMedian());
        mf.addNum(5);
        System.out.println(mf.findMedian());
        mf.addNum(0);
        System.out.println(mf.findMedian());
        mf.addNum(6);
        System.out.println(mf.findMedian());
        mf.addNum(3);
        System.out.println(mf.findMedian());
        mf.addNum(1);
        System.out.println(mf.findMedian());
        mf.addNum(0);
        System.out.println(mf.findMedian());
        mf.addNum(0);
        System.out.println(mf.findMedian());
    }
}
