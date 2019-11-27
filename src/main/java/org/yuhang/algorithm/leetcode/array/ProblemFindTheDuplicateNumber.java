package org.yuhang.algorithm.leetcode.array;

/**
 * 寻找重复数 LC287  空间复杂度O(1),数组不可变
 * @tag:二分查找
 * @tag:双指针
 */
public class ProblemFindTheDuplicateNumber {


    /**
     * 暴力法
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {
        for (int i = 0; i <nums.length ; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if(nums[j] == nums[i]){
                    return nums[j];
                }
            }
        }
        return 0;
    }

    /**
     * 二分查找法 对1~n做二分
     * @param nums
     * @return
     */
    public int findDuplicate1(int[] nums) {
        int n = nums.length;
        int start = 1,end = n-1;
        while (start < end){
            int mid = start + (end-start+1)/2;
            int count = 0;
            for(int num:nums){
                if(num < mid){
                    count++;
                }
            }
            if(count < mid){ //统计比mid小的数量比mid小，则mid左边不存在重复数字
                start = mid;
            }else{
                end = mid-1;
            }
        }
        return start;
    }

    /**
     * 快慢指针法,相当于找循环链表的入口节点 TODO
     * @param nums
     * @return
     */
    public int findDuplicate2(int[] nums) {

        return 0;
    }

}
