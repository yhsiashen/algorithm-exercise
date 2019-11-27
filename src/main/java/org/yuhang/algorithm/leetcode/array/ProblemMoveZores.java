package org.yuhang.algorithm.leetcode.array;

/**
 * 移动零 LC283
 * @tag:双指针
 */
public class ProblemMoveZores {


    public void moveZeroes(int[] nums) {
       int zore = -1; //zore指针表示当前的遍历状态的第一个0元素索引
       for (int i = 0; i < nums.length; i++) {
           if(zore!=-1 && nums[i]!=0) {
               nums[zore++] = nums[i];
               nums[i] = 0;
           }else if(zore==-1 && nums[i] == 0){
               zore = i;
           }
       }

    }

}
