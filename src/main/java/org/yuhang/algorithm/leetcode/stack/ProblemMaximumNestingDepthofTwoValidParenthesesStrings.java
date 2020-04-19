package org.yuhang.algorithm.leetcode.stack;

import java.util.Stack;

/**
 * 有效括号的嵌套深度 LC1111
 */
public class ProblemMaximumNestingDepthofTwoValidParenthesesStrings {

    /**
     * 栈模拟
     * @param seq
     * @return
     */
    public int[] maxDepthAfterSplit(String seq) {
        if(seq.length() == 0) return new int[]{};
        Stack<Character> stackA = new Stack<>();
        Stack<Character> stackB = new Stack<>();
        int[] res = new int[seq.length()];
        for (int i = 0; i < seq.length(); i++) {
            if(seq.charAt(i) == '('){
                if(stackA.isEmpty()){
                    stackA.push('(');
                    res[i] = 0;
                }else if(stackB.isEmpty()){
                    stackB.push('(');
                    res[i] = 1;
                }else{
                    if(stackA.size() <= stackB.size()){
                        stackA.push('(');
                        res[i] = 0;
                    }else{
                        stackB.push('(');
                        res[i] = 1;
                    }
                }
            }else{
                if(!stackB.isEmpty()){
                    stackB.pop();
                    res[i] = 1;
                }else if(!stackA.isEmpty()){
                    stackA.pop();
                    res[i] = 0;
                }
            }
        }
        return res;
    }

    /**
     * 不用真实的栈，用嵌套深度代替
     * @param seq
     * @return
     */
    public int[] maxDepthAfterSplit1(String seq) {
        int[] res = new int[seq.length()];
        int nestDepth = 0;//嵌套深度
        for (int i = 0; i < seq.length(); i++) {
             if(seq.charAt(i) == '('){
                 nestDepth++;//遇到左括号，嵌套深度+1
                 res[i] = nestDepth&1;//嵌套深度为偶数,则给A;否则给B
             }else{
                 nestDepth--;//遇到右括号，嵌套深度-1
                 res[i] = (nestDepth+1)&1;
             }
        }
        return res;
    }

}
