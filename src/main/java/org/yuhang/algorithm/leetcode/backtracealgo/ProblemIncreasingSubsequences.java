package org.yuhang.algorithm.leetcode.backtracealgo;

import java.util.*;

/**
 * 递增的子序列 LC491
 * @tag:回溯算法
 */
public class ProblemIncreasingSubsequences {

    public List<List<Integer>> findSubsequences(int[] nums) {
       Set<List<Integer>> res = new HashSet<>(); //hashset去重
       Arrays.sort(nums);
       backtrace(nums,0,new ArrayList<>(),res);
       return new ArrayList<>(res);
    }

    private void backtrace(int[] nums, int index,List<Integer> tmp,Set<List<Integer>> res) {
        if(tmp.size() >=2){
           res.add(new ArrayList<>(tmp));
        }
        for (int i = index; i < nums.length; i++) {
           if(!tmp.isEmpty() && tmp.get(tmp.size()-1) > nums[i]) continue;
           tmp.add(nums[i]);
           backtrace(nums,i+1,tmp,res);
           tmp.remove(tmp.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {4,6,6,7};
        new ProblemIncreasingSubsequences().findSubsequences(nums);
    }
}
