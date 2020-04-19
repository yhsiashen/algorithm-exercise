package org.yuhang.algorithm.review;

/**
 * 搜索旋转的排序数组II LC81
 * @tag:二分查找
 */
public class SearchInRotatedSortedArrayIIProblem {

    public boolean search(int[] nums, int target) {
        if(nums.length == 0) return false;
        int l = 0,r= nums.length-1;
        while (l<=r){
            while (l<r && nums[l]==nums[l+1]) l++;//处理重复数据
            while (l<r && nums[r]==nums[r-1]) r--;
            int mid =l + (r-l)/2;
            if(target == nums[mid]){
                return true;
            }else if(nums[l] <= nums[mid]){//左半区有序
                if(nums[l]<=target && target < nums[mid]){
                    r = mid-1;
                }else{
                    l = mid+1;

                }

            }else {//右半区有序
                if(nums[mid] < target && target<=nums[r]){
                    l = mid+1;
                }else{
                    r = mid-1;
                }

            }


        }

        return false;


    }
}
