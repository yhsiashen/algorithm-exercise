package org.yuhang.algorithm.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 乘积小于K的子数组的个数
 */
public class ProblemSubarrayProductLessThanK {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int res = 0;
        int left = 0,right=0;
        int multi = 1;
        while (right< nums.length){
            multi *= nums[right];
            while (multi >= k){
                multi /= nums[left++];
            }
            res += right-left+1;
            right++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {10,5,2,6};
        System.out.println(new ProblemSubarrayProductLessThanK().numSubarrayProductLessThanK(nums,100));
    }
}
