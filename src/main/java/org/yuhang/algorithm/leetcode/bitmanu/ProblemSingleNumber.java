package org.yuhang.algorithm.leetcode.bitmanu;

import java.util.HashMap;
import java.util.Map;

/**
 * 找出数组中只出现一次的数字  136 位操作
 */
public class ProblemSingleNumber {

    /**
     * 异或运算
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res = res ^ nums[i];
        }
        return res;
    }

    /**
     * by hashmap
     * @param nums
     * @return
     */
    public int singleNumber1(int[] nums) {
       Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, 2);
            }
        }

        for (Integer i :map.keySet()) {
            if(map.get(i) == 1){
                return i;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,2,4,4};
        new ProblemSingleNumber().singleNumber(nums);
    }

}
