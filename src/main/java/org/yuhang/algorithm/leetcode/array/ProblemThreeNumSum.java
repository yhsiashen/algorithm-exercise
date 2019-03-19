package org.yuhang.algorithm.leetcode.array;


import java.util.*;

/**
 * 给定一个数组，判断数组中是否存在三个元素a,b,c,使得a+b+c=0   15
 */
public class ProblemThreeNumSum {

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null)
            return null;
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3)
            return result;
        //排序
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-1;) {
            //双指针分别从i+1与nums.length-1位置开始
            int j = i+1;
            int k = nums.length-1;
            while (j<k){
                if(nums[i]+nums[j]+nums[k] == 0){
                    List<Integer> eachResult = new ArrayList<>();
                    eachResult.add(nums[i]);
                    eachResult.add(nums[j]);
                    eachResult.add(nums[k]);
                    result.add(eachResult);
                    j++;
                    k--;

                    //处理重复数据
                    while (j<k && nums[j] == nums[j-1])
                        j++;
                    while (j<k && nums[k] == nums[k+1])
                        k--;
                }else if(nums[i]+nums[j]+nums[k] < 0 ){
                    j++;

                    while (j<k && nums[j] == nums[j-1])
                        j++;

                }else {
                    k--;
                    while (j<k && nums[k] == nums[k+1])
                        k--;
                }
            }
            i++;
            while (i<nums.length-1 && nums[i]==nums[i-1])
                i++;
        }
       return result;
    }

    public static void main(String[] args) {
        int[] nums = {-2,0,1,1,2};
        System.out.println(new ProblemThreeNumSum().threeSum(nums).toString());
    }
}
