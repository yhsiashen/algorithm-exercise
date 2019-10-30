package org.yuhang.algorithm.leetcode.array;

/**
 * 搜索旋转排序数组II LC81  TODO
 */
public class ProblemSearchInRotatedSortedArrayII {

    public boolean search(int[] nums, int target) {
        if (nums.length == 0) return false;
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if ((nums[left] <= nums[mid] && nums[left] <= target && target <= nums[mid]) ||
                    (nums[left] > nums[mid] && target <= nums[mid]) ||
                    (nums[left] > nums[mid] && target >= nums[left])) {//在前半区间的情况

            }

        }

        return false;
    }
}
