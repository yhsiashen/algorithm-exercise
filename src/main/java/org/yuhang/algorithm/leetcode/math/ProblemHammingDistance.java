package org.yuhang.algorithm.leetcode.math;


/**
 * 计算两数的汉明距离
 */
public class ProblemHammingDistance {

    public int hammingDistance(int x, int y) {
        int res=0;
        for (int i = 0; i < 32; i++) {
            int xt = x & (1 <<i);
            int yt = y & (1 <<i);
            if(xt!=yt) res++;
        }

        return res;
    }
}
