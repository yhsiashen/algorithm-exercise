package org.yuhang.algorithm.review.new20200226;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 找出数组中三数之和为0的三个数
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 *
 *
 * 0 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
       List<List<Integer>> res = new ArrayList<>();
       if(nums.length == 0) return res;
       Arrays.sort(nums);//O(nlogn)
       for (int i = 0; i < nums.length; i++) {
         if(i > 0 && nums[i] == nums[i-1]) continue;
         int target = nums[i];
         int l = i+1,r= nums.length-1;
         while (l<r){
             if(nums[l]+nums[r]+target == 0){
                 List<Integer> list =  new ArrayList<>();
                  list.add(target);
                  list.add(nums[l]);
                  list.add(nums[r]);
                  res.add(list);
                  l++;
                  while (l<nums.length && nums[l] == nums[l-1]) l++;
                  r--;
                  while (r>i && nums[r] == nums[r+1]) r--;
             }else if(nums[l]+nums[r]+target < 0){
                 l++;
                 while (l<nums.length && nums[l] == nums[l-1]) l++;
             }else{
                 r--;
                 while (r>i && nums[r] == nums[r+1]) r--;
             }
        }
     }
       return res;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        ThreeSum threeSum = new ThreeSum();
        threeSum.threeSum(nums);
    }

}
