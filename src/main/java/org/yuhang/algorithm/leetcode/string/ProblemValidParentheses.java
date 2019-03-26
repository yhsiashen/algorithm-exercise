package org.yuhang.algorithm.leetcode.string;

import java.util.Stack;

/**
 * 有效的括号  20
 */
public class ProblemValidParentheses {

    /**
     * s只包含'{','}','(',')','[',']',判断s是否为有效的括号
     * @param s
     * @return
     */
    public boolean isValid(String s) {
       if(s==null)
            return true;
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            String subStr = s.substring(i,i+1);
            if(subStr.equals("{") || subStr.equals("[") || subStr.equals("(")){
                stack.push(subStr);
            }else {
                if(!stack.isEmpty()) {
                    String compareStr = stack.pop();
                    switch (compareStr){
                        case "{":
                            if(!subStr.equals("}")) {
                                return false;
                            }else {
                                break;
                            }
                        case "[":
                            if(!subStr.equals("]")){
                                return false;
                            }else {
                                break;
                            }
                        case "(":
                            if(!subStr.equals(")")) {
                                return false;
                            }else {
                                break;
                            }
                        default:
                            return false;
                    }

                }else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(new ProblemValidParentheses().isValid("([)]"));
    }
}
