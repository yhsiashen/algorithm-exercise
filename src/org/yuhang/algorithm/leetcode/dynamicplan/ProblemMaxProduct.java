package org.yuhang.algorithm.leetcode.dynamicplan;

/** 乘积的最大子序列
 * Created by chinalife on 2018/10/22.
 */
public class ProblemMaxProduct {

    public int maxProduct(int[] nums) {
        if(nums==null || nums.length ==0)
            return 0;
        int length = nums.length;
        //最大子序列乘积的数组
        int[] maxProduct = new int[length];
        maxProduct[0] = nums[0];
        int maxProducti = 1;
        for (int i = 1; i < length; i++) {
            //将maxProduct[i]初始化为i-1的值
            maxProduct[i] = maxProduct[i-1];
            for (int j = i; j >=0 ; j--) {
                maxProducti = maxProducti*nums[j];
                if(maxProducti >maxProduct[i-1]){
                    maxProduct[i] = maxProducti;
                }
            }
            maxProducti = 1;
        }
        return maxProduct[length-1];
    }

    public static void main(String[] args) {
        int[] nums = {0,2};
        System.out.println(new ProblemMaxProduct().maxProduct(nums));
    }
}
