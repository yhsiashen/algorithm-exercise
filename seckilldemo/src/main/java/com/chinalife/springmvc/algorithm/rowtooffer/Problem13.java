package com.chinalife.springmvc.algorithm.rowtooffer;

/**
 * 数组奇偶问题 -最小时间 O(n)
 * Created by chinalife on 2018/5/9.
 */
public class Problem13 {
    public void reOrderArray(int[] array) {
        int[] a = new int[array.length];
        int[] b = new int[array.length];
        int j = 0;
        int k = 0;
        int l = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0) {
                a[j] = array[i];
                j++;
            } else {
                b[k] = array[i];
                k++;
            }
        }
        for (int i = j; i < array.length; i++) {
            a[i] = b[l];
            l++;
        }
        for (int i = 0; i < array.length; i++) {
            array[i] = a[i];
        }
        for (int m: array) {
            System.out.println(m);
        }
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7};
        new Problem13().reOrderArray(a);
    }
}
