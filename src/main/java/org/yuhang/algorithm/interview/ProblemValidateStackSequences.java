package org.yuhang.algorithm.interview;

import java.util.Stack;

/**
 * 判断序列是否为栈的弹出序列
 */
public class ProblemValidateStackSequences {


    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for(int num:pushed){
            stack.push(num);
            while (j<popped.length && !stack.isEmpty() && stack.peek() == popped[j]){
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        int[] pushed = {4,0,1,2,3};
        int[] poped = {4,2,3,0,1};
        System.out.println(new ProblemValidateStackSequences().validateStackSequences(pushed,poped));
    }
}
