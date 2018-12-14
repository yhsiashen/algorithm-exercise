package org.yuhang.algorithm.leetcode.dynamicplan;

/** 打家劫舍2 213
 * Created by chinalife on 2018/12/4.
 */
public class ProblemRob2 {

    public int rob(int[] nums) {
      if(nums==null || nums.length==0)
          return 0;
      if(nums.length==1)
            return nums[0];
      if(nums.length==2)
            return Math.max(nums[0],nums[1]);
      //分别考虑打劫1~n-1 和2~n两种情况下的最大抢钱数
        int[] money1 = new int[nums.length-1];
        money1[0] = nums[0];
        money1[1] = Math.max(nums[0],nums[1]);
        for (int i = 2; i < nums.length-1; i++) {
            money1[i] = Math.max(money1[i-2]+nums[i],money1[i-1]);
        }
        int[] money2 = new int[nums.length-1];
        money2[0] = nums[1];
        money2[1] = Math.max(nums[1],nums[2]);
        for (int i = 2; i < nums.length-1; i++) {
            money2[i] = Math.max(money2[i-2]+nums[i+1],money2[i-1]);
        }


       return Math.max(money1[nums.length-2],money2[nums.length-2]);
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        System.out.println(new ProblemRob2().rob(nums));

    }
}
