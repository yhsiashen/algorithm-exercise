package org.yuhang.algorithm.review;

import java.util.ArrayList;
import java.util.List;

/**
 * 子集 LC78
 */
public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length == 0) return res;
        backtrace(nums,0,new ArrayList<>(),res);
        return res;
    }

    private void backtrace(int[] nums, int level, List<Integer> list, List<List<Integer>> res) {
        res.add(new ArrayList<>(list));

        for (int i = level; i <nums.length ; i++) {
            list.add(nums[i]);
            backtrace(nums,i+1,list,res);
            list.remove(list.size()-1);
        }

    }
}
