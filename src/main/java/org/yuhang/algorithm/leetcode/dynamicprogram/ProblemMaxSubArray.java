package org.yuhang.algorithm.leetcode.dynamicprogram;

/** 最大和的连续子数组
 * Created by chinalife on 2018/10/12.
 */
public class ProblemMaxSubArray {

    public int maxSubArray(int[] nums) {
        int[] f = new int[nums.length];
        f[0] = nums[0];
        int maxsub = f[0];//存最大值
        for (int i = 1; i < nums.length ; i++) {
            f[i] = Math.max(f[i-1]+nums[i],nums[i]);
            maxsub = Math.max(maxsub,f[i]);
        }
        return maxsub;
    }

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(new ProblemMaxSubArray().maxSubArray(nums));

    }

}
