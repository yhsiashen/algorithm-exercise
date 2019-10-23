package org.yuhang.algorithm.leetcode.array;


/**
 * 搜索数字在数组中的插入位置  LC35
 * @tag:二分查找
 */
public class ProblemSearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
       if(nums.length == 0) return 0;
       int start  = 0 , end = nums.length -1;
       while (start <= end){
           int mid = (start + end) / 2;
           if( nums[mid] == target) {
               return mid;
           }

           if(nums[mid] < target ){
               start = mid + 1;
           }else{
               end = mid - 1;
           }
       }
       // start > end
        return start;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,5,7};
        System.out.println(new ProblemSearchInsertPosition().searchInsert(nums,6));
    }
}
