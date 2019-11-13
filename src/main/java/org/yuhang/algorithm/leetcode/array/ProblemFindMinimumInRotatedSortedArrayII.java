package org.yuhang.algorithm.leetcode.array;


/**
 * 寻找旋转排序数组的最小值 LC154 复杂度为O(logn)
 * @tag:二分查找
 */
public class ProblemFindMinimumInRotatedSortedArrayII {

    public int findMin(int[] nums) {
        int left = 0,rigth = nums.length -1;
        while (left < rigth){
            int mid = (left + rigth)/2;
            if(nums[mid] < nums[rigth]){ //反转点必在left~mid区间
                rigth = mid;
            }else if(nums[mid] > nums[rigth]){ //反转点必在mid+1~right区间
                left = mid + 1;
            }else {
                rigth--;
            }

        }
        return nums[left];
    }

    public static void main(String[] args) {
        int[] nums = {2,2,2,0,1};
        System.out.println(new ProblemFindMinimumInRotatedSortedArrayII().findMin(nums));
    }
}
