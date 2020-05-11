package org.yuhang.algorithm.review;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 乘积的最大子数组 LC152
 */
public class MaximumProductSubarray {

    public int maxProduct(int[] nums) {
        int res = Integer.MIN_VALUE;
        int max = 1,min = 1;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] < 0){
                int tmp = max;
                max = min;
                min = tmp;
            }
            max = Math.max(max, max*nums[i]);
            min = Math.min(min, min*nums[i]);

            res = Math.max(res, max);
        }
        return res;
    }

    public static void main(String[] args) {
       List<String> list = new ArrayList<>();
       list.add("abc");
       list.add("ekj");
        System.out.println(list.toString());
    }
}
