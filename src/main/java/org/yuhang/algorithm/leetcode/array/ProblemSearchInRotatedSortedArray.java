package org.yuhang.algorithm.leetcode.array;


/**
 * 搜索旋转排序数组,要求时间复杂度logn,二分查找  LC33
 * @tag:二分查找
 */
public class ProblemSearchInRotatedSortedArray {

    public int search(int[] nums, int target) {
        if(nums.length == 0) return -1;
        int start = 0,end = nums.length-1;
        while (start<end){
            int mid = (start+end)/2;
            if( (nums[start]<=nums[mid] && nums[start]<=target && target<=nums[mid]) ||
                    (nums[start] > nums[mid] && target<=nums[mid]) ||
                    (nums[start] > nums[mid] && target>=nums[start])) {//在前半区间的情况
                end = mid;
            }else {
                start = mid +1;
            }
        }
        //start=end
        return nums[start] == target?start:-1;
    }



    public static void main(String[] args) {
        int[] nums= {4,5,6,7,0,1,2};
        System.out.println(new ProblemSearchInRotatedSortedArray().search(nums,0));
    }
}
