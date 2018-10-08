package org.yuhang.algorithm.sort;

/** 插入排序算法
 * Created by yuhang on 2018/3/15.
 */
public class InsertSort {

    public static void insertSort(int[] a){
        int i,j,temp;
        for(j=1;j<a.length;j++){
            for(i=j;i>0;i--){
                if(a[i-1]>a[i]){
                    temp = a[i-1];
                    a[i-1] = a[i];
                    a[i] = temp;
                }
            }
        }

    }
    public static void main(String[] args) {
        int[] a= {3,1,0,8,9,10,11};
        InsertSort.insertSort(a);
        for (int i:a) {
            System.out.println(i);
        }
    }
}
