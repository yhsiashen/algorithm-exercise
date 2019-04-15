package org.yuhang.algorithm.leetcode.array;

/**
 * O(1)的空间复杂度  删除排序数组中的重复元素，使得每个元素最多出现2次  80
 */
public class ProblemRemoveDuplicatesII {

    public int removeDuplicates(int[] nums) {
       if(nums == null || nums.length == 0)
           return 0;
       //记录某一元素出现了几次，最多出现两次
       int appear = 0;
       int undup = Integer.MAX_VALUE;
       int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if(nums[j] != undup){
                appear = 0;
                nums[i++] = nums[j];
                undup = nums[j];
                appear++;
            }else if(nums[j] == undup && appear < 2){
                nums[i++] = nums[j];
                appear++;
            }else if(nums[j] == undup && appear >= 2){
                appear++;
            }
        }

        return i;

    }

    public static void main(String[] args) {
        int[] nums = {0};
        System.out.println(new ProblemRemoveDuplicatesII().removeDuplicates(nums));
    }
}
