package org.yuhang.algorithm.leetcode.backtracealgo;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 求存在重复数字的数组中的所有子集  90
 */
public class ProblemSubsetII {

    List<List<Integer>> allSolves = new ArrayList<>();
    int length = 0;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if(nums.length == 0)
            return allSolves;
        length = nums.length;
        Arrays.sort(nums);
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
        int currentEle = nums[count];
        int elementDup = 0;//统计重复元素的个数，不包含当前待选元素
        int i = count;
        //当数组中包含重复元素时，只有当目前的待选元素在栈中有k个时才选，否则不选
        while (i>0){
            if(nums[i-1] == currentEle) elementDup++;
            i--;
        }
        int elementDupInStack = 0;//统计栈中目前有多少个当前元素
        for (Integer j:stack) {
            if(j == currentEle) elementDupInStack++;
        }
        if(elementDup == elementDupInStack) {
            //选择nums[count]
            stack.push(nums[count]);
            //继续遍历后面的元素
            findSubsets(nums, count + 1, stack);
            //不选择nums[count],将前面加入到stack中的元素pop出来，继续遍历后面的元素;
            stack.pop();
        }
        findSubsets(nums,count+1,stack);
    }



    public static void main(String[] args) {
        int[] nums = {1,2,2};
        new ProblemSubsetII().subsetsWithDup(nums);
    }

}
