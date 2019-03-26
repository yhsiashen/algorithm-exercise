package org.yuhang.algorithm.leetcode.sort;

/** 快速排序算法
 * Created by yuhang on 2018/3/14.
 */
public class QuickSort {



    public static void quicSort(int[] a,int p,int q){
        if(p <=q ) {
            int tmp;
            int i = p;
            for (int j = p + 1; j <= q; j++) {
                if (a[j] <= a[p]) {
                    tmp = a[i+1];
                    a[i+1] = a[j];
                    a[j] = tmp;
                    i++;
                }
            }
            tmp = a[p];
            a[p] = a[i];
            a[i] = tmp;
            quicSort(a, p, i - 1);
            quicSort(a, i + 1, q);
        }
    }

    public static void main(String[] args) {
          int[] a = {1,23,5,0,231,90,2,8,10,12};
          quicSort(a,0,a.length-1);
        for (int i :a) {
            System.out.println(i);}

    }
}
