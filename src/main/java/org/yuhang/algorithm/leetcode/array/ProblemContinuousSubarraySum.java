package org.yuhang.algorithm.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 连续的子数组和 LC523
 */
public class ProblemContinuousSubarraySum {

    /**
     * 前缀和+哈希表
     * @param nums
     * @param k
     * @return
     */
    public boolean checkSubarraySum(int[] nums, int k) {
        if(nums.length == 0) return false;
        for (int i = 0; i < nums.length-1; i++) {
            if(nums[i] == 0 && nums[i+1]==0) return true;
        }
        if(k == 0) return false;
        k = Math.abs(k);
        int[] preSum = new int[nums.length+1];
        for (int i = 0; i < preSum.length-1; i++) {
            preSum[i+1] = preSum[i]+nums[i];
        }
//        int[] maps = new int[k];//存索引，key为preSum[i]%k
        Map<Integer,Integer> map = new HashMap<>();//避免k过大导致初始化数组时内存过高，这里用hashmap实现
        for (int i = 1; i < preSum.length; i++) {
            if(preSum[i]%k==0 && i>1)return true;
//            if(maps[preSum[i]%k]!=0 && i-maps[preSum[i]%k]>1) return true;
            if(map.getOrDefault(preSum[i]%k,0)!=0 && i- map.get(preSum[i]%k)>1) return true;
//            maps[preSum[i]%k] = i;
            map.put(preSum[i]%k,i);//前缀和除以k的余数做key， 索引i做value， 如果在后面的前缀和中也能找到同样的key，则这两个索引的前缀和相减即为k的n倍
        }
        return false;
    }


    public static void main(String[] args) {
       int[] nums =  {0};
       int k = 0;
       System.out.println(new ProblemContinuousSubarraySum().checkSubarraySum(nums,k));
    }

}
