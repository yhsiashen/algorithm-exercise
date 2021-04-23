package org.yuhang.algorithm.review.new20200226;

/**
 * 搜索旋转排序数组
 * 输入：nums = [4,5,6,7,0,1,2], target = 0
 * 输出：4
 *
 * 输入：[1,3],3
 * 输出：1
 *
 * [5,1,3],3
 * 2
 */
public class SearchInRotatedSortedArray {


    public int search(int[] nums, int target) {
        if(nums.length == 0) return -1;
        int l = 0, r = nums.length-1;
        while (l <= r){
            int mid = (l+r)/2;
            if(nums[mid] == target) {
                return mid;
            }else if(nums[l] <= nums[mid]){//左边有序 /note: 如果用l和mid判断左边是否有序，则需注意l == mid的情况,此处建议用mid 和 r判断，则无需考虑 l == mid的情况
                if(target < nums[mid] && target >= nums[l]){//注意等号！！！
                    r = mid-1;
                }else{
                    l = mid+1;
                }
            }else {//右边有序
                if(target <= nums[r] && target > nums[mid]){//注意等号！！！
                    l = mid+1;
                }else{
                    r = mid-1;
                }
            }
        }
        return -1;
    }
}
