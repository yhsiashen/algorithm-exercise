package org.yuhang.algorithm.leetcode.backtracealgo;


import org.yuhang.algorithm.leetcode.array.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 返回数组的全排列，其中有重复数字 LC47
 * @tag:回溯算法
 */
public class ProblemPermutationsII {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length == 0) return res;
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums); //将数组按升序排列
        backtrace(nums,visited,new ArrayList<>(),res);
        return res;
    }

    private void backtrace(int[] nums, boolean[] visited , ArrayList<Integer> oneRes, List<List<Integer>> res) {
        if(oneRes.size() == nums.length) {
            res.add(new ArrayList<>(oneRes));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(visited[i]) continue; // 若被访问过了，则直接跳过
            if(i > 0 && nums[i] == nums[i-1] && !visited[i-1]) continue;
            visited[i] = true;
            oneRes.add(nums[i]);
            backtrace(nums,visited,oneRes,res); //递归找下一个元素
            visited[i] = false;
            oneRes.remove(oneRes.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2};
        new ProblemPermutationsII().permuteUnique(nums);
    }
}
