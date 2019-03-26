package org.yuhang.algorithm.leetcode.dynamicprogram;

/** 输出数组除自身以外的乘积 时间复杂度为O(n) 且不能用除法
 * Created by chinalife on 2018/10/24.
 */
public class ProblemProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        if(nums ==null || nums.length == 0||nums.length==1)
            return null;
        int l = nums.length;
        int[] output = new int[l];
        // 顺序遍历的结果
        int[] ord = new int[l];
        // 逆序遍历的结果
        int[] rev = new int[l];
        ord[0] = nums[0];
        rev[l-1] = nums[l-1];
        for (int i = 1; i < l; i++) {
            ord[i] = ord[i-1] * nums[i];
        }
        for (int i = l-2; i >=0 ; i--) {
            rev[i] = rev[i+1] * nums[i];
        }
        for (int i = 1; i < l-1; i++) {
            output[i] = ord[i-1] * rev[i+1];
        }

        output[0] = rev[1];
        output[l-1] = ord[l-2];
        return output;
    }
}
