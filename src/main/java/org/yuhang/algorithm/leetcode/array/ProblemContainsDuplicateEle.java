package org.yuhang.algorithm.leetcode.array;


import java.util.HashSet;
import java.util.Set;

/**
 * 判断是否存在重复元素 217
 */
public class ProblemContainsDuplicateEle {

    public boolean containsDuplicate(int[] nums) {
        if(nums.length==0)
            return false;
        Set<Integer> set = new HashSet<>();
        for (int i:nums) {
            set.add(i);
        }

        return set.size() != nums.length;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        System.out.println(new ProblemContainsDuplicateEle().containsDuplicate(nums));
    }
}
