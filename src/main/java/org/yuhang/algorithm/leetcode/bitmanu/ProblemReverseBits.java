package org.yuhang.algorithm.leetcode.bitmanu;


/**
 * 翻转二进制  LC190
 * @tag:位运算
 */
public class ProblemReverseBits {

    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 31; i++) {
            res = res +(1 & (n>>i))<<(31-i);
        }
        return res;
    }
}
