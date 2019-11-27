package org.yuhang.algorithm.leetcode.backtracealgo;


import java.util.*;

/**
 * 为表达式添加不同的括号以改变运算结果 LC241
 */
public class ProblemDifferentWaysToAddParentheses {

    private Map<String,List<Integer>> MAP = new HashMap();

    public List<Integer> diffWaysToCompute(String input) {
       if(MAP.containsKey(input)) return MAP.get(input); //用MAP做缓存，剪枝
       List<Integer> res = new ArrayList<>();
       for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if(c=='*' || c=='+' || c=='-'){
                List<Integer> left = diffWaysToCompute(input.substring(0,i)); //计算左边表达式结果
                List<Integer> right = diffWaysToCompute(input.substring(i+1)); //计算右边表达式结果
                for (int l:left){ //左、右两边的结果组合运算
                    for(int r:right){
                        switch (c){
                            case ('*'):
                                res.add(l * r);
                                break;
                            case ('+'):
                                res.add(l + r);
                                break;
                            case ('-'):
                                res.add(l - r);
                                break;
                            default:
                                break;
                        }
                    }
                }
            }
       }
       if(res.size() == 0) res.add(Integer.valueOf(input));//递归边界条件，input中只有数字，则直接当做结果返回
       MAP.put(input,res);
       return res;
    }
}
