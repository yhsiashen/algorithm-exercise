package org.yuhang.algorithm.review;

import java.util.ArrayList;
import java.util.List;

/**
 * 全排列 LC46
 */
public class PermutationProblem {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        backtrace(nums,visited,new ArrayList<>(),res);
        return res;
    }

    private void backtrace(int[] nums, boolean[] visited, ArrayList<Integer> list, List<List<Integer>> res) {
        if(list.size() == nums.length){
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if(!visited[i]){
                visited[i] = true;
                list.add(nums[i]);
                backtrace(nums,visited,list,res);
                list.remove(list.size()-1);
                visited[i] = false;
            }
        }


    }
}
