package org.yuhang.algorithm.review.new20200226;

/**
 * 二分查找
 * [1,2],2
 */
public class BinarySearch {

    public int search(int[] nums, int target) {
        int l = 0, r = nums.length-1;
        while (l <= r){
            int mid = (l+r)/2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] < target){
                l = mid+1;
            }else{
                r = mid-1;
            }
        }
        return -1;
    }
}
