package org.yuhang.algorithm.leetcode.sort;

/**
 * 快排练习
 */
public class QuickSortE {


    public void sort(int[] a){
        if(a==null || a.length<=1)
            return;
        quickSort(a,0,a.length);
    }

    public void quickSort(int[] a,int start,int end){
        if(start<=end) {
            //哨兵为start索引,pos从哨兵位置开始,表示最后的一个比哨兵小的元素
            int pos = start;
            for (int i = start+1; i < end; i++) {
                if(a[i] <= a[start]){
                  swap(a,pos+1,i);
                  pos++;
                }
            }

            //遍历完毕，将start元素和pos元素位置交换，
            //此时所有比start小的元素在start的左边
            //    所有比start大的元素在start的左边
            swap(a,start,pos);
            quickSort(a,start,pos-1);
            quickSort(a,pos+1,end);
        }

    }

    public void swap(int[] a,int i ,int j){
        int tmp = a[i];
        a[i] = a[j];
        a[j] =tmp;
    }

}
