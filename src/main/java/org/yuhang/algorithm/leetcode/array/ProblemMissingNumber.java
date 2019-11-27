package org.yuhang.algorithm.leetcode.array;


/**
 * 找到缺失的数字  LC268
 * @tag:位运算
 */
public class ProblemMissingNumber {

    public int missingNumber(int[] nums) {
        int missingNum = nums.length; //长度为n的数组代表0~n的序列
        for (int i = 0; i < nums.length; i++) {
              missingNum ^= i; //0~n异或一次
              missingNum ^= nums[i]; //输入序列中的数字异或一次
                               //存在的数字两两异或得0，剩下一个单独的数字即为结果
        }
        return missingNum;
    }
}
