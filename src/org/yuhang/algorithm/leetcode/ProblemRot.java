package org.yuhang.algorithm.leetcode;

/**  打家劫舍
 * Created by chinalife on 2018/10/13.
 */
public class ProblemRot {
    public int rob(int[] nums) {
       if(nums.length==0) {
           return 0;
       }
       if(nums.length==1){
           return nums[0];
       }
       int[] maxRot=new int[nums.length];
       maxRot[0] = nums[0];
       maxRot[1] = Math.max(nums[0],nums[1]);
        for (int i = 2; i < nums.length ; i++) {
            maxRot[i] = Math.max(maxRot[i-1],maxRot[i-2]+nums[i]);
        }
        return maxRot[nums.length-1];
    }


    public static void main(String[] args) {
           int[] nums = {1};
        System.out.println(new ProblemRot().rob(nums));
    }
}
