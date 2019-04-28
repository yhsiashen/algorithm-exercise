package org.yuhang.algorithm.leetcode.backtracealgo;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 返回1...n中所有可能的k个数的组合  77
 */
public class ProblemCombine {
  public List<List<Integer>> combine(int n, int k) {
    List<List<Integer>> result = new ArrayList<>();
        if(n <= 0 || k <= 0) return result;
        findkCombine1(n,1,k,new Stack<>(),result);
        return result;
    }


    /**
     * 递归法1
     * @param total
     * @param n
     * @param k
     * @param stack
     * @param result
     */
    private void findkCombine(int total,int n, int k, Stack<Integer> stack, List<List<Integer>> result) {
       if(stack.size() == k){
           List<Integer> list = new ArrayList<>(stack);
           result.add(list);
           return;
       }
       if(n>total) return;
       //选择当前元素
       stack.push(n);
       //继续遍历后面元素
       findkCombine(total,n+1,k,stack,result);
       //不选择当前元素
       stack.pop();
       findkCombine(total,n+1,k,stack,result);
    }

    /**
     * 递归法2
     * @param total
     * @param n
     * @param k
     * @param stack
     * @param result
     */
    private void findkCombine1(int total,int n, int k, Stack<Integer> stack, List<List<Integer>> result){
      if(stack.size() == k) {
          //保留此时stack的状态并加入result中
          List<Integer> list = new ArrayList<>(stack);
          result.add(list);
      }
        //i从n(n=1,2,3...total)开始
        for (int i = n; i <=total ; i++) {
           stack.push(i);
           findkCombine1(total,i+1,k,stack,result);
           stack.pop();
        }
    }

    public static void main(String[] args) {
        new ProblemCombine().combine(4,2);
    }
}
