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
        for(int a1:array1){
            sum1 += a1;
        }
        for(int a2:array2){
            sum2 += a2;
        }
        Arrays.sort(array1);
        Arrays.sort(array2);
        int[] res = new int[2];
        int diff = Math.abs(sum1-sum2);//sum1与sum2的差值
        if(diff % 2 !=0) return new int[]{};//如果差值为奇数，则两sum不可能相等
        diff = diff >> 1;
        if(sum1 > sum2){//把大数组的大值和小数组的小值交换
            for (int i = array1.length-1; i >= 0; i--) {
                for (int j = 0; j < array2.length; j++) {
                     if(array1[i]-array2[j] == diff){//差值等于diff，则找到了要交换的值
                         res[0] = array1[i];
                         res[1] = array2[j];
                         return res;
                     }else if(array1[i] -array2[j] < diff){//差值小于diff，直接剪枝，说明找不到要交换的值
                         return new int[]{};
                     }
                }
            }
        }else if(sum1 < sum2){
            for (int i = 0; i < array1.length; i++) {
                for (int j = array2.length-1; j >=0 ; j--) {
                    if(array2[j]-array1[i] == diff){
                        res[0] = array1[i];
                        res[1] = array2[j];
                        return res;
                    }else if(array2[j]-array1[i] < diff){
                        return new int[]{};
                    }
                }
            }
        }

        return new int[]{};
    }

    public int[] findSwapValues1(int[] array1, int[] array2) {
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
