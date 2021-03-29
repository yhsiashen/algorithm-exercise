package org.yuhang.algorithm.review.new20200226;

import org.yuhang.algorithm.leetcode.array.Array;

import java.util.Arrays;

/**
 * 交换数字
 * 输入: array1 = [1, 1, 1, 2, 2, 4] = 11, array2 = [3, 3, 3, 6] = 15
 *       abs = 4,
 * 输出: [1, 3]
 *
 * 输入: array1 = [1, 2, 3], array2 = [4, 5, 6]
 * 输出: []
 *
 * 1 <= array1.length, array2.length <= 100000
 */
public class SumSwapLcci {

    public int[] findSwapValues(int[] array1, int[] array2) {
        int sum1 = 0, sum2 = 0;
        for (int a1 : array1) {
            sum1 += a1;
        }
        for (int a2 : array2) {
            sum2 += a2;
        }
        Arrays.sort(array1);
        Arrays.sort(array2);
        int diff = sum1 - sum2;//sum1与sum2的差值
        if (diff % 2 != 0) return new int[]{};//如果差值为奇数，则两sum不可能相等
        int i = 0, j =0;
        while (i < array1.length && j < array2.length){
            if((array1[i] - array2[j]) * 2 == diff) {
                return new int[]{array1[i],array2[j]};
            }else if((array1[i] - array2[j]) * 2 < diff){
                i++;
            }else {
                j++;
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] array1 = {4, 1, 2, 1, 1, 2};
        int[] array2 = {3, 6, 3, 3};
        System.out.println(new SumSwapLcci().findSwapValues(array1,array2));
    }
}
