package org.yuhang.algorithm.review;

/**
 * 数组中的逆序对
 */
public class ReverseNumsOrder {

    private int res;

    public int reversePairs(int[] nums) {
        if(nums.length == 0) return res;
        mergeArray(nums,0,nums.length-1);
        return res;
    }

    private void mergeArray(int[] nums, int start, int end) {

        if (start < end){
            int mid = (start+end)/2;
            mergeArray(nums,start,mid);
            mergeArray(nums,mid+1,end);
            countInMerge(nums,start,mid,mid+1,end);
        }

    }

    private void countInMerge(int[] nums, int s1, int e1, int s2, int e2) {
        int[] merge = new int[e2-s1+1];
        int l1 = s1,l2 = s2;
        int k = 0;
        while (l1<=e1 && l2 <= e2){
            if(nums[l2] < nums[l1]){
                merge[k++] = nums[l2++];
                res+=e1-l1+1;//统计逆序对
            }else if(nums[l2] >= nums[l1]){
                merge[k++] = nums[l1++];
            }
        }

        while (l1<=e1){
            merge[k++] = nums[l1++];
        }

        while (l2<=e2){
            merge[k++] = nums[l2++];
        }

        System.arraycopy(merge,0,nums,s1,merge.length);

    }

    public static void main(String[] args) {
        int[] nums = {7,5,6,4};
        new ReverseNumsOrder().reversePairs(nums);
    }
}
