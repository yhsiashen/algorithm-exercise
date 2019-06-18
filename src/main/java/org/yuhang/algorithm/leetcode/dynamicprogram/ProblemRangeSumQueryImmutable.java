package org.yuhang.algorithm.leetcode.dynamicprogram;

/**
 * 区域和检索-数组不可变 303
 */
public class ProblemRangeSumQueryImmutable {

    class NumArray {

        int[] sums;
        public NumArray(int[] nums) {
          sums = new int[nums.length];
          sums[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                sums[i] = sums[i-1] + nums[i];
            }
        }

        public int sumRange(int i, int j) {
            if(i == 0){
                return sums[j];
            }else{
                return sums[j] - sums[i];
            }

        }
    }
}
