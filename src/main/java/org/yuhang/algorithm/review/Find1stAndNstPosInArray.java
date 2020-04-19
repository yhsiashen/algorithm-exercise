package org.yuhang.algorithm.review;

/**
 * 在排序数组中查找元素的第一个和最后一个位置 LC34
 */
public class Find1stAndNstPosInArray {

    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0) return new int[]{-1,-1};
        int l = 0, r = nums.length-1;
        int start = -1,end = -1;
        while (l <= r){
           int mid = l+ (r-l)/2;
           if(nums[mid] == target){
               int s = mid;
               int e = mid;
               while (s-1>=0 && nums[s-1] == target){
                   s--;
               }
               start = s;
               while (e+1<nums.length && nums[e+1] == target){
                   e++;
               }
               end = e;
               break;

           }else if(nums[mid] < target){
               l = mid+1;
           }else{
               r = mid-1;
           }
        }

        return new int[]{start,end};


    }
}
