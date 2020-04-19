package org.yuhang.algorithm.review;

/**
 * 跳跃游戏 LC55
 */
public class ProblemJumpGame {

    public boolean canJump(int[] nums) {
        if(nums.length == 0) return false;
        int max = nums[0];
        for (int i = 1; i < nums.length && max>=i; i++) {
            max = Math.max(max, nums[i]+i);
            if(max >= nums.length-1){
                return true;
            }
        }
        return false;
    }
}
