package org.yuhang.algorithm.review.new20200226;

import org.yuhang.algorithm.leetcode.array.Array;

import java.util.Arrays;

/**
 * 部分排序
 * 输入： [1,2,4,7,10,11,7,12,6,7,16,18,19]
 * 输出： [3,9]
 * 0 <= len(array) <= 1000000
 */
public class SubSortLcci {

    public int[] subSort(int[] array) {
        if(array.length == 0) return new int[]{-1,-1};
        int m = 0,n = array.length-1;
        int[] tmp = array.clone();
        Arrays.sort(tmp);
        while (m < n){
            if(array[m]!=tmp[m] && array[n]!=tmp[n]){
                break;
            }
            if(array[m] == tmp[m]){
                m++;
            }
            if(array[n] == tmp[n]){
                n--;
            }
        }
        return m >= n? new int[]{-1,-1} : new int[]{m,n};
    }

    public int[] subSort2(int[] array) {
        if(array.length == 0) return new int[]{-1,-1};
        int m = -1, n = -1;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 0; i <  array.length; i++) {
            if(array[i] >= max){
                max = array[i];
            }else {//i前面有比当前值大的元素，说明i位置肯定要参与排序
                n = i;
            }
        }
        for (int i = array.length-1; i >=0 ; i--) {
            if(array[i] <= min){
                min = array[i];
            }else {
                m = i;
            }
        }
        return new int[]{m,n};
    }


    public static void main(String[] args) {
        int[] array = {1,2,3,4,10,5};
        System.out.println(new SubSortLcci().subSort(array));
    }
}
