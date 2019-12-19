package org.yuhang.algorithm.leetcode.greedyalgo;

/**
 * 整数拆分 LC343
 */
public class ProblemIntegerBreak {

    /**
     * 贪心算法，尽可能分解出多因数为"3"的因子
     * @param n
     * @return
     */
    public int integerBreak(int n) {
        if (n <= 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        if (n == 4) {
            return 4;
        }
        // 接下来就是 n >= 5 的时候的逻辑了
        int res = 1;
        while (n > 4) {
            res *= 3;
            n -= 3;
        }
        res *= n;
        return res;
    }


    public int integerBreak1(int n){
        int[] res = new int[n+1];
        res[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= i-1; j++) {
                res[i] = Math.max(res[i], Math.max(j*res[i-j],j*(i-j)));
            }
        }
        return res[n];
    }


    public static void main(String[] args) {
        System.out.println(new ProblemIntegerBreak().integerBreak(10));
    }
}
