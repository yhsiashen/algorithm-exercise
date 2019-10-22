package org.yuhang.algorithm.leetcode.array;

/**
 * 在排序数组中查找元素的第一个和最后一个位置,时间复杂度O(logn) LC34
 */
public class ProblemFindFirstAndLastPositionOfElementInSortedArray {

    public int[] searchRange(int[] nums, int target) {
        if(nums.length ==0 )return new int[]{-1,-1};
        int start = 0,end = nums.length-1;
        while (start<end){
            int mid = (start+end)/2;
            if(nums[mid] == target){
                int index_forward = mid;
                int index_back = mid;
                while (index_forward>=0 && nums[index_forward]==target){
                    index_forward--;
                }
                index_forward = index_forward == mid?mid:index_forward+1;
                while (index_back<=nums.length-1 && nums[index_back]==target){
                    index_back++;
                }
                index_back = index_back==mid?mid:index_back-1;
                return new int[]{index_forward,index_back};
            }

            if(target > nums[mid]){
               start = mid +1;
            }else{
                end = mid-1;
            }
        }

        //start==end
        return nums[start]==target?new int[]{start,start}:new int[]{-1,-1};
    }

    public static void main(String[] args) {
        int[] nums = {5,6,7,7,7,8,8,9};
        int[] res = new ProblemFindFirstAndLastPositionOfElementInSortedArray().searchRange(nums,7);
        for (int i : res){
            System.out.println(i);
        }
    }
}
