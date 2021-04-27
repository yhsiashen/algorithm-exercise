package org.yuhang.algorithm.review.new20200226;

/**
 * 求x的平方根
 * x为非负整数
 *
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *      由于返回类型是整数，小数部分将被舍去。
 */
public class SqrtX {

    public int mySqrt(int x) {
       if(x == 0) return 0;
       int l = 0, r = x;
       while (l < r){
           int mid = l+1+ (r-l)/2;
           if(mid  == x/mid){
               return mid;
           }else if(mid  < x/mid){//mid^2<x表示mid也可能为所求的值
               l = mid;
           }else { //mid^2>x表示mid一定不为所求的值
               r = mid-1;
           }
       }
       return l;
    }

    public static void main(String[] args) {
        System.out.println(new SqrtX().mySqrt(2147395599));
    }
}
