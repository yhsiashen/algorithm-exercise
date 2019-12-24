package org.yuhang.algorithm.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 找到数组中所有消失的数字 LC448
 *
 */
public class ProblemFindAllNumbersDisappearedInArray {

    public List<Integer> findDisappearedNumbers(int[] nums) {
      List<Integer> res = new ArrayList<>();
      if(nums.length == 0) return res;
      for (int j = 0; j < nums.length; j++) {
          while (nums[j] != nums[nums[j]-1]){
              swap(nums,j,nums[j]-1);
          }
      }

      for (int i = 0; i < nums.length; i++) {
          if(nums[i] != nums[nums[i]-1]) res.add(i+1);
      }
      return res;
    }

    private void swap(int[] nums, int i, int j) {
         int tmp = nums[i];
         nums[i] = nums[j];
         nums[j] = tmp;
    }

    public static void main(String[] args) {
        System.out.println(new ProblemFindAllNumbersDisappearedInArray().findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1}));
    }


}
