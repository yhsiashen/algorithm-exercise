package org.yuhang.algorithm.leetcode.array;

import java.util.Arrays;

/**
 * 找出数组中最接近给定target的三数之和  16
 */
public class ProblemThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = nums[0] + nums[1] +nums[2];
        for (int i = 0; i < nums.length;i++) {
           int j = i+1; //双指针j和k
           int k = nums.length-1;
           while (j<k){
               int threeSum = nums[i]+nums[j]+nums[k];
               if(Math.abs(threeSum -target) < Math.abs(res-target)){
                   res = threeSum;
               }
               if(threeSum > target){
                   k--;
               }else if(threeSum < target){
                   j++;
               }else{
                   return target;
               }
           }
        }

        return res;
    }

    public static void main(String[] args) {
         int[] nums = {-1,2,1,-4};
        System.out.println(new ProblemThreeSumClosest().threeSumClosest(nums,1));
    }
}
