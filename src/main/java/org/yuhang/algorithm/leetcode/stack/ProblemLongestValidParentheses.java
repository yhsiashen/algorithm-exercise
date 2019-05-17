package org.yuhang.algorithm.leetcode.stack;


import java.util.Stack;

/**
 * 最长的有效括号  32
 */
public class ProblemLongestValidParentheses {

    /**
     * 只包含'(',')'的字符串,判断它的最长有效括号,如")()())"返回为4
     *  test case : ()(()->2, ())->2 ,()(())->6
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0)
            return 0;
        //有效括号的最长长度
        int res=0;
        //目前合法括号的起始位置
        int start = 0;
        char[] chars = s.toCharArray();
        Stack<Integer> stack = new Stack<>();
        //遍历字符数组,遇到'('将索引压栈,遇到')'判断
        for (int i = 0; i <chars.length; i++) {
            if(chars[i] == '('){
                stack.push(i);
            }else{
                if(stack.isEmpty()){
                    //合法括号的起始位置变为i+1
                    start = i+1;
                }else {
                    //弹出栈顶元素,再判断栈是否为空,为空则更新目前合法括号长度与res的最大值;不为空则为i-stack.peek()
                    stack.pop();
                    res = stack.isEmpty()? Math.max(res,i-start+1):Math.max(res,i-stack.peek());
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new ProblemLongestValidParentheses().longestValidParentheses("()(()"));
    }
}
