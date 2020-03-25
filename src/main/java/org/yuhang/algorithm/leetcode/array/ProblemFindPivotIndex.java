package org.yuhang.algorithm.leetcode.array;

/**
 * 找中间索引 LC724
 */
public class ProblemFindPivotIndex {

    public int pivotIndex(int[] nums) {
        if(nums.length == 0) return -1;
        int[] preSum = new int[nums.length+1];
        for (int i = 0; i < preSum.length-1 ; i++) {
            preSum[i+1] = preSum[i]+nums[i];
        }
        for (int i = 1; i < preSum.length; i++) {
            if(preSum[i-1]==preSum[preSum.length-1]) return i;
        }
        return -1;
    }
}
