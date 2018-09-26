package org.yuhang.algorithm;

/**
 * 归并排序算法
 * Created by yuhang on 2018/3/15.
 */
public class MergeSort {

    // 将两个有序数组合并
    public static void mergeArray(int[] a, int min, int mid, int max, int[] temp) {
        int i = min, j = mid + 1;
        int m = mid, n = max;
        int k = 0;
        while (i <= m && j <= n) {
            if (a[i] <= a[j]) {
                temp[k] = a[i];
                k++;
                i++;
            } else {
                temp[k] = a[j];
                k++;
                j++;
            }
        }
        while (i <= m) {
            temp[k] = a[i];
            k++;
            i++;
        }
        while (j <= n) {
            temp[k++] = a[j++];
        }
        for (int l = 0; l < k; l++) {
            a[min + l] = temp[l];
        }
    }

    public static void mergeSort(int[] a, int min, int max, int[] temp) {
        int mid = (min + max) / 2;
        if (min < max) {
            mergeSort(a, min, mid, temp); // 左边数组有序
            mergeSort(a, mid + 1, max, temp);  // 右边数组有序
            mergeArray(a, min, mid, max, temp);  //合并两数组
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 0, -4, 2, 4, 3, 6, 8, 9};
        int[] temp = new int[a.length];
        mergeSort(a, 0, a.length - 1, temp);
        for (int i : a) {
            System.out.println(i);
        }
    }
}
