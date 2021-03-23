package org.yuhang.algorithm.review.new20200226;

/**
 * 总和最大的连续数列
 * 输入:    [-2,1,-3,4,-1,2,1,-5,4]
 * 前缀和:[0,-2,-1,-4,0,-1,1,2,-3,1]
 * 输出：  6
 * 解释： 连续子数组 [4,-1,2,1] 的和最大，为 6。
 */
public class ContiguousSequenceLcci {

    public int maxSubArray(int[] nums) {
        if(nums.length == 0) return 0;
        int[] preSum = new int[nums.length+1];
        for (int i = 1; i < preSum.length; i++){
            preSum[i] = preSum[i-1]+nums[i-1];
        }
        int min = Integer.MAX_VALUE;
        int res = Integer.MIN_VALUE;
        for (int i = 1; i < preSum.length; i++) {
            min = Math.min(preSum[i-1], min);//维护i之前的最小值
            res = Math.max(res, preSum[i]-min);//将preSum[i]-min得到结果，维护这个最大结果
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-2,-1};
        System.out.println(new ContiguousSequenceLcci().maxSubArray(nums));
    }
}
