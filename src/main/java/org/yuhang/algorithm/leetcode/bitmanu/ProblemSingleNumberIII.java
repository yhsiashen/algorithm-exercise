package org.yuhang.algorithm.leetcode.bitmanu;

/**
 * 只出现一次的数字III LC260
 * @tag:位运算
 */
public class ProblemSingleNumberIII {

    public int[] singleNumber(int[] nums) {
        if(nums.length == 0) return new int[]{};
        int s = 0;
        for (int num : nums) {
            s ^= num;
        }
        int n=0;
        while ((s & (1<<n)) == 0){
            n++;
        }
        int a=0,b=0;
        for (int num:nums){
            if((num & (1<<n)) == (1<<n)){
               a^=num;
            }else {
               b^=num;
            }
        }
        return new int[]{a,b};
    }

    public static void main(String[] args) {
        System.out.println( 6 & -6);
    }
}
