package org.yuhang.algorithm.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 在数组中找出和为目标值的两个整数的下标 1
 */
public class ProblemTwoSum {

    /**
     * brute force
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        if(nums.length==0) return new int[2];
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int t = target - nums[i];
            for (int j = i+1; j < nums.length; j++) {
                if(nums[j] == t){
                    res[0] = i;
                    res[1] = j;
                    return res;
                }
            }
        }
        return res;
    }

    /**
     * hash
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum1(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int t = target - nums[i];
            if(map.containsKey(t)){
                return new int[]{i,map.get(t)};
            }
            map.put(nums[i],i);
        }
        return new int[2];
    }
}
