package org.yuhang.algorithm.interview;

/**
 * 0~n-1中缺失的数字
 */
public class ProblemMissingNumber {

    public int missingNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != i){
                return i;
            }
        }

        return -1;
    }

}
