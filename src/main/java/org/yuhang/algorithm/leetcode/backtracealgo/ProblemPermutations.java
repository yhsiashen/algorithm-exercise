package org.yuhang.algorithm.leetcode.backtracealgo;

import java.util.ArrayList;
import java.util.List;


/**
 * 返回数组的全排列  LC46
 * @tag:回溯算法
 */
public class ProblemPermutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length == 0) return res;
        int[] visited = new int[nums.length];
        backtrace(nums,visited,new ArrayList<>(),res);
        return res;
    }

    private void backtrace(int[] nums,int[] visited, List<Integer> oneRes, List<List<Integer>> res){
        if(oneRes.size() == nums.length){ //一次遍历结束
            res.add(new ArrayList<>(oneRes));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(visited[i] == 1) continue; //该位置在此轮遍历中被访问过，跳过
            visited[i] = 1;//此轮遍历中标记为访问
            oneRes.add(nums[i]); //加入一次结果列表中
            backtrace(nums,visited,oneRes,res); //回溯找下一个未被访问的元素
            visited[i] = 0;//其他遍历中标记为未访问
            oneRes.remove(oneRes.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        new ProblemPermutations().permute(nums);
    }
}
