package org.yuhang.algorithm.review;

import java.util.HashMap;

/**
 * 乘积小于k的子数组
 */
public class SubarrayProductLessThanK {


    /**
     * 注意，此题无法用"前缀乘积",因为会整数溢出。
     * 由于nums为整数数组,对于乘积来说,是一个递增的序列,所以滑动窗口法可以"收敛"
     * @param nums
     * @param k
     * @return
     */
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int res = 0;
        int l = 0,r = 0;
        int mult = 1;
        while (r < nums.length){
            mult *= nums[r];
            while (mult >= k){
               mult /= nums[l++];
            }
            res += r-l+1;
            r++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {10,9,10,4,3,8,3,3,6,2,10,10,9,3};
        System.out.println(new SubarrayProductLessThanK().numSubarrayProductLessThanK(nums,19));
    }
}
