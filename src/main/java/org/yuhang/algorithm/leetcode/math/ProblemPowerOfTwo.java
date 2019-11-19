package org.yuhang.algorithm.leetcode.math;


/**
 * 给定一个整数，判断是否为2的幂次方 LC231
 * @tag:位运算
 */
public class ProblemPowerOfTwo {

    /**
     * 普通方法
     * @param n
     * @return
     */
    public boolean isPowerOfTwo(int n) {
        if(n==0) return false;
        if(n==1) return true;
        while (n!=1){
            if(n%2!=0) return false;
            n /=2;
        }
        return true;
    }

    /**
     * 位运算,2的幂次方满足n & (n-1) 为0,hashmap中也是
     * @param n
     * @return
     */
    public boolean isPowerOfTwo1(int n){
       if(n > 0) return (n & (n - 1)) == 0;
       return false;
    }
}
