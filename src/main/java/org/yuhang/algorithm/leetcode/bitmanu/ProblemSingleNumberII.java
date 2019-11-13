package org.yuhang.algorithm.leetcode.bitmanu;


/**
 * 只出现一次的数字II LC137
 * @tag:位运算
 */
public class ProblemSingleNumberII {

    public int singleNumber(int[] nums) {
      int a = 0,b=0;
      for(int i : nums){
          b = (b ^ i) & ~a;
          a = (a ^ i) & ~b;
      }
      return b;
    }
}
