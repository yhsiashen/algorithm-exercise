package org.yuhang.algorithm;

/**  选择排序算法
 * Created by yuhang on 2018/3/14.
 */
public class SelectSort {

    public static void swap(int i,int j){
        int temp = 0;
        temp = i;
        i = j;
        j= temp;
    }

    public static void selectSort(int[] a ){
        int min = 0;
        int index = 0;
        //定义循环--经过j次循环，每次循环选择一个最小的数并与a[j]交换
        for(int j = 0;j<a.length;j++) {
            //把a[j]赋给min
            min = a[j];
            //定义循环--找出一次j循环中最小的值的索引
            for (int i = j; i < a.length; i++) {
                if (a[i] < min) {
                    min = a[i];
                    index = i;
                }
            }
//            swap(a[j], a[index]);
            int temp = a[j];
            a[j]= a[index];
            a[index]= temp;
        }
    }

    public static void main(String[] args) {
        int[] a= {213,213,32,32,123,1,0,12,89};
        SelectSort.selectSort(a);
        for (int i:a) {
            System.out.println(i);
        }
    }
}
