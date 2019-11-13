package org.yuhang.algorithm.leetcode.array;


/**
 * 寻找一个峰值元素,时间复杂度为O(logn)
 * @tag:二分查找
 */
public class ProblemFindPeakElement {

    /**
     * 若数组中一个元素比相邻元素大，则沿着该元素一定能找到一个峰值
     * @param nums
     * @return
     */
    public int findPeakElement(int[] nums) {
        int left = 0,right = nums.length -1;
        while (left < right){
            int  mid = (left + right) / 2;
            if(nums[mid] < nums[mid+1]){
                left = mid +1;
            }else{
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {

    }


}
