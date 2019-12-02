package org.yuhang.algorithm.leetcode.sort;


import java.util.Arrays;

/**
 * 将数组排序成摆动序列 LC324
 */
public class ProblemWiggleSortII {

    public void wiggleSort(int[] nums) {
        if(nums.length == 0) return;
        Arrays.sort(nums);
        int mid;
        if(nums.length % 2 == 0){
            mid = nums.length /2;
        }else{
            mid = nums.length /2 +1;
        }
        int[] lower = new int[mid];
        int[] upper = new int[nums.length-mid];
        System.arraycopy(nums,0,lower,0,mid);
        System.arraycopy(nums,mid,upper,0, nums.length-mid);
        int lstart = mid-1;
        int ustart = nums.length-mid-1;
        for (int i = 0; i < nums.length ; i+=2) {
            nums[i] = lower[lstart--];
        }
        for (int i = 1; i < nums.length ; i+=2) {
            nums[i] = upper[ustart--];
        }
    }

    public static void main(String[] args) {
          int[] nums = {4,5,5,6};
          new ProblemWiggleSortII().wiggleSort(nums);
    }
}
