package org.yuhang.algorithm.leetcode.array;

/**
 * 找出给定数组中没有出现的最小正整数，要求时间复杂度O(n),空间复杂度为O(1)  41 TODO
 */
public class ProblemFirstMissingPositive {

    public int firstMissingPositive(int[] nums) {
        if(nums==null || nums.length==0)
            return 1;
        int minPositive = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] -1 < minPositive && nums[i]-1 >0){
                 minPositive = nums[i]-1;
            }
        }
        return minPositive==Integer.MAX_VALUE?1:minPositive;
    }
}
