package org.yuhang.algorithm.leetcode.dynamicplan;

/** 求序列的最长子摆动序列的长度(可非连续)
 * Created by chinalife on 2018/11/6.
 */
public class ProblemWiggleMaxLength {


    public int wiggleMaxLength(int[] nums) {
         if(nums==null || nums.length ==0)
             return 0;
         // 升数组代表长度为n的序列最后两个元素是上升关系的最长子摆动序列的长度
        int[] up = new int[nums.length];
        // 降数组代表长度为n的序列最后两个元素是下降关系的最长子摆动序列的长度
        int[] down = new int[nums.length];
        up[0] = down[0] = 1;
        //动态规划
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] > nums[i-1]){
               up[i] = down[i-1]+1;
               down[i] = down[i-1];
            }else if(nums[i] < nums[i-1]){
                down[i] = up[i-1]+1;
                up[i] = up[i-1];
            }else {
                up[i]=up[i-1];
                down[i] = down[i-1];
            }
        }
       return Math.max(up[nums.length-1],down[nums.length-1]);
    }

}
