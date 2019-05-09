package org.yuhang.algorithm.leetcode.stack;


import java.util.Stack;

/**
 * 逆波兰表达式求值  150
 */
public class ProblemEvalRPN {

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack();
        for (int i = 0; i < tokens.length; i++) {
            if("+".equals(tokens[i])){
                int a = stack.pop();
                int b = stack.pop();
                int res = b+a;
                stack.push(res);
            }else if("-".equals(tokens[i])){
                int a = stack.pop();
                int b = stack.pop();
                int res = b-a;
                stack.push(res);
            }else if("*".equals(tokens[i])){
                int a = stack.pop();
                int b = stack.pop();
                int res = b*a;
                stack.push(res);
            }else if("/".equals(tokens[i])){
                int a = stack.pop();
                int b = stack.pop();
                int res = b/a;
                stack.push(res);
            }else{
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        ProblemEvalRPN p = new ProblemEvalRPN();
        p.evalRPN(tokens);
    }
}
