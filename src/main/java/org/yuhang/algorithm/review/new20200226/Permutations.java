package org.yuhang.algorithm.review.new20200226;

import java.util.ArrayList;
import java.util.List;

/**
 * 数组无重复数字，求其全排列
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 */
public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
       List<List<Integer>> res = new ArrayList<>();
       if(nums.length == 0) return res;
       boolean[] visited = new boolean[nums.length];
       dfs(nums,res,new ArrayList<>(),visited);
       return res;
    }

    private void dfs(int[] nums, List<List<Integer>> res, List<Integer> list, boolean[] visited){
        if(list.size() == nums.length){
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(!visited[i]) {
                list.add(nums[i]);
                visited[i] = true;
                dfs(nums, res, list,visited);
                list.remove(list.size()-1);
                visited[i] = false;
            }
        }
    }
}
