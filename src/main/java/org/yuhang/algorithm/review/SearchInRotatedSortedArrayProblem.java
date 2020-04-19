package org.yuhang.algorithm.review;

/**
 * 搜索旋转排序数组 LC33
 * @tag:二分查找
 */
public class SearchInRotatedSortedArrayProblem {

    public int search(int[] nums, int target) {
        if(nums.length == 0) return -1;
        int l = 0,r = nums.length-1;
        while (l <= r){
            int mid = l+(r-l)/2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[l] <= nums[mid]){//左半边有序，注意此处是小于等于，因为最后只剩两个数时，取mid会造成mid=l，语义上符合左半边有序
                if(nums[l] <= target && nums[mid]> target){//在坐半区
                    r = mid-1;
                }else{//在右半区
                    l = mid+1;
                }

            }else {//右半区有序
                if(nums[mid] < target && nums[r] >= target){//在右半区
                    l = mid+1;
                }else{//在坐半区
                    r = mid-1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        System.out.println(new SearchInRotatedSortedArrayProblem().search(nums,3));
    }


}
