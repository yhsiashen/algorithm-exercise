package org.yuhang.algorithm.leetcode.design;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 数据流的中位数 LC295
 */
public class MedianFinder {

    /**有序的list */
    List<Integer> list;

    /** initialize your data structure here. */
    public MedianFinder() {
       this.list = new ArrayList<>();
    }

    /**
     * add元素时，通过二分查找，在有序的list里找到位置并插入，复杂度为O(logn)
     * @param num
     */
    public void addNum(int num) {
       int size = list.size();
       if(size == 0) {
           list.add(num);
           return;
       }else if(size == 1){
           if(num > list.get(0)){
               list.add(num);
           }else{
               list.add(0,num);
           }
           return;
       }
       int l = 0, r= size-1;
       while (l < r){
           int mid = l+(r-l)/2;
           if(list.get(mid) == num){
               list.add(mid+1,num);
               return;
           }else if(list.get(mid) < num){
                l = mid+1;
           }else{
                r = mid;
           }
       }
       if(num < list.get(l))list.add(l,num);
       else list.add(l+1,num);
    }

    public double findMedian() {
        int size = list.size();
        double res = 0.0;
        if((size & 1) == 0){//偶数
            res = (list.get(size/2)+list.get(size/2-1))/2.0;
        }else{//奇数
            res = list.get(size/2);
        }

        return res;
    }

    public static void main(String[] args) {

        //[,6.0,8.0,6.0,6.0,6.0,5.5,6.0,5.5,5.0,4.0,3.0]
        MedianFinder mf = new MedianFinder();
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
