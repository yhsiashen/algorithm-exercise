package org.yuhang.algorithm.review;

/**
 * 求x的平方根
 */
public class SqrtX {

    public int mySqrt(int x) {
       if(x == 0) return 0;
       int l = 1,r = x;
       while (l < r){
           int mid = l+(r-l+1)/2;
           if(mid == x/mid){
               return mid;
           }else if(mid < x/mid){
               l = mid;
           }else{
               r = mid-1;
           }
       }
       return l;
    }
}
