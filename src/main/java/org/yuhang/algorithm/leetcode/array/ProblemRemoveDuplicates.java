package org.yuhang.algorithm.leetcode.array;


/**
 * O(1)空间复杂度 删除排序数组中重复的元素  26
 */
public class ProblemRemoveDuplicates {

    /**
     * 双指针法
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int i = 0;
        int undup = Integer.MAX_VALUE;
        for (int j = 0; j < nums.length; j++) {
            if(nums[j] != undup){
                nums[i++] = nums[j];
                undup = nums[j];
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int[] nums = {};
        System.out.println(new ProblemRemoveDuplicates().removeDuplicates(nums));
    }
}
