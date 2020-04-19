package org.yuhang.algorithm.review;

/**
 * 两数相除
 */
public class Divide2Integers {

    public int divide(int dividend, int divisor) {
        if(dividend == 0) return 0;
        if(dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        boolean positive = (dividend ^ divisor) >=  0;
        int res = 0;
        long dividendL = Math.abs((long) dividend);
        long divisorL = Math.abs((long) divisor);
        for (int i = 31; i >= 0; i--) {
            if((dividendL >> i)>=divisorL){//被除数右移i位，相当于除以2^i，判断是否大于等于除数
                dividendL -= divisorL << i;//将被除数减去2^i * 除数
                res += 1<<i;//结果加上2^i
            }
        }
        return positive?res:-res;
    }




    public static void main(String[] args) {
        System.out.println();
    }


}
