package org.yuhang.algorithm.review;

/**
 * 乘积小于K的子数组的数量 LC713
 */
public class NumsOfSubarrayProductLessThanK {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int l = 0, r= 0;
        int product = 1;
        int res = 0;
        while (r < nums.length){
            product *= nums[r];
            if(product < k){
                res += r-l;
            }
            while (product >= k){
                product /= nums[l];
                l++;
            }
            r++;

        }

        return res;
    }
}
