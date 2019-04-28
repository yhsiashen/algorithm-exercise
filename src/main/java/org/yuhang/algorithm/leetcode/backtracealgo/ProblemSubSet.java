package org.yuhang.algorithm.leetcode.backtracealgo;


import java.util.*;

/**
 * 求不重复的数组的所有子集  78
 */
public class ProblemSubSet {


    List<List<Integer>> allSolves = new ArrayList<>();
    int length = 0;

    /**
     * 递归法
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        if(nums.length == 0)
            return allSolves;
        length = nums.length;
        //从数组的开始判断
        Stack<Integer> stack = new Stack<>();
        findSubsets(nums,0,stack);
        return allSolves;
    }

    private void findSubsets(int[] nums,int count, Stack<Integer> stack){
        if(count == length){//找到一个子集，放入list中
           List<Integer> list = new ArrayList<>(stack);
           allSolves.add(list);
           return;
        }

        //选择nums[count]
        stack.push(nums[count]);
        //继续遍历后面的元素
        findSubsets(nums,count+1,stack);

        //不选择nums[count],将前面加入到stack中的元素pop出来，继续遍历后面的元素;
        stack.pop();
        findSubsets(nums,count+1,stack);
    }


    public static void main(String[] args) {
        int[] nums = {1,2,3};
        new ProblemSubSet().subsets(nums);
    }
}
