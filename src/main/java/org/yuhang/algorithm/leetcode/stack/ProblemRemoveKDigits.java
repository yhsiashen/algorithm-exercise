package org.yuhang.algorithm.leetcode.stack;

import java.util.Stack;

/**
 * 移除K位数字 LC402
 *
 */
public class ProblemRemoveKDigits {


    /**
     * 单调递增栈，栈顶最小，栈顶最大，从高位开始遍历数字，宗旨是高位尽可能小，遍历时，如果当前元素比栈顶元素小(高位元素)，
     * 则弹出栈顶元素，继续比较直到栈顶元素小于当前元素，则将当前元素入栈。当弹出了k个元素后满足题意，停止弹出，将后续所有数字压栈。
     * @param num
     * @param k
     * @return
     */
    public String removeKdigits(String num, int k) {
       Stack<Character> stack = new Stack<>();
       int n = num.length();
       if(k == n){
           return "0";
       }

       for (int i = 0; i < num.length(); i++) {
            while (k>=0 && !stack.isEmpty() && stack.peek() > num.charAt(i)){
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i));
        }

        while (k > 0){
            stack.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }
        sb.reverse();
        while (sb.length() > 1 && sb.charAt(0) == '0'){
            sb.deleteCharAt(0);
        }
       return sb.toString();
    }
}
