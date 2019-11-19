package org.yuhang.algorithm.leetcode.array;


import java.util.ArrayList;
import java.util.List;

/**
 * 汇总区间 LC228
 *
 */
public class ProblemSummaryRanges {

    public List<String> summaryRanges(int[] nums) {
       List<String> res = new ArrayList<>();
       int i = 0;
       while (i < nums.length){
           int j = i+1;
           while (j<nums.length  && nums[j] - nums[j-1] == 1){
               j++;
           }
           String s;
           if(j-1 == i){
               s = Integer.toString(nums[i]);
           }else{
               s = nums[i] +"->"+nums[j-1];
           }
           res.add(s);
           i = j;
       }
       return res;
    }

    public static void main(String[] args) {
        int[] nums = {0,2,3,4,6,8,9};
        new ProblemSummaryRanges().summaryRanges(nums);
    }
}
