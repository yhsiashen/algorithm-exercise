package org.yuhang.algorithm.review.new20200226;

import java.util.*;

/**
 * 找出数组中两数之和等于给定target值的所有整数对,一个数字只能属于一个结果
 * 输入: nums = [5,6,5,6], target = 11
 * 输出: [[5,6],[5,6]]
 *
 * notes: nums.length <= 100000
 */
public class PairsWithSumLcci {


    public List<List<Integer>> pairSums(int[] nums, int target) {
        List<List<Integer>> res= new ArrayList<>();
        if(nums.length == 0) return res;
        Map<Integer,Integer> map = new HashMap<>();
        for(int n:nums){
            if(map.containsKey(target-n) && map.get(target-n) > 0){
                map.put(target-n, map.get(target-n)-1);
                List<Integer> list  = new ArrayList<>();
                list.add(n);
                list.add(target-n);
                res.add(list);
            }else {
                map.put(n,map.getOrDefault(n, 0)+1);
            }
        }
        return res;
    }

    public List<List<Integer>> pairSums1(int[] nums, int target) {
        List<List<Integer>> res= new ArrayList<>();
        if(nums.length == 0) return res;
        Arrays.sort(nums);
        int l = 0, r= nums.length-1;
        while (l < r){
            if(nums[l] + nums[r] == target){
                List<Integer> list = new ArrayList<>();
                list.add(nums[l]);
                list.add(nums[r]);
                res.add(list);
                l++;
                r--;
            }else if(nums[l] + nums[r] > target){
                r--;
            }else{
                l++;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int[] nums = {5,6,5,6};
        System.out.println(new PairsWithSumLcci().pairSums(nums, 11));
    }
}
