package org.yuhang.algorithm.leetcode.array;


/**
 * 寻找旋转排序数组的最小值 LC153 复杂度为O(logn)
 * @tag:二分查找
 *
 */
public class ProblemFindMinimumInRotatedSortedArray {

    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (r - l) / 2 + l;
            if (nums[mid] < nums[l]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return nums[l];
    }

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        System.out.println(new ProblemFindMinimumInRotatedSortedArray().findMin(nums));
    }
}
