package org.yuhang.algorithm.leetcode.backtracealgo;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 找出数组中可以使数字和为target的所有组合  40
 */
public class ProblemCombinationSumII {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) return result;
        Arrays.sort(candidates);//排序，为了去重时能标记前一个元素
        findAllNums(candidates, 0, target, new ArrayList<>());
        return result;
    }

    private void findAllNums(int[] nums, int level, int target, List<Integer> list) {
        if (target == 0) {
            List<Integer> levelList = new ArrayList<>(list);
            result.add(levelList);
            return;
        }
        if (target < 0) {
            return;
        }
        //for循环从数组的第一个元素开始，考察所有可能性
        //在for循环标记被使用过的元素，在每轮深度递归中重置此值(即可重复选)
        int used = Integer.MIN_VALUE;
        //从第一个数字开始遍历，考察完所有情况得到满足要求的集合
        for (int i = level; i < nums.length; i++) {
            if(used == nums[i]) continue; //去重
            used = nums[i]; //标记此数字已被使用
            list.add(nums[i]);
            //不允许取重复数字
            findAllNums(nums, i + 1, target - nums[i], list);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] ca = {10, 1, 2, 7, 6, 1, 5};
        new ProblemCombinationSumII().combinationSum2(ca, 8);
    }
}
