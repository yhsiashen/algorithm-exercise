package org.yuhang.algorithm.leetcode.math;

/**
 * 判断一个整数是否是3的幂次方
 */
public class ProblemPowerOfThree {

    public boolean isPowerOfThree(int n) {
        if (n < 1) {
            return false;
        }

        while (n % 3 == 0) {
            n /= 3;
        }

        return n == 1;
    }

}
