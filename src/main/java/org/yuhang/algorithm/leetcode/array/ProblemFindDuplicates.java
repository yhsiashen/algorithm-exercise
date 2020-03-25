package org.yuhang.algorithm.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 数组中重复的数字 LC442
 */
public class ProblemFindDuplicates {

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res =  new ArrayList<>();
        if(nums.length == 0) return res;
        for (int num:nums){
            num = Math.abs(num);
            if(nums[num-1] > 0){
                nums[num-1] *= -1;
            }else{
                res.add(num);
            }
        }
        return res;
    }
}
