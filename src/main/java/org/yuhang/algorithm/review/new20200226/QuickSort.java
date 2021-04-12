package org.yuhang.algorithm.review.new20200226;

import java.util.ArrayList;
import java.util.Random;

/**
 * 快速排序
 */
public class QuickSort {

    Random random = new Random();

    /**
     * 选择一个数做标的，将比它小的数放右边，比它大的数放左边，继续递归排序这两部分
     * @param nums
     */
    public void sort(int[] nums){
        if(nums.length == 0) return;
        quickSort(nums, 0, nums.length-1);
    }

    private void quickSort(int[] nums, int l, int r){
        if(l <= r){
            int pos = random.nextInt(r)%(r-l+1)+l; // 随机选取[l-r]范围内的数字作为pos数
            swap(nums, l, pos);//和第l位交换
            pos = l;//pos指定为l位
            for (int i = l+1; i <= r ; i++) {
                if(nums[i] <= nums[l]){  //若nums[i]小于flag，则将其与pos+1位置的元素交换
                    swap(nums,i,++pos);
                }
            }
            swap(nums,l,pos);
            quickSort(nums,l,pos-1);
            quickSort(nums,pos+1,r);
        }
    }
    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {5,1,6,2,9,3,7,4,0};
        new QuickSort().sort(nums);
        for(int n:nums){
            System.out.println(n);
        }
    }

}
