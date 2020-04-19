package org.yuhang.algorithm.review;

import java.util.*;

/**
 * 组合总数 LC39
 */
public class CombinationSumProblem {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
       List<List<Integer>> res = new ArrayList<>();
       if(candidates.length == 0) return new ArrayList<>(res);
       Arrays.sort(candidates);//排序，便于回溯时剪枝
       backtrace(candidates,new ArrayList<>(),0,target,res);
       return res;

    }

    private void backtrace(int[] candidates, List<Integer> list, int level, int target, List<List<Integer>> res) {
        if(target < 0) {
            return;
        }

        if(target == 0){
            res.add(new ArrayList<>(list));
            return;
        }

        //元素可以无限选取，则对每个元素都有可选与不选两个选项
        for (int i = level; i < candidates.length; i++) {
            if(target-candidates[i] < 0) break;//剪枝
            //选择i元素
            list.add(candidates[i]);
            backtrace(candidates,list,i,target-candidates[i],res);
            list.remove(list.size()-1);//回溯

        }
    }

    public static void main(String[] args) {
        int[] candidates = {2,3,5};

        new CombinationSumProblem().combinationSum(candidates,8);
    }
}
