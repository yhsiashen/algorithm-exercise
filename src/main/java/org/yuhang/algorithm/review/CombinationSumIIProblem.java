package org.yuhang.algorithm.review;

import org.yuhang.algorithm.leetcode.array.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 组合综合II LC40
 */
public class CombinationSumIIProblem {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(candidates.length == 0) return res;
        Arrays.sort(candidates);
        backtrace(candidates,0,new ArrayList<>(),target,res);
        return res;
    }

    private void backtrace(int[] candidates, int level, List<Integer> list, int target, List<List<Integer>> res) {
        if(target == 0){
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = level; i < candidates.length; i++) {
            if(i>level && candidates[i] == candidates[i-1]) continue;//去重
            if(target - candidates[i] < 0) break;//剪枝
            list.add(candidates[i]);
            backtrace(candidates,i+1,list,target-candidates[i],res);
            list.remove(list.size()-1);
        }

    }

    public static void main(String[] args) {
        int[] ca = {10,1,2,7,6,1,5};
        new CombinationSumIIProblem().combinationSum2(ca,8);
    }
}
