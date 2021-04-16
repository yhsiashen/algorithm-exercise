package org.yuhang.algorithm.review.new20200226;

/**
 * 归并排序
 */
public class MergeSort {

    public void sort(int[] nums){
        if(nums.length == 0) return;
        mergeSort(nums,0,nums.length-1);

    }
    private void mergeSort(int[] nums, int start, int end){
        if(start < end){
            int mid = (start+end)/2;
            mergeSort(nums, start, mid);//左半边有序
            mergeSort(nums, mid+1,end);//右半边有序
            merge(nums,start,mid,mid+1,end);//合并两个有序数组
        }
    }
    private void merge(int[] nums, int l1, int r1, int l2, int r2){
         int len = r2-l1+1;
         int[] tmp = new int[len];
         int len1 = r1-l1+1;
         int len2 = r2-l2+1;
         int k=0,k1=l1,k2=l2;
         while (k1<l1+len1 && k2<l2+len2){
             if(nums[k1] < nums[k2]){
                 tmp[k++] = nums[k1++];
             }else{
                 tmp[k++] = nums[k2++];
             }
         }

         while (k1<l1+len1){
             tmp[k++] = nums[k1++];
         }
         while (k2<l2+len2){
             tmp[k++] = nums[k2++];
         }
         System.arraycopy(tmp,0,nums,l1,r2-l1+1);
    }

    public static void main(String[] args) {
        int[] nums = {3,5,2,4,1};
        new MergeSort().sort(nums);
        for(int n:nums){
            System.out.println(n);
        }
    }
}
