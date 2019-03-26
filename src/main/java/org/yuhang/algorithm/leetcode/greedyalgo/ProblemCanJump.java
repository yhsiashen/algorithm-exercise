package org.yuhang.algorithm.leetcode.greedyalgo;

/** 判断能否从数组第一位跳到最后一位(贪心法) 55
 * Created by chinalife on 2018/10/15.
 */
public class ProblemCanJump {



    public boolean canJump(int[] nums) {
        int reach = nums[0];
        for(int i = 1; i < nums.length && reach >= i; i++)
            if(i + nums[i] > reach) reach = i + nums[i];  //贪心策略
        return reach >= (nums.length - 1);
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println(new ProblemCanJump().canJump(nums));
    }

}
