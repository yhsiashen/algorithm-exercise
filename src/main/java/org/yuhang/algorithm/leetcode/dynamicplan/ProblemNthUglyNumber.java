package org.yuhang.algorithm.leetcode.dynamicplan;

/**
 * 找出第N个丑数
 * Created by chinalife on 2018/10/29.
 */
public class ProblemNthUglyNumber {

    public int nthUglyNumber(int n) {
        if (n <= 0)
            return 0;
        // 定义uglyNumber数组存放前n个丑数
        int[] uglyNumber = new int[n];
        uglyNumber[0] = 1;
        int index2 = 0;
        int index3 = 0;
        int index5 = 0;
        int k = 1;
        while (k < n) {
            uglyNumber[k] = Math.min(uglyNumber[index2]*2,Math.min(uglyNumber[index3]*3,uglyNumber[index5]*5));
            if(uglyNumber[index2]*2 == uglyNumber[k]) index2++;
            if(uglyNumber[index3]*3 == uglyNumber[k]) index3++;
            if(uglyNumber[index5]*5 == uglyNumber[k]) index5++;
            k++;
        }
        return uglyNumber[n-1];
    }

    public static void main(String[] args) {
        System.out.println(new ProblemNthUglyNumber().nthUglyNumber(11));
    }
}
