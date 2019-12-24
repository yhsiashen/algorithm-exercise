package org.yuhang.algorithm.leetcode.array;


import java.util.Arrays;

/**
 * 最短的无序连续子数组 LC581
 * @tag:双指针
 */
public class ProblemShortestUnsortedContinuousSubarray {

    public int findUnsortedSubarray(int[] nums) {
        int[] order = new int[nums.length];
        System.arraycopy(nums,0,order,0,nums.length);
        Arrays.sort(nums);
        int left = 0,right = nums.length-1;
        while (left<=right && order[left] == nums[left]){
            left++;
        }
        while (right>=left && order[right] == nums[right]){
            right--;
        }

        return right-left+1;
    }

    public static void main(String[] args) {
        System.out.println(new ProblemShortestUnsortedContinuousSubarray().findUnsortedSubarray(new int[]{2, 6, 4, 8, 10, 9, 15}));
    }
}
