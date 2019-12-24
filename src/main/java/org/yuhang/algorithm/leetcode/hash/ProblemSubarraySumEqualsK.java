package org.yuhang.algorithm.leetcode.hash;


import java.util.HashMap;
import java.util.Map;

/**
 * 和为K的连续子数组的个数 LC560
 * @tag:哈希表
 */
public class ProblemSubarraySumEqualsK {

    public int subarraySum(int[] nums, int k) {
        int sum = 0,res = 0;
        Map<Integer,Integer> map = new HashMap<>();//子数组和->出现次数
        for (int i = 0; i < nums.length ; i++) {
            sum += nums[i];
            if(map.containsKey(sum-k)){
                res+=map.get(sum-k);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return res;
    }
}
