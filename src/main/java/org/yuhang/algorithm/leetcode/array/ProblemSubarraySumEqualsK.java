package org.yuhang.algorithm.leetcode.array;

import java.util.HashMap;

/**
 * 和为K的子数组 LC560
 */
public class ProblemSubarraySumEqualsK {

    public int subarraySum(int[] nums, int k) {
        int[] preSum = new int[nums.length+1];
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i-1]+nums[i-1];
        }

        int res = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for (int i = 1; i < preSum.length ; i++) {
            res += map.getOrDefault(preSum[i]-k,0);
            map.put(preSum[i],map.getOrDefault(preSum[i],0)+1);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1};
        System.out.println(new ProblemSubarraySumEqualsK().subarraySum(nums,2));
    }
}
