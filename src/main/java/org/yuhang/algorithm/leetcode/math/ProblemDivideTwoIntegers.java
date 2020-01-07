package org.yuhang.algorithm.leetcode.math;

/**
 * 两数相除 LC29
 */
public class ProblemDivideTwoIntegers {

    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        long dividendLong = (long) Math.abs(dividend);
        long divisorLong = (long) Math.abs(divisor);
        int negative = (dividend ^ divisor) > 0 ? 1: -1;//判断符号位是否为1
        int res = 0;
        for (int i = 31; i >= 0 ; i--) {
            if((dividendLong >> i) > divisorLong){
                res += 1 << i; //结果加上2^n
                dividendLong -= divisorLong << i; // 被除数-除数*2^n
            }
        }
        return res*negative;
    }

    public static void main(String[] args) {
        System.out.println(new ProblemDivideTwoIntegers().divide(7,-3));
    }
}
