package org.yuhang.algorithm.leetcode.backtracealgo;


import java.util.ArrayList;
import java.util.List;

/**
 * 找出所有相加之和为 n 的 k 个数的组合。
 * 组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字  216
 */
public class ProblemCombinationSumIII {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        if(k <= 0 || n <=0) return result;
        findAllNums(1,k ,n,new ArrayList<>());
        return result;
    }

    private void findAllNums(int level,int k, int target, ArrayList<Integer> list) {
        if(list.size() > k) return;  //超过k个元素直接剪枝
        if(target == 0 && list.size() == k) {  //找到了一组满足和为n的元素集合
             List<Integer> levelList = new ArrayList<>(list);
             result.add(levelList);
             return;
        }

        //从第一个元素开始考察所有情况
        for (int i = level; i <= 9; i++) {
            list.add(i);
            findAllNums(i+1,k,target-i,list);
            list.remove(list.size()-1);
        }
    }


    public static void main(String[] args) {
        new ProblemCombinationSumIII().combinationSum3(2,6);
    }

}
