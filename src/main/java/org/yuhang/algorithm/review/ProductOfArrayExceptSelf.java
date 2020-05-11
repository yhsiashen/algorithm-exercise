package org.yuhang.algorithm.review;

/**
 * 数组中除自身外的乘积 LC238
 */
public class ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int[] preProduct = new int[nums.length];
        preProduct[0] = 1;
        int[] sufPreduct = new int[nums.length];
        for (int i = 1; i < nums.length; i++) {
            preProduct[i] = preProduct[i-1]*nums[i-1];
        }
        sufPreduct[nums.length-1] = 1;
        for (int i = nums.length-2; i >=0 ; i--) {
            sufPreduct[i] = sufPreduct[i+1]*nums[i+1];
        }
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = preProduct[i] * sufPreduct[i];
        }


        return res;
    }

    /**
     * 时间复杂度O(n),空间复杂度O(1)
     * @param nums
     * @return
     */
    public int[] productExceptSelf1(int[] nums) {
        int pre = 1;
        int suf = 1;
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
             res[i] = pre;
             pre *= nums[i];
        }

        for (int i = nums.length-1; i >=0 ; i--) {
            res[i] *= suf;
            suf *= nums[i];
        }

        return res;

    }

}
