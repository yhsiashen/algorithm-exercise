package org.yuhang.algorithm.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 4数之和 LC18
 */
public class Problem4Sum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();//
        if (nums.length < 4) return res;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-3;) {
            for (int j = i+1; j < nums.length-2 ;) {
                int l = j+1, k = nums.length-1;
                while (l<k){
                   if(nums[i]+nums[j]+nums[l]+nums[k] == target){
                       List<Integer> res1 = new ArrayList<>();
                       res1.add(nums[i]);
                       res1.add(nums[j]);
                       res1.add(nums[l]);
                       res1.add(nums[k]);
                       res.add(res1);
                       l++;
                       k--;
                       while (l<k && nums[l] == nums[l-1]){
                           l++;
                       }
                       while (l<k && nums[k] == nums[k+1]){
                           k--;
                       }
                   }else if(nums[i]+nums[j]+nums[l]+nums[k] < target){
                       l++;
                       while (l<k && nums[l] == nums[l-1]){//跳过重复数字
                           l++;
                       }
                   }else{
                       k--;
                       while (l<k && nums[k] == nums[k+1]){
                           k--;
                       }
                   }
                }

                j++;
                while (j < nums.length-2 && nums[j] == nums[j-1]){//跳过重复数字
                    j++;
                }

            }
            i++;
            while (i < nums.length-3 && nums[i] == nums[i-1]){
                i++;
            }


        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-1,2,2,-5,0,-1,4};
        System.out.println(new Problem4Sum().fourSum(nums, 3).toString());
    }
}
