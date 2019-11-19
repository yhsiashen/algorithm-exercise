package org.yuhang.algorithm.leetcode.array;


/**
 * 长度最小的连续子数组  LC209
 */
public class ProblemMinimumSizeSubarraySum {

    /**
     * 暴力法，遍历数组，找最小的连续子树组
     * @param s
     * @param nums
     * @return
     */
    public int minSubArrayLen(int s, int[] nums) {
        int minLength = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length ; i++) {
            int j = i,curSum = 0;
            while (j-i+1 <= minLength && j < nums.length){
                curSum += nums[j];
                if(curSum >= s){ //找到一个新的>=s的连续子数组
                    minLength = j-i+1;
                    break;
                }
                j++;
            }
        }
        return minLength == Integer.MAX_VALUE?0:minLength;
    }


    /**
     * 双指针&滑动窗口
     * @param s
     * @param nums
     * @return
     */
    public int minSubArrayLen1(int s, int[] nums) {
       int res = Integer.MAX_VALUE;
       int sum = 0;
       int left = 0;
       for (int i = 0; i < nums.length ; i++) {
            sum += nums[i];
            while (sum >= s){
                res = Math.min(res,i-left+1);
                sum -= nums[left++];
            }
       }
       return res==Integer.MAX_VALUE?0:res;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        System.out.println(new ProblemMinimumSizeSubarraySum().minSubArrayLen(7,nums));
    }
}
