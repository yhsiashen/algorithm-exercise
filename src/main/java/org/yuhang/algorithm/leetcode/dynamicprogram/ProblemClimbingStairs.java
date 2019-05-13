package org.yuhang.algorithm.leetcode.dynamicprogram;

/**
 * 爬楼梯 70
 */
public class ProblemClimbingStairs {

    public int climbStairs(int n) {
        if(n == 1) return 1;
        int[] res = new int[n+1]; //表示n个阶梯的楼梯有多少种方法可以爬上去
        res[1] = 1;
        res[2] = 2;
        for (int i = 3; i < n+1; i++) {
            res[i] = res[i-1]+res[i-2]; // n个阶梯可以n-1与n-2的时候分别爬1个和2个阶梯上去
        }

        return res[n];
    }

    public static void main(String[] args) {
        System.out.println(new ProblemClimbingStairs().climbStairs(4));
    }


}
