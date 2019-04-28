package org.yuhang.algorithm.leetcode.backtracealgo;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 找出无重复数组中所有可以使数字和为target的组合  39
 */
public class ProblemCombinationSum {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) return result;

        findallNum(candidates, 0, target, new ArrayList<>());
        return result;
    }

    /**
     * 递归法1
     * @param nums
     * @param level
     * @param target
     * @param combinationSum
     * @param stack
     */
    private void findallNum(int[] nums, int level, int target, int combinationSum, Stack<Integer> stack) {
        if (level == nums.length || combinationSum > target) return;  //遍历到数组结尾，则返回
        if (combinationSum == target) {
            List<Integer> list1 = new ArrayList<>(stack);
            result.add(list1);
            return;
        }
        combinationSum += nums[level];
        stack.push(nums[level]);
        //选择当前元素，继续遍历数组
        findallNum(nums, level, target, combinationSum, stack);

        combinationSum -= nums[level];
        stack.pop();
        //不选择当前元素，继续遍历后面的数组
        findallNum(nums, level + 1, target, combinationSum, stack);

    }


    /**
     * 递归法2
     * @param nums
     * @param level
     * @param target
     * @param list
     */
    private void findallNum(int[] nums,int level,int target,List<Integer> list){
        if(target == 0) {
            List<Integer> levelList= new ArrayList<>(list);
            result.add(levelList);
            return;
        }

        if(target < 0) return;  //剪枝

        for (int i = level; i < nums.length; i++) {
             list.add(nums[i]);
             findallNum(nums,i,target-nums[i],list);
             list.remove(list.size()-1);
        }

    }

    public static void main(String[] args) {
        int[] ca = {2, 3, 6, 7};
        new ProblemCombinationSum().combinationSum(ca, 7);

    }
}
