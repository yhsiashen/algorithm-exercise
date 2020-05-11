package org.yuhang.algorithm.review;

import java.util.HashSet;
import java.util.Set;

/**
 * 最长连续序列 LC128
 */
public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num:nums){
            set.add(num);
        }
        int res = 0;
        for(int num:set){
            if(!set.contains(num-1)){
                int cur = num;
                int curLen = 1;
                while (set.contains(cur+1)){
                    cur++;
                    curLen++;
                }
                res = Math.max(res, curLen);
            }

        }

        return res;
    }
}
