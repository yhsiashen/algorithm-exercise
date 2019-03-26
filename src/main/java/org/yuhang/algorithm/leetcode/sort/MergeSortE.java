package org.yuhang.algorithm.leetcode.sort;


import java.util.Arrays;

/**
 * 归并排序练习
 */
public class MergeSortE {


    public void sort(int[] a){
        if(a==null || a.length<=1)
             return;
        mergeSort(a,0,a.length);
    }

    /**
     * 归并排序算法
     * @param a
     * @param start
     * @param end
     */
    private void mergeSort(int[] a,int start,int end){
          if(start<end){
              //找出中间元素
              int mid = (start+end)/2;
              //左边数组归并排序
              mergeSort(a,start,mid);
              //右边数组归并排序
              mergeSort(a,mid+1,end);
              //合并左右两边数组
              mergeArray(a,start,mid,end);

          }

    }

    private void mergeArray(int[] a,int start ,int mid ,int end){
        int[] left = new int[mid-start+1];
        System.arraycopy(a,start,left,0,mid-start+1);
        int[] rigth = new int[end-mid];
        System.arraycopy(a,mid+1,rigth,0,end-mid);

        int[] mergeArray = new int[end-start+1];
        int i=0 ,j=0,k=0;

        // 当左右数组都还未遍历完时，一直遍历，比较元素大小
        while (i<left.length && j<rigth.length) {
            if (left[i] <= rigth[j]) {
                mergeArray[k++] = left[i++];
            }else {
                mergeArray[k++] = rigth[j++];
            }
        }
        //若左边数组还未遍历完，则直接赋给合并后的数组
        while (i<left.length){
            mergeArray[k++] = left[i++];
        }

        //若右边数组还未遍历完，则直接赋给合并后的数组
        while (j<rigth.length){
            mergeArray[k++] = rigth[j++];
        }
        //将合并完成的数组赋给a
        System.arraycopy(mergeArray, 0, a, start, end-start+1);
    }


    public static void main(String[] args) {
        int[] a= {2,1,0,3,-1,4,6,0};
        new MergeSortE().mergeSort(a,0,a.length-1);
        System.out.println(Arrays.toString(a));
    }
}
