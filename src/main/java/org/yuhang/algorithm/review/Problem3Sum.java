package org.yuhang.algorithm.review;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 3数之和 LC15
 */
public class Problem3Sum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length == 0) return res;
        Arrays.sort(nums);
        for (int i = 0; i <nums.length ;) {
            int l = i+1,r = nums.length-1;
            while (l < r) {
                if (nums[i] + nums[l] + nums[r] == 0) {
                    List<Integer> res1 = new ArrayList<>();
                    res1.add(nums[i]);
                    res1.add(nums[l]);
                    res1.add(nums[r]);
                    res.add(res1);
                    while (l+1<nums.length && nums[l+1] == nums[l]){
                        l++;
                    }
                    while (r-1>=i+1 && nums[r] == nums[r-1]){
                        r--;
                    }
                    l++;
                    r--;

                } else if (nums[i] + nums[l] + nums[r] < 0) {
                    while (l+1 < nums.length && nums[l+1] == nums[l]){
                        l++;
                    }
                    l++;
                } else {
                    while (r-1>=i+1 && nums[r-1] == nums[r]){
                        r--;
                    }
                    r--;
                }
            }
            while (i+1<nums.length && nums[i+1] == nums[i]){
                i++;
            }
            i++;
        }

        return res;

    }

    public static void main(String[] args) {
        int[] sums = {-1,0,1,2,-1,-4};
        System.out.println(new Problem3Sum().threeSum(sums));
    }


}
