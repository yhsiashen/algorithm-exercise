package org.yuhang.algorithm.review.new20200226;

/**
 * 消失的数字
 */
public class MissingNumber {

    public int missingNumber(int[] nums) {
        int n  = nums.length;
        int[] tmp = new int[n];
        for (int i = 0; i < n; i++) {
            tmp[nums[i]] = nums[i];
        }

        for (int i = 0; i < tmp.length; i++) {
            if(tmp[i]!=i) return i;
        }

        return 0;
    }

    public int missingNumber1(int[] nums){
        int n = nums.length;
        for (int i = 0; i < nums.length; i++) {
             n ^= i;
             n ^= nums[i];
        }
        return n;
    }
}
