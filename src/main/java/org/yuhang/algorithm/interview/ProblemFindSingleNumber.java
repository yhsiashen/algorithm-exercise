package org.yuhang.algorithm.interview;

import java.util.Arrays;

/**
 * 找出数组中只出现一次的数字
 */
public class ProblemFindSingleNumber {

    public int singleNumber(int[] nums) {
        if(nums.length == 1) return nums[0];
        Arrays.sort(nums);
        if(nums[0]!=nums[1]) return nums[0];
        for (int i = 1; i < nums.length-1; i++) {
            if(nums[i]!=nums[i+1] && nums[i]!=nums[i-1]) return nums[i];
        }
        return nums[nums.length-1];
    }

    public int singleNumber1(int[] nums) {
        int a = 0;
        int b = 0;

        for(int num : nums) {
            a = (a ^ num) & ~b;
            b = (b ^ num) & ~a;
        }

        return a;
    }

    public static void main(String[] args) {
//        System.out.println(new ProblemFindSingleNumber().singleNumber1(new int[]{3,3,4,3}));
        System.out.println(Integer.toBinaryString(-2));

    }
}
