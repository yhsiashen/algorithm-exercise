package org.yuhang.algorithm.leetcode.array;


/**
 * 有1~n的n个数,现在确实了一个或多个数字,找到缺失的数,要求复杂度O(n)
 */
public class ProblemFindMissingNum {


    public int findMissingNum(int[] nums){
        if(nums == null || nums.length==0)
            return 1;
        bucketSort(nums);
        for (int i = 0; i <nums.length ; i++) {
            if(nums[i] != i+1){
                return i+1;
            }
        }
       return 1;
    }

    /**
     * 遍历一次nums,每个位置i应放置i+1,若不是则交换位置
     * @param nums
     */
    private void bucketSort(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i+1 && nums[i]!=nums[nums[i]-1]){
                //若nums[i]不是该位置的数,则换到应该在的位置
                swap(nums,i,nums[nums[i] -1]);
            }
        }
    }

    private void swap(int[] nums,int i,int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
