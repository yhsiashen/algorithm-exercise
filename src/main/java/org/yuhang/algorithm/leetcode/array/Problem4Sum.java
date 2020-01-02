package org.yuhang.algorithm.leetcode.array;

import java.util.*;

/**
 * 4数之和 LC18
 */
public class Problem4Sum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
          Set<List<Integer>> res = new HashSet<>();//存不重复的结果
          if(nums.length <4) return new ArrayList<>(res);
          Arrays.sort(nums);
          for (int i = 0; i < nums.length; i++) {
              for (int j = i+1; j < nums.length; j++) {
                  int l = j+1,k = nums.length-1;
                  while (l < k){
                      if(nums[i]+nums[j]+nums[l]+nums[k] == target) {
                          List<Integer> tmp = new ArrayList<>();
                          tmp.add(nums[i]);
                          tmp.add(nums[j]);
                          tmp.add(nums[l]);
                          tmp.add(nums[k]);
                          res.add(tmp);
                          l++;
                          k--;


                      }else if(nums[i]+nums[j]+nums[l]+nums[k] < target){
                          l++;
                      }else if(nums[i]+nums[j]+nums[l]+nums[k] > target){
                          k--;
                      }
                  }
              }
          }
          return new ArrayList<>(res);
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        List<Integer> list1 = new ArrayList<>();
        list1.add(2);
        list1.add(1);
        Set<List<Integer>> set = new HashSet<>();
        set.add(list);
        set.add(list1);
        System.out.println(set.size());
    }
}
