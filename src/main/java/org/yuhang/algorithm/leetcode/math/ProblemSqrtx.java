package org.yuhang.algorithm.leetcode.math;


/**
 * 实现x的平方根函数 LC69
 */
public class ProblemSqrtx {


    public int mySqrt(int x) {
       if(x==0) return 0;
       int left  = 1,right = x;
       while (left < right){
           int mid = (left+right+1) >>> 1;
           if(mid > (x/mid)){
               right = mid-1;
           }else {
               left = mid;
           }
       }
       return left;
    }

    public static void main(String[] args) {
        System.out.println(new ProblemSqrtx().mySqrt(2147395599));
    }

}
