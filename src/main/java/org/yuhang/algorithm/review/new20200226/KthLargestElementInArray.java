package org.yuhang.algorithm.review.new20200226;

import java.util.Random;

/**
 * 找到数组中第K大的元素
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 *
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度
 */
public class KthLargestElementInArray {
    Random random = new Random();

    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        int l =0 ,r = len-1;
        while (l <= r){
            int partitionIdx = partition(nums,l,r);
            if(k-1 == partitionIdx){
                return nums[partitionIdx];
            }else if(k-1 < partitionIdx){
                r = partitionIdx-1;
            }else{
                l = partitionIdx+1;
            }
        }
        return 0;
    }

    private int partition(int[] nums,int l ,int r){
        if(r!=0){
            int randomIdx = random.nextInt(r)%(r-l+1)+l;
            swap(nums, l, randomIdx);
        }
        int pos = l;
        for (int i = l+1; i <=r ; i++) {
            if(nums[i] > nums[l]){
                swap(nums,i,++pos);
            }
        }
        swap(nums,l,pos);
        return pos;
    }

    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {1};
        System.out.println(new KthLargestElementInArray().findKthLargest(nums, 1));
    }
}
