package org.yuhang.algorithm.leetcode.array;

import java.util.HashSet;

/**
 * 判断数组中是否存在重复元素 LC219
 */
public class ProblemContainsDupII {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> set  = new HashSet<>();
        for (int i = 0; i < nums.length ; i++) {
            if(set.contains(nums[i])){
                return true;
            }
            set.add(nums[i]);
            if(set.size() > k){
                set.remove(nums[i-k]);
            }
        }

        return false;
    }

    public boolean containsNearbyDuplicate1(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j <= i+k; j++) {
                if(nums[j] == nums[i]) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,0,1,1};
        System.out.println(new ProblemContainsDupII().containsNearbyDuplicate1(nums,1));
    }
}
