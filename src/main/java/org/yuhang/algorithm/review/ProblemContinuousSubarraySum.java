package org.yuhang.algorithm.review;

import java.util.HashMap;

/**
 * 连续的子数组和为K的整数倍 LC523
 * @tag:前缀和
 */
public class ProblemContinuousSubarraySum {

    public boolean checkSubarraySum(int[] nums, int k) {
        if(nums.length < 2)  return false;
        for (int i = 0; i < nums.length-1; i++) {
            if(nums[i] == 0 && nums[i+1]==0) return true;
        }
        if(k == 0) return false;
        k = Math.abs(k);
        int[] preSum = new int[nums.length+1];
        for (int i = 1; i < preSum.length ; i++) {
            preSum[i] = preSum[i-1]+nums[i-1];
        }

        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,0);
        for (int i = 1; i < preSum.length; i++) {
            if(map.containsKey(preSum[i]%k) && (i - map.get(preSum[i]%k)>1)){
                return true;
            }
            map.putIfAbsent(preSum[i]%k,i);//存最早的索引值,即如果之前存在key，则此次不存
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,0};
        System.out.println(new ProblemContinuousSubarraySum().checkSubarraySum(nums,-1));
    }
}
