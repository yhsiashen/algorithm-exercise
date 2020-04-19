package org.yuhang.algorithm.leetcode.math;

/**
 * 阶乘后的0 LC172
 */
public class ProblemFactorialTrailingZeroes {

    public int trailingZeroes(int n) {
        int ans = 0;
        while (n>=5){//计算1*2*3*....*n有多少个5的因子,5出现的规律是每隔5个出现一次，每隔25个多一次，每隔125个多两次。。。
            ans+=n/5;
            n/=5;
        }

        return ans;
    }


}
