package org.yuhang.algorithm.leetcode.unionfind;

import java.util.HashSet;
import java.util.Set;

/**
 * 求连续的最长序列长度,要求时间复杂度为O(n),128
 */
public class ProblemLongestConsecutiveSequence {


    public int longestConsecutive(int[] nums) {
       int res = 0;
       Set<Integer> set = new HashSet<>();
        for (int num:nums) {
            set.add(num);
        }

        for (int num:nums) {
            if(set.remove(num)){//判断元素在set中存不存在，存在则移除
                int pre = num-1,next = num+1;//pre为num前一个数字，next为num后一个数字，分别查找在set中是否存在，存在则继续遍历
                while (set.remove(pre)) pre--;
                while (set.remove(next)) next++;
                res = Math.max(res,next-pre-1);
            }
        }

        return res;
    }
}
